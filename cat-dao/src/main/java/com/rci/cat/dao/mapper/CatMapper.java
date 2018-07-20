package com.rci.cat.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rci.cat.dao.entity.CatEntity;

public class CatMapper implements RowMapper<CatEntity> {

	public CatEntity mapRow(ResultSet rs, int rowNo) throws SQLException {
		CatEntity aircarft = new CatEntity();
		aircarft.setId(rs.getLong("ID"));
		aircarft.setCategory(rs.getString("CATEGORY"));
		aircarft.setDescription(rs.getString("DESCRIPTION"));
		aircarft.setIata(rs.getString("IATA"));
		aircarft.setIcao(rs.getString("ICAO"));
		aircarft.setType(rs.getString("TYPE"));
		return aircarft;
	}

}
