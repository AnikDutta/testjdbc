package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ArpMapper implements ResultSetExtractor<Map<String, String>> {

	@Override
	public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, String> arpTierMap = new HashMap<String, String>();
		while (rs.next()) {
			arpTierMap.put(rs.getString("TIER_CD"), rs.getString("TIER_DESC"));
		}
		return arpTierMap;
	}

}
