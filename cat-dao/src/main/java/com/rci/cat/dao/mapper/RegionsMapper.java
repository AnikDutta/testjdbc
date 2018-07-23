package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class RegionsMapper implements ResultSetExtractor<Map<Integer, String>> {

	@Override
	public Map<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, String> regions = new HashMap<Integer, String>();
		while (rs.next()) {
			int regionID = rs.getInt("REGION_ID");
			if(regionID != 6 && regionID != 7){
				String regionDesc = rs.getString("REGION_DESC");
				if(regionDesc.equalsIgnoreCase("ASIAPAC")){
					regions.put(new Integer(regionID), "ASIA");
				}else{
					regions.put(new Integer(regionID), rs.getString("REGION_DESC"));
				}
			}
			
		}
		return regions;
	}

}
