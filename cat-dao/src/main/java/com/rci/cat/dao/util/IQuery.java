package com.rci.cat.dao.util;

public interface IQuery {
	public String queryForGetAll = "SELECT * FROM Cat";
	public String queryForGetById = "SELECT * FROM Cat  where id = ?";
	public String queryForCreate = "INSERT INTO Cat (IATA, ICAO, DESCRIPTION, TYPE, CATEGORY) VALUES (?, ?, ?, ?, ?)";
	public String queryForUpdate = "update Cat set IATA = ?, ICAO = ? , DESCRIPTION = ?, TYPE = ?, CATEGORY = ?  where ID = ?";
	public String queryForDelete = "delete from Cat where ID = ?";
	public String queryForArpCodes = "SELECT TIER_CD, TIER_DESC FROM TIER where TIER_CD not in ('NA','All','StndAll')";
	public String tierConfigTypeSQL = "SELECT MBR_TIER_DESC FROM TIER_CONFIG where MBR_TIER_DESC not in ('Not Available','Clubs Standard','All Member Tiers','Standard')";
	public String offerChannelSQL = "SELECT CHANNEL_ID, initcap(CHANNEL_NAME) CHANNEL_NAME FROM CHANNEL_TYPE order by initcap(CHANNEL_NAME) asc";
	public String errorCodesSQL = "SELECT ERROR_CODE, initcap(ERROR_DESCRIPTION) ERROR_DESCRIPTION FROM SOA_SERVICES_ERRORS where ERROR_CODE like 'BAT%'";
	public String currencySQL = "SELECT DISTINCT(CURRENCY_CODE) CURRENCY_CODE from PRICING_BAND";
	public String offCodeSQL = "SELECT DISTINCT(OFFICE_CODE) from OFFICE_CURRENCY_LOOKUP WHERE SOURCE = 'EVS1' AND REGION_ID =? AND REWARD_TYPE IN ('BOTH','RENEWAL')";
	
	public String offCodeSQLforSource = "SELECT DISTINCT(OFFICE_CODE) from OFFICE_CURRENCY_LOOKUP WHERE SOURCE = ? AND REGION_ID =? AND REWARD_TYPE IN ('BOTH','EXCHANGE')";
}
