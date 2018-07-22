
package com.rci.cat.dao.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.google.common.base.CaseFormat;

import com.rci.cat.dao.CatDao;
import com.rci.cat.dao.entity.CatEntity;
import com.rci.cat.dao.mapper.ArpMapper;
import com.rci.cat.dao.mapper.CatMapper;
import com.rci.cat.dao.mapper.CurrencyCodesMapper;
import com.rci.cat.dao.mapper.ErrorCodesMapper;
import com.rci.cat.dao.mapper.OfferChannelsMapper;
import com.rci.cat.dao.mapper.OfficeCodesMapper;
import com.rci.cat.dao.mapper.TierConfigTypesMapper;
import com.rci.cat.dao.util.IQuery;

@Repository
public class CatDaoImpl implements CatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, String> getArpAndTierTypes(Map<String, Object> headers){
		Map<String, String> arpTierMap  = jdbcTemplate.query(IQuery.queryForArpCodes,new ArpMapper());
		return arpTierMap;	
	}
	
	public List<String> getTierConfigTypes(Map<String, Object> headers){
		List<String> tierConfigTypes = jdbcTemplate.query(IQuery.tierConfigTypeSQL, new TierConfigTypesMapper());
		return tierConfigTypes;
	}
	
	public Map<String,String> getOfferChannels(Map<String, Object> headers){
    	Map<String,String> redemptionChannels = jdbcTemplate.query(IQuery.offerChannelSQL, new OfferChannelsMapper());
    	return redemptionChannels;
    }
	
	public Map<String, String> getErrorCodes(Map<String, Object> headers) {
		Map<String, String> errorCodesMap = jdbcTemplate.query(IQuery.errorCodesSQL, new ErrorCodesMapper());
		return errorCodesMap;
	}
	
	public List<String> getCurrencyCodes(Map<String, Object> headers) {
		List<String> currencyCodesList = jdbcTemplate.query(IQuery.currencySQL, new CurrencyCodesMapper());
		return currencyCodesList;
	}
	
	public List<String> getOfficeCodes(int regionID, Map<String, Object> headers){
		String query = IQuery.offCodeSQL;
		List<String> offCodesList = jdbcTemplate.query(query, new Object[]{regionID}, new OfficeCodesMapper());
		return offCodesList;
	}
	
	public List<String> getOfficeCodes(int regionID,String source,Map<String, Object> headers){
		String query = IQuery.offCodeSQLforSource;
		List<String> offCodesList = jdbcTemplate.query(query, new Object[]{regionID}, new OfficeCodesMapper());
		return offCodesList;
	}
	
	public List<CatEntity> getCats(Map<String, Object> headers) {
		StringBuffer query = new StringBuffer();
		Class<CatEntity> CatClass = CatEntity.class;
		Field[] fields = CatClass.getDeclaredFields();
		List<String> paramNames = new ArrayList<String>();
		List<String> paramValues = new ArrayList<String>();

		for (Field field : fields) {
			String fieldName = field.getName();
			if (headers.containsKey(fieldName)) {
				paramNames.add(fieldName);
				paramValues.add((String) headers.get(fieldName));
			}
		}
		query.append(IQuery.queryForGetAll);
		if (paramNames.size() > 0) {
			query.append(" WHERE ");
			for (int i = 0; i < paramNames.size(); i++) {
				if (i == paramNames.size() - 1) {
					query.append(getUnderScoreSeparatedFromCamelCasing(paramNames.get(i))).append(" LIKE ? ");
				} else {
					query.append(getUnderScoreSeparatedFromCamelCasing(paramNames.get(i))).append(" LIKE ? AND ");
				}
			}
		}
		List<CatEntity> Cats = jdbcTemplate.query(query.toString(), paramValues.toArray(),
				new CatMapper());
		return Cats;
	}

	
	private String getUnderScoreSeparatedFromCamelCasing(String camelCasingWord) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, camelCasingWord);
	}

}
