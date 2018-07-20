
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
import com.rci.cat.dao.util.IQuery;

@Repository
public class CatDaoImpl implements CatDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, String> getArpAndTierTypes(){
		
		Map<String, String> arpTierMap  = jdbcTemplate.query(IQuery.queryForArpCodes,new ArpMapper());
	
		return arpTierMap;	
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

	public Object postCat(CatEntity CatEntity, Map<String, Object> headers) {
		String query = IQuery.queryForCreate;
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, new String[] { "ID" });
				ps.setString(1, CatEntity.getIata());
				ps.setString(2, CatEntity.getIcao());
				ps.setString(3, CatEntity.getDescription());
				ps.setString(4, CatEntity.getType());
				ps.setString(5, CatEntity.getCategory());
				return ps;
			}
		};
		jdbcTemplate.update(psc, generatedKeyHolder);
		Long generatedId = (generatedKeyHolder.getKey() != null ? generatedKeyHolder.getKey().longValue() : null);
		return generatedId;
	}

	public CatEntity getCat(String Catid, Map<String, Object> headers) {
		String query = IQuery.queryForGetById;
		List<CatEntity> Cats = jdbcTemplate.query(query, new Object[] { Catid }, new CatMapper());
		if (Cats.size() == 1) {
			return Cats.get(0);
		}
		return null;
	}

	public int putCat(CatEntity CatEntity, Map<String, Object> headers) {
		String SQL = IQuery.queryForUpdate;
		return jdbcTemplate.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL);
				ps.setString(1, CatEntity.getIata());
				ps.setString(2, CatEntity.getIcao());
				ps.setString(3, CatEntity.getDescription());
				ps.setString(4, CatEntity.getType());
				ps.setString(5, CatEntity.getCategory());
				ps.setLong(6, CatEntity.getId());
				return ps;
			}
		});
	}

	public int deleteCat(String Catid, Map<String, Object> headers) {
		String sql = IQuery.queryForDelete;
		return jdbcTemplate.update(sql, Catid);
	}

	private String getUnderScoreSeparatedFromCamelCasing(String camelCasingWord) {
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, camelCasingWord);
	}

}
