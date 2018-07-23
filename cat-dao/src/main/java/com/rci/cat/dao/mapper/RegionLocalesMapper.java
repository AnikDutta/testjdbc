package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class RegionLocalesMapper implements ResultSetExtractor<Map<Integer, String>> {

	@Override
	public Map<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<Integer, String> locales = new HashMap<Integer, String>();
		while (rs.next()) {
			locales.put((Integer) rs.getInt("LOCALE_ID"), rs.getString("LOCALE_CODE"));
		}
		return locales;
	}

}
