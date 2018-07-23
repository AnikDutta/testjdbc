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

public class ErrorCodesMapper implements ResultSetExtractor<Map<String,String>> {

	@Override
	public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, String> errorCodesMap = new HashMap<String, String>();
		while (rs.next()) {
			errorCodesMap.put(rs.getString("ERROR_CODE"), rs.getString("ERROR_DESCRIPTION"));
		}
		return errorCodesMap;
	}

}
