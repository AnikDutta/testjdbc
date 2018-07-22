package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TierConfigTypesMapper implements ResultSetExtractor<List<String>> {

	@Override
	public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<String> tierConfigTypes = new ArrayList<String>();
		while (rs.next()) {
			tierConfigTypes.add(rs.getString("MBR_TIER_DESC"));
		}
		return tierConfigTypes;
	}

}
