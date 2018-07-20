package com.rci.cat.dao.util;

public interface IQuery {
	public String queryForGetAll = "SELECT * FROM Cat";
	public String queryForGetById = "SELECT * FROM Cat  where id = ?";
	public String queryForCreate = "INSERT INTO Cat (IATA, ICAO, DESCRIPTION, TYPE, CATEGORY) VALUES (?, ?, ?, ?, ?)";
	public String queryForUpdate = "update Cat set IATA = ?, ICAO = ? , DESCRIPTION = ?, TYPE = ?, CATEGORY = ?  where ID = ?";
	public String queryForDelete = "delete from Cat where ID = ?";
	public String queryForArpCodes = "SELECT TIER_CD, TIER_DESC FROM TIER where TIER_CD not in ('NA','All','StndAll')";
}
