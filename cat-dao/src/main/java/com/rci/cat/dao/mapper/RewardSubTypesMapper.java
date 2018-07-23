package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class RewardSubTypesMapper implements ResultSetExtractor<Map<Integer, String>> {

	@Override
	public Map<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, String> rewardSubTypeMap = new HashMap<Integer, String>();
		while (rs.next()) {
			rewardSubTypeMap.put(new Integer(rs.getString("REWARD_SUBTYPE_ID")), rs.getString("REWARD_SUBTYPE_DESCRIPTION").trim().toUpperCase());
		}
		return rewardSubTypeMap;
	}

}
