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
	public String offCurrCodeSQL = "SELECT CURRENCY FROM OFFICE_CURRENCY_LOOKUP WHERE SOURCE = 'EVS1' AND OFFICE_CODE=? AND REWARD_TYPE IN ('BOTH','RENEWAL')";
	public String rewardTypeSQL = "SELECT REWARD_TYPE_ID ,initcap(REWARD_TYPE_DESC) REWARD_DESCRIPTION FROM REWARD_TYPE";
	public String rewardSubTypeSQL = "SELECT REWARD_SUBTYPE_ID ,initcap(REWARD_SUBTYPE_DESC) REWARD_SUBTYPE_DESCRIPTION " + "FROM VW_REWARD_TYPE_SUBTYPE WHERE REWARD_TYPE_ID=?";
	public String bedRoomTypeSQL = "SELECT BEDROOM_CODE FROM Reward_Unit_Config";
	public String regionSQL = "SELECT REGION_ID, REGION_DESC FROM REGION";
	public String localeSQL = "SELECT L.LOCALE_ID, L.LOCALE_CODE FROM REGION_LOCALE RL, LOCALE L	WHERE RL.REGION_ID = ? AND RL.LOCALE_ID=L.LOCALE_ID AND L.active_flg='Y'";
	public String allLocaleSQL = "SELECT L.LOCALE_ID, L.LOCALE_CODE FROM REGION_LOCALE RL, LOCALE L WHERE RL.LOCALE_ID=L.LOCALE_ID AND L.active_flg='Y' order by LOCALE_CODE";
	public String OfferRegionLocalesSQL = "SELECT l.locale_code AS LOCALE FROM locale l, offer_locale ol, offer_promotion op, reward r WHERE l.locale_id = ol.locale_id AND ol.offer_id = op.offer_id AND op.promotion_id = r.promotion_id AND r.reward_id=?";
	public String currencyOfficeMapping = "SELECT REGION_ID, ISO_CURRENCY, SOURCE, OFFICE_CODE FROM OFFICE_CURRENCY_LOOKUP WHERE REWARD_TYPE IN ('BOTH', 'EXCHANGE') ORDER BY REGION_ID, ISO_CURRENCY, SOURCE ";
}
