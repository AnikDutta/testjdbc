package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.rci.cat.dao.CatDaoConstants;

public class OfferChannelsMapper implements ResultSetExtractor<Map<String,String>> {

	@Override
	public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, String> redemptionChannels = new LinkedHashMap<String, String>(10,1,false);
		while (rs.next()) {
			if(rs.getString(CatDaoConstants.CHANNEL_NAME)!=null){
				if(rs.getString(CatDaoConstants.CHANNEL_NAME).equalsIgnoreCase(CatDaoConstants.CC)){
					redemptionChannels.put(rs.getString(CatDaoConstants.CHANNEL_NAME).toUpperCase(), CatDaoConstants.CALL_CENTER);
				}else{
					redemptionChannels.put(rs.getString(CatDaoConstants.CHANNEL_NAME).toUpperCase(), rs.getString(CatDaoConstants.CHANNEL_NAME));
				}
			}				
		}
		return redemptionChannels;
	}

}
