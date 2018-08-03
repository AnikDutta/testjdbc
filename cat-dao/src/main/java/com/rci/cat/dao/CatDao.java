
package com.rci.cat.dao;

import java.util.List;
import java.util.Map;

import com.rci.cat.dao.entity.CurrencyOffice;

public interface CatDao {
    
    Map<String, String> getArpAndTierTypes(Map<String, Object> headers);
    
    List<String> getTierConfigTypes(Map<String, Object> headers);
    
    Map<String,String> getOfferChannels(Map<String, Object> headers);
    
    Map<String, String> getErrorCodes(Map<String, Object> headers);
    
    List<String> getOfficeCodes(int regionID,Map<String, Object> headers);
    
    List<String> getOfficeCodes(int regionID,String source,Map<String, Object> headers);
    
    List<String> getCurrCodes(String offCode, Map<String, Object> headers);
    
    Map<Integer, String> getRegions();
    
    Map<Integer, String> getRewardSubTypes(int rewardID);
    
    Map<Integer, String> getRewardTypes();
    
    List<String> getBedRoomTypes();
    
    Map<Integer, String> getRegionLocales(int regionID);
    
    Map<Integer, String> getAllRegionLocales();
    
    List<String> getCurrencyCodes(Map<String, Object> headers);
    
    Map<String, List<CurrencyOffice>> getCurrencyOfficeMap(Map<String, Object> headers);

}
