package com.rci.moor.cat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.rci.moor.cat.OfferConstants;
import com.rci.moor.cat.formbeans.CurrencyOffice;
import com.rci.moor.cat.formbeans.RewardSetupDataRequest;
import com.rci.moor.cat.formbeans.RewardSetupDataResponse;
import com.rci.moor.cat.formbeans.TranslationTierValidationBean;
//import com.rci.services.offer.contract.CurrencyOffice;
//import com.rci.services.offer.contract.RewardSetupDataRequest;
//import com.rci.services.offer.contract.RewardSetupDataResponse;
import com.rci.util.db.DBConnectionManager;

public class OfferDAO extends AbstractDAO {

	private static Logger log = Logger.getLogger(OfferDAO.class);
	protected Connection con = null;
	protected Connection odsCommonCon = null;
	protected PreparedStatement stmt = null;
	protected ResultSet rs = null;
	
	private enum MembershipType {
		PTS("POINTS"),
		WKS("WEEKS"),
		ALL("ALL"),
		CBS("CLBUS"),
		NA("NA");
		
		private String code;

		private MembershipType(String code){
			this.code = code;
		}
		public String getCode() {
			return code;
		}
	}

	public OfferDAO() {
		con = getConnection();
	//	odsCommonCon = getOdsCommonConnection();
	}

	/**
	 * Gets a database connection.
	 * 
	 * @return a database connection.
	 */
	public Connection getConnection() {

		try {
			con = DBConnectionManager.getODSConnection(OfferConstants.OFFERDATASOURCE);

			// log.info("DB URL= " +con.getMetaData().getURL());
		} catch (SQLException e) {
			log.error("SQLException while trying to connect to " + OfferConstants.OFFERDATASOURCE, e);
			con = null;
		}
		return con;
	}
	
	public Connection getOdsCommonConnection() {
		try {
			odsCommonCon = DBConnectionManager.getODSConnection(OfferConstants.ODSCOMMONDATASOURCE);
			// log.info("DB URL= " +con.getMetaData().getURL());
		} catch (SQLException e) {
			log.error("SQLException while trying to connect to "+OfferConstants.ODSCOMMONDATASOURCE, e);
			odsCommonCon = null;
		}
		return odsCommonCon;
	}
	

	public Map<String, String> getArpAndTierTypes() throws SQLException {
		Map<String, String> arpTierMap = new HashMap<String, String>();
		try {
			String arpCodesSQL = "SELECT TIER_CD, TIER_DESC FROM TIER where TIER_CD not in ('NA','All','StndAll')";
			// log.debug("errorCodesSQL= " +errorCodesSQL);
			stmt = con.prepareStatement(arpCodesSQL);
			rs = stmt.executeQuery(arpCodesSQL);
			log.debug("Arps and Tiers select statement has been executed");
			while (rs.next()) {
					arpTierMap.put(rs.getString("TIER_CD"), rs.getString("TIER_DESC"));
			}
			log.debug(">>>> Arps and Tiers: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		return arpTierMap;
	}
	
	
	public List<String> getTierConfigTypes() throws SQLException {
		List<String> tierConfigTypes = new ArrayList<String>();
		try {
			String tierTypeSQL = "SELECT MBR_TIER_DESC FROM TIER_CONFIG where MBR_TIER_DESC not in ('Not Available','Clubs Standard','All Member Tiers','Standard')";
			// log.debug("errorCodesSQL= " +errorCodesSQL);
			stmt = con.prepareStatement(tierTypeSQL);
			rs = stmt.executeQuery(tierTypeSQL);
			log.debug("Tier Config types select statement has been executed");
			while (rs.next()) {
				tierConfigTypes.add(rs.getString("MBR_TIER_DESC"));
			}
			log.debug(">>>> Tier Config types : Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		return tierConfigTypes;
	}
	
	public Map<Integer, String> getOfferTypes() throws SQLException {
		Map<Integer, String> offerTypes = new HashMap<Integer, String>();
		/*
		 * try { String offerTypeSQL =
		 * "SELECT OFFER_TYPE_ID, initcap(OFFER_TYPE_DESC) OFFER_TYPE_DESC FROM OFFER_TYPE"
		 * ; //log.debug("offerTypeSQL= " +offerTypeSQL); stmt =
		 * con.prepareStatement(offerTypeSQL); rs =
		 * stmt.executeQuery(offerTypeSQL);
		 * log.debug("Offer Type select statement has been executed"); while
		 * (rs.next()) { offerTypes.put((Integer)rs.getInt("OFFER_TYPE_ID"),
		 * rs.getString("OFFER_TYPE_DESC")); }
		 * log.debug(">>>> Offer Type: Loaded Sucessfully"); } catch
		 * (SQLException e) { log.error(e); throw e; }
		 */
		return offerTypes;
	}

    public Map<String,String> getOfferChannels() throws SQLException
    {
    	Map<String,String> redemptionChannels = new LinkedHashMap<String, String>(10,1,false);
    	try {
			String channelSQL = "SELECT CHANNEL_ID, initcap(CHANNEL_NAME) CHANNEL_NAME FROM CHANNEL_TYPE order by initcap(CHANNEL_NAME) asc";
			//log.debug("channelSQL= " +channelSQL);
			stmt = con.prepareStatement(channelSQL);
			rs = stmt.executeQuery(channelSQL);
			log.debug("Offer Channel select statement has been executed");
			while (rs.next()) {
				if(rs.getString("CHANNEL_NAME")!=null){
					if(rs.getString("CHANNEL_NAME").equalsIgnoreCase(OfferConstants.CC)){
						redemptionChannels.put(rs.getString("CHANNEL_NAME").toUpperCase(), OfferConstants.CALL_CENTER);
					}else{
						redemptionChannels.put(rs.getString("CHANNEL_NAME").toUpperCase(), rs.getString("CHANNEL_NAME"));
					}
				}				
			}
			log.debug(">>>> Offer Channel: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}	    	
    	return redemptionChannels;
    }

	
    @Deprecated
    public Map<Integer, String> getMembershipTypes() throws SQLException {
		Map<Integer, String> membershipTypes = new HashMap<Integer, String>();
		try {
			String membershipTypeSQL = "SELECT MEMBERSHIP_TYPE_ID, initcap(MEMBERSHIP_TYPE_DESC) MEMBERSHIP_TYPE_DESC FROM MEMBERSHIP_TYPE";
			// log.debug("membershipTypeSQL= " +membershipTypeSQL);
			stmt = con.prepareStatement(membershipTypeSQL);
			rs = stmt.executeQuery(membershipTypeSQL);
			log.debug("Offer MembershipTypes select statement has been executed");
			while (rs.next()) {
				membershipTypes.put((Integer) rs.getInt("MEMBERSHIP_TYPE_ID"), rs.getString("MEMBERSHIP_TYPE_DESC"));
			}
			log.debug(">>>> Offer MembershipTypes: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return membershipTypes;
	}

	public Map<String, String> getErrorCodes() throws SQLException {
		Map<String, String> errorCodesMap = new HashMap<String, String>();
		try {
			String errorCodesSQL = "SELECT ERROR_CODE, initcap(ERROR_DESCRIPTION) ERROR_DESCRIPTION FROM SOA_SERVICES_ERRORS where ERROR_CODE like 'BAT%'";
			// log.debug("errorCodesSQL= " +errorCodesSQL);
			stmt = con.prepareStatement(errorCodesSQL);
			rs = stmt.executeQuery(errorCodesSQL);
			log.debug("Error Code select statement has been executed");
			while (rs.next()) {
				errorCodesMap.put(rs.getString("ERROR_CODE"), rs.getString("ERROR_DESCRIPTION"));
			}
			log.debug(">>>> Error Code: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return errorCodesMap;
	}

	public List<String> getCurrencyCodes() throws SQLException {
		List<String> currencyCodesList = new ArrayList<String>();
		try {
			String currencySQL = "SELECT DISTINCT(CURRENCY_CODE) CURRENCY_CODE from PRICING_BAND";
			// log.debug("currencySQL= " +currencySQL);
			stmt = con.prepareStatement(currencySQL);
			rs = stmt.executeQuery(currencySQL);
			log.debug("Currency codes select statement has been executed");
			while (rs.next()) {
				currencyCodesList.add(rs.getString("CURRENCY_CODE"));
			}
			if (currencyCodesList != null && currencyCodesList.size() > 0) {
				currencyCodesList.add("Other");
			}
			log.debug(">>>> Currency codes: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return currencyCodesList;
	}

	public List<String> getOfficeCodes(int regionID) throws SQLException {
		List<String> offCodesList = new ArrayList<String>();

		try {
			String offCodeSQL = "SELECT DISTINCT(OFFICE_CODE) from OFFICE_CURRENCY_LOOKUP WHERE SOURCE = 'EVS1' AND REGION_ID =? AND REWARD_TYPE IN ('BOTH','RENEWAL')";
			// log.debug("offCodeSQL= " +offCodeSQL);
			stmt = con.prepareStatement(offCodeSQL);
			stmt.setInt(1, regionID);
			rs = stmt.executeQuery();
			log.debug("Office codes select statement has been executed");
			while (rs.next()) {
				offCodesList.add(rs.getString("OFFICE_CODE"));
			}

			log.debug(">>>> Office codes: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return offCodesList;
	}

	public List<String> getOfficeCodes(int regionID,String source) throws SQLException {
		List<String> offCodesList = new ArrayList<String>();

		try {
			String offCodeSQL = "SELECT DISTINCT(OFFICE_CODE) from OFFICE_CURRENCY_LOOKUP WHERE SOURCE = ? AND REGION_ID =? AND REWARD_TYPE IN ('BOTH','EXCHANGE')";
			// log.debug("offCodeSQL= " +offCodeSQL);
			stmt = con.prepareStatement(offCodeSQL);
			stmt.setString(1, source);
			stmt.setInt(2, regionID);
			rs = stmt.executeQuery();
			log.debug("Office codes select statement has been executed");
			while (rs.next()) {
				offCodesList.add(rs.getString("OFFICE_CODE"));
			}

			log.debug(">>>> Office codes: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return offCodesList;
	}
	
	public List<String> getCurrCodes(String offCode) throws SQLException {
		List<String> currCodes = new ArrayList<String>();

		try {
			String offCurrCodeSQL = "SELECT CURRENCY FROM OFFICE_CURRENCY_LOOKUP WHERE SOURCE = 'EVS1' AND OFFICE_CODE=? AND REWARD_TYPE IN ('BOTH','RENEWAL')";
			// log.debug("currencySQL= " +currencySQL);
			stmt = con.prepareStatement(offCurrCodeSQL);
			stmt.setString(1, offCode);
			rs = stmt.executeQuery();
			log.debug("Currency codes select statement has been executed");
			while (rs.next()) {
				String currCode = rs.getString("CURRENCY");
				currCodes.add(currCode);
			}
			log.debug(">>>> Office & Currency codes: Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return currCodes;
	}

	public Map<Integer, String> getRewardTypes() throws SQLException {
		Map<Integer, String> rewardTypeMap = new HashMap<Integer, String>();
		try {
			String rewardTypeSQL = "SELECT REWARD_TYPE_ID ,initcap(REWARD_TYPE_DESC) REWARD_DESCRIPTION FROM REWARD_TYPE";
			// log.debug("rewardTypeSQL= " +rewardTypeSQL);
			stmt = con.prepareStatement(rewardTypeSQL);
			rs = stmt.executeQuery(rewardTypeSQL);
			log.debug("Reward Type select statement has been executed");
			while (rs.next()) {
				rewardTypeMap.put(new Integer(rs.getString("REWARD_TYPE_ID")), rs.getString("REWARD_DESCRIPTION").trim().toUpperCase());

			}
			log.debug(">>>> Reward Type : Loaded Sucessfully");
		} catch (NumberFormatException e) {
			log.error(e);
			throw e;
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return rewardTypeMap;
	}

	public Map<Integer, String> getRewardSubTypes(int rewardID) throws SQLException {
		Map<Integer, String> rewardSubTypeMap = new HashMap<Integer, String>();
		try {
			String rewardSubTypeSQL = "SELECT REWARD_SUBTYPE_ID ,initcap(REWARD_SUBTYPE_DESC) REWARD_SUBTYPE_DESCRIPTION " + "FROM VW_REWARD_TYPE_SUBTYPE WHERE REWARD_TYPE_ID=?";
			// log.debug("rewardTypeSQL= " +rewardTypeSQL);
			stmt = con.prepareStatement(rewardSubTypeSQL);
			stmt.setInt(1, rewardID);
			rs = stmt.executeQuery();
			log.debug("Reward Sub Type select statement has been executed");
			while (rs.next()) {
				rewardSubTypeMap.put(new Integer(rs.getString("REWARD_SUBTYPE_ID")), rs.getString("REWARD_SUBTYPE_DESCRIPTION").trim().toUpperCase());
			}
			log.debug(">>>> Reward Sub Type : Loaded Sucessfully for rewardID=" + rewardID + " " + rewardSubTypeMap);
		} catch (NumberFormatException e) {
			log.error(e);
			throw e;
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return rewardSubTypeMap;
	}

	public List<String> getBedRoomTypes() throws SQLException {
		List<String> bedRoomCode = new ArrayList<String>();
		try {
			String bedRoomTypeSQL = "SELECT BEDROOM_CODE FROM Reward_Unit_Config";
			// log.debug("bedRoomTypeSQL= " +bedRoomTypeSQL);
			stmt = con.prepareStatement(bedRoomTypeSQL);
			rs = stmt.executeQuery(bedRoomTypeSQL);
			log.debug("BedRoom Codes select statement has been executed");
			while (rs.next()) {
				bedRoomCode.add(rs.getString("BEDROOM_CODE").trim());
			}
			log.debug(">>>> BedRoom Codes  : Loaded Sucessfully");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return bedRoomCode;
	}

	public Map<Integer, String> getRegions() throws SQLException {
		Map<Integer, String> regions = new HashMap<Integer, String>();
		try {
			String regionSQL = "SELECT REGION_ID, REGION_DESC FROM REGION";
			// log.debug("regionSQL= " +regionSQL);
			stmt = con.prepareStatement(regionSQL);
			//stmt = con.prepareStatement(regionSQL);
			rs = stmt.executeQuery(regionSQL);
			log.debug("Region select statement has been executed");
			while (rs.next()) {
				int regionID = rs.getInt("REGION_ID");
				if(regionID != 6 && regionID != 7){
					String regionDesc = rs.getString("REGION_DESC");
					log.debug("Region ID = " + regionID);
					if(regionDesc.equalsIgnoreCase("ASIAPAC")){
						regions.put(new Integer(regionID), "ASIA");
					}else{
						regions.put(new Integer(regionID), rs.getString("REGION_DESC"));
					}
				}
				
			}
			log.debug(">>>> Region : Loaded Sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
			throw e;
		}
		return regions;
	}

	public Map<Integer, String> getRegionLocales(int regionID) throws SQLException {
		Map<Integer, String> locales = new HashMap<Integer, String>();
		try {
			if (log.isDebugEnabled())
				log.debug(">>>> Region Locale: Loaded Sucessfully for WHERE REGION_ID = " + regionID);

			//String localeSQL = "SELECT RL.REGION_LOCALE_ID, L.LOCALE_CODE FROM REGION_LOCALE RL, LOCALE L WHERE RL.REGION_ID =? AND RL.LOCALE_ID=L.LOCALE_ID";
			String localeSQL = "SELECT L.LOCALE_ID, L.LOCALE_CODE FROM REGION_LOCALE RL, LOCALE L	WHERE RL.REGION_ID = ? AND RL.LOCALE_ID=L.LOCALE_ID AND L.active_flg='Y'";
			// log.debug("localeSQL= " +localeSQL);
			stmt = con.prepareStatement(localeSQL);
			stmt.setInt(1, new Integer(regionID));
			ResultSet localeRS = stmt.executeQuery();
			log.debug("Locale select statement has been executed");
			// Load Locale for specific region
			while (localeRS.next()) {
				locales.put((Integer) localeRS.getInt("LOCALE_ID"), localeRS.getString("LOCALE_CODE"));
			}
			log.debug(">>>> Region Locale: Loaded Sucessfully for WHERE REGION_ID = " + regionID);
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}
		return locales;
	}

	public Map<Integer, String> getAllRegionLocales() throws SQLException {
		Map<Integer, String> locales = new LinkedHashMap<Integer, String>();
		try {
			if (log.isDebugEnabled())
				log.debug(">>>> Region Locale: Loaded Sucessfully for all region");

			String localeSQL = "SELECT L.LOCALE_ID, L.LOCALE_CODE FROM REGION_LOCALE RL, LOCALE L WHERE RL.LOCALE_ID=L.LOCALE_ID AND L.active_flg='Y' order by LOCALE_CODE";
			// log.debug("localeSQL= " +localeSQL);
			stmt = con.prepareStatement(localeSQL);
			ResultSet localeRS = stmt.executeQuery();
			log.debug("Locale select statement has been executed");
			// Load Locale for specific region
			while (localeRS.next()) {
				locales.put((Integer) localeRS.getInt("LOCALE_ID"), localeRS.getString("LOCALE_CODE"));
			}
			log.debug(">>>> Region Locale: Loaded Sucessfully for all region");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		} finally {
			//odsCommonCon.close();
		}
		return locales;
	}

	/**
	 * Closes a database connection and a statement.
	 */
	public void cleanUp() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			log.error("Error Closing Statement", e);
		}
		try {
			if (con != null) {
				con.close();
			}
			//Modified for QC#8295
			if (odsCommonCon != null) {
				odsCommonCon.close();
			}
		} catch (Exception e) {
			log.error("Error Closing Connection", e);
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// Code Getting  From SP During EJB Convert WS  
	
	public RewardSetupDataResponse getRewardSetupData(RewardSetupDataRequest request) throws SQLException {
		if (log.isDebugEnabled())
			log.debug(">>>> START OfferEligibleDAOImpl.getRewardSetupData(): " + request);

		PreparedStatement ps = null;
		ResultSet rs = null;
		String SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION = "";
		String SQL_GET_CURRENCY_OFFICE_MAPPING = "";
		RewardSetupDataResponse response = new RewardSetupDataResponse();

		try {

			if (request.getRegionID() != null) {
				SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION = "SELECT REGION_ID, ISO_CURRENCY, SOURCE, OFFICE_CODE ";
				SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION += "FROM OFFICE_CURRENCY_LOOKUP  ";
				SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION += "WHERE REGION_ID = ? AND REWARD_TYPE IN ('BOTH', 'EXCHANGE') ";
				SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION += "ORDER BY REGION_ID, ISO_CURRENCY, SOURCE";
				ps = con.prepareStatement(SQL_GET_CURRENCY_OFFICE_MAPPING_FOR_REGION);
				ps.setString(1, request.getRegionID());
			} else {
				SQL_GET_CURRENCY_OFFICE_MAPPING = "SELECT REGION_ID, ISO_CURRENCY, SOURCE, OFFICE_CODE ";
				SQL_GET_CURRENCY_OFFICE_MAPPING += "FROM OFFICE_CURRENCY_LOOKUP ";
				SQL_GET_CURRENCY_OFFICE_MAPPING += "WHERE REWARD_TYPE IN ('BOTH', 'EXCHANGE') ";
				SQL_GET_CURRENCY_OFFICE_MAPPING += "ORDER BY REGION_ID, ISO_CURRENCY, SOURCE ";
				ps = con.prepareStatement(SQL_GET_CURRENCY_OFFICE_MAPPING);
			}
			rs = ps.executeQuery();

			Map<String, List<CurrencyOffice>> regionCurrOfficeMap = new HashMap<String, List<CurrencyOffice>>();

			while (rs.next()) {

				String prevRegion = rs.getString("REGION_ID");
				String prevCurrency = rs.getString("ISO_CURRENCY");
				String prevSource = rs.getString("SOURCE");
				String officeCode = rs.getString("OFFICE_CODE");

				List<String> offices = new ArrayList<String>();
				Map<String, List<String>> officeMap = new HashMap<String, List<String>>();
				List<CurrencyOffice> currOfficeMapping = new ArrayList<CurrencyOffice>();

				offices.add(officeCode);

				while (rs.next()) {

					String currRegion = rs.getString("REGION_ID");
					String currISOCurrency = rs.getString("ISO_CURRENCY");
					String currSource = rs.getString("SOURCE");
					officeCode = rs.getString("OFFICE_CODE");
					if (currRegion != null && !currRegion.equalsIgnoreCase(prevRegion)) {

						officeMap.put(prevSource, offices);
						CurrencyOffice currOffice = new CurrencyOffice();
						currOffice.setCurrencyCode(prevCurrency);
						currOffice.setOfficeCodes(officeMap);
						currOfficeMapping.add(currOffice);
						regionCurrOfficeMap.put(prevRegion, currOfficeMapping);
						if (log.isDebugEnabled())
							log.debug(" >>>>> Added mapping for region " + prevRegion + ": " + currOfficeMapping);

						prevRegion = currRegion;
						prevCurrency = currISOCurrency;
						prevSource = currSource;
						currOfficeMapping = new ArrayList<CurrencyOffice>();
						officeMap = new HashMap<String, List<String>>();
						offices = new ArrayList<String>();
						offices.add(officeCode);

					} else {
						if (currISOCurrency != null && currISOCurrency.equalsIgnoreCase(prevCurrency)) {
							if (currSource != null && currSource.equalsIgnoreCase(prevSource)) {
								// new office code for same region, currency and
								// source, add to the list
								offices.add(officeCode);
							} else {
								// Source changed, add it to the map
								officeMap.put(prevSource, offices);
								prevSource = currSource;
								offices = new ArrayList<String>();
								offices.add(officeCode);
							}
						} else {
							officeMap.put(prevSource, offices);
							CurrencyOffice currOffice = new CurrencyOffice();
							currOffice.setCurrencyCode(prevCurrency);
							currOffice.setOfficeCodes(officeMap);
							currOfficeMapping.add(currOffice);

							prevCurrency = currISOCurrency;
							prevSource = currSource;
							officeMap = new HashMap<String, List<String>>();
							offices = new ArrayList<String>();
							offices.add(officeCode);
						}
					}
				} //inner while

				officeMap.put(prevSource, offices);
				CurrencyOffice currOffice = new CurrencyOffice();
				currOffice.setCurrencyCode(prevCurrency);
				currOffice.setOfficeCodes(officeMap);
				currOfficeMapping.add(currOffice);
				regionCurrOfficeMap.put(prevRegion, currOfficeMapping);

			} // outer while
			response.setRegionCurrOfficeMap(regionCurrOfficeMap);

		} catch (SQLException sqlEx) {
			log.error("Error Info in getRewardSetupData: ", sqlEx);
			throw sqlEx;
			/*
			 * ArrayList<ErrorInfo> errorInfos = new ArrayList<ErrorInfo>();
			 * ErrorInfo errorInfo = new ErrorInfo();
			 * errorInfo.addExceptionText(sqlException.getMessage());
			 * errorInfos.add(errorInfo); response.setErrorInfos(errorInfos);
			 */
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		}

		log.debug("END OfferEligibleDAOImpl.getRewardSetupData(): " + response);
		return response;
	}
	// Merger for QC # 4906
	public List<String> getOfferRegionLocales(Long rewardId) throws SQLException {
		List<String> offerLocales  = new ArrayList<String>();
		try {
			if (log.isDebugEnabled())
				log.debug(">>>> Given RewardId from translation  = " + rewardId);
			String localeSQL = "SELECT l.locale_code AS LOCALE FROM locale l, offer_locale ol, offer_promotion op, reward r WHERE l.locale_id = ol.locale_id AND ol.offer_id = op.offer_id AND op.promotion_id = r.promotion_id AND r.reward_id=?";
			// log.debug("localeSQL= " +localeSQL);
			stmt = con.prepareStatement(localeSQL);
			stmt.setInt(1, rewardId.intValue());
			ResultSet localeRS = stmt.executeQuery();
			log.debug("Locale select statement has been executed");
			// Load Locale for specific region
			while (localeRS.next()) {
				if(localeRS.getString("LOCALE") != null){
					offerLocales.add(localeRS.getString("LOCALE").trim());	
				}
			}
			log.debug(">>>> Region Locale: Loaded Sucessfully for WHERE reward_id = " + rewardId);
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		return offerLocales;
	}
	
	public List<String> getARPCodes() throws SQLException {
		List<String> offerARPCodes  = new ArrayList<String>();
		try {
			
			String localeSQL = "SELECT DISTINCT(TIER_CD) AS ARPCODE FROM TIER";
			// log.debug("localeSQL= " +localeSQL);
			stmt = con.prepareStatement(localeSQL);
			
			ResultSet localeRS = stmt.executeQuery();
			log.debug("Locale select statement has been executed");
			// Load Locale for specific region
			while (localeRS.next()) {
				if(localeRS.getString("ARPCODE") != null){
					offerARPCodes.add(localeRS.getString("ARPCODE").trim());	
				}
			}
			log.debug(">>>> ARP Codes: Loaded Sucessfully ");
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		if(offerARPCodes.size() > 0 && offerARPCodes.contains("NA")){
			offerARPCodes.remove("NA");
		}
		return offerARPCodes;
	}
	
	public List<String> getOfferRegionARPCodes(Long rewardId) throws SQLException {
		List<String> offerARPCodes  = new ArrayList<String>();
		try {
			if (log.isDebugEnabled())
				log.debug(">>>> Given RewardId from translation  = " + rewardId);
			String localeSQL = "select T.TIER_CD AS ARPCODE FROM TIER T, TIER_CONFIG TC, OFFER_TIER_CONFIG OTC,offer_promotion op, reward r WHERE T.TIER_ID=TC.TIER_ID AND TC.TIER_CONFIG_ID=OTC.TIER_CONFIG_ID AND OTC.OFFER_ID=op.OFFER_ID AND op.promotion_id = r.promotion_id AND r.reward_id = ?";
			// log.debug("localeSQL= " +localeSQL);
			stmt = con.prepareStatement(localeSQL);
			stmt.setInt(1, rewardId.intValue());
			ResultSet localeRS = stmt.executeQuery();
			log.debug("ARP Code select statement has been executed");
			// Load Locale for specific region
			while (localeRS.next()) {
				if(localeRS.getString("ARPCODE") != null){
					offerARPCodes.add(localeRS.getString("ARPCODE").trim());	
				}
			}
			log.debug(">>>>ARP Codes: Loaded Sucessfully for WHERE reward_id = " + rewardId);
		} catch (SQLException e) {
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		return offerARPCodes;
	}
	
	public List<String> getMembershipTypesFromReward(Long rewardId) throws SQLException{
		List<String> membershipTypeList = new ArrayList<String>();
		
		//String getMembershipQuery = "";
		try{
			if(rewardId != null){
				/*getMembershipQuery =  "SELECT  mt.MEMBERSHIP_TYPE_DESC ";
				getMembershipQuery += "FROM membership_type mt, reward_member_type rmt,offer_promotion op, reward r, offer o ";
				getMembershipQuery += "WHERE mt.membership_type_id= rmt.member_type_id ";
				getMembershipQuery += "AND o.offer_id = op.offer_id ";
				getMembershipQuery += "AND op.promotion_id = r.promotion_id ";
				getMembershipQuery += "AND rmt.reward_id=r.reward_id ";
				getMembershipQuery += "AND r.reward_id = ?";*/
				
				String membershipQuery	= "SELECT MEMBER_TYPE_CODE from MEMBER_TYPE MT ,REWARD_MEMBER_TYPE RMT " +
						"WHERE MT.MEMBER_TYPE_ID = RMT.MEMBER_TYPE_ID AND REWARD_ID=?";
				
				stmt = con.prepareStatement(membershipQuery);
				stmt.setInt(1, rewardId.intValue());
				ResultSet membershipRS = stmt.executeQuery();
				
				while(membershipRS.next()){
					if(membershipRS.getString("MEMBER_TYPE_CODE") != null){
						membershipTypeList.add(MembershipType.valueOf(membershipRS.getString("MEMBER_TYPE_CODE")).getCode().toUpperCase());
					}
				}
			}
		} catch(SQLException e){
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		
		return membershipTypeList;
	}
	
	public String getOfferTierIndicator(Long rewardId) throws SQLException{
		String oferTierindicator =null;
		try{
			if(rewardId != null){
				String tierIndicatorQuery	= "SELECT O.TIER_PREVIEW_IND FROM OFFER O,REWARD R , OFFER_PROMOTION OP " +
						"WHERE O.OFFER_ID = OP.OFFER_ID AND OP.PROMOTION_ID = R.PROMOTION_ID AND  R.REWARD_ID =?";
				
				stmt = con.prepareStatement(tierIndicatorQuery);
				stmt.setInt(1, rewardId.intValue());
				ResultSet resultSet = stmt.executeQuery();
				
				while(resultSet.next()){
					if(resultSet.getString("TIER_PREVIEW_IND") != null){
						oferTierindicator = resultSet.getString("TIER_PREVIEW_IND");
					}
				}
			}
		} catch(SQLException e){
			log.error(e);
			throw e;
		}finally{
			cleanUp();
		}
		
		return oferTierindicator;
	}
	
	@Deprecated
	public List<TranslationTierValidationBean> getOfferMembershipDetails(Long rewardId) throws SQLException{
		
		List<TranslationTierValidationBean> offerMembershipDetailsList = new ArrayList<TranslationTierValidationBean>();
		
		

		String offerMembershipDetailsSQL = "";
		
		if(rewardId != null){
			try{
				offerMembershipDetailsSQL = "SELECT r.reward_id, mt.MEMBERSHIP_TYPE_DESC, tc.MBR_TIER_DESC, o.tier_preview_ind";
				offerMembershipDetailsSQL += " FROM membership_type mt, reward_member_type rmt, tier_config tc, offer_tier_config otc, offer_promotion op, reward r, offer o";
				offerMembershipDetailsSQL += " WHERE mt.membership_type_id= rmt.member_type_id";
				offerMembershipDetailsSQL += " AND tc.tier_config_id=otc.tier_config_id";
				offerMembershipDetailsSQL += " AND otc.offer_id = op.offer_id";
				offerMembershipDetailsSQL += " AND o.offer_id = op.offer_id";
				offerMembershipDetailsSQL += " AND op.promotion_id = r.promotion_id";
				offerMembershipDetailsSQL += " AND rmt.reward_id=r.reward_id";
				offerMembershipDetailsSQL += " AND r.reward_id = ?";
				
				stmt = con.prepareStatement(offerMembershipDetailsSQL);
				stmt.setInt(1, rewardId.intValue());
				ResultSet membershipRS = stmt.executeQuery();
				log.debug("Offer Membership Details select statement has been executed");
				
				while(membershipRS.next()){
					TranslationTierValidationBean transValidationBean = new TranslationTierValidationBean();
					if(membershipRS.getString("MBR_TIER_DESC") != null){
						transValidationBean.setTierType(membershipRS.getString("MBR_TIER_DESC"));
					}
					if(membershipRS.getString("MEMBERSHIP_TYPE_DESC") != null){
						transValidationBean.setMembershipType(membershipRS.getString("MEMBERSHIP_TYPE_DESC"));
					}
					if(membershipRS.getString("TIER_PREVIEW_IND") != null){
						transValidationBean.setTierPreviewInd(membershipRS.getString("TIER_PREVIEW_IND"));
					}
					
					offerMembershipDetailsList.add(transValidationBean);
				}
			}catch(SQLException e){
				log.error(e);
				throw e;
			}finally{
				cleanUp();
			}
		}
		
		return offerMembershipDetailsList;
		
	}
}
