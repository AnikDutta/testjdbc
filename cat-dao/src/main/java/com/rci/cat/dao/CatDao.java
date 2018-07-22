
package com.rci.cat.dao;

import java.util.List;
import java.util.Map;
import com.rci.cat.dao.entity.CatEntity;

public interface CatDao {
    
    Map<String, String> getArpAndTierTypes(Map<String, Object> headers);
    
    List<String> getTierConfigTypes(Map<String, Object> headers);
    
    Map<String,String> getOfferChannels(Map<String, Object> headers);
    
    Map<String, String> getErrorCodes(Map<String, Object> headers);
    
    List<String> getOfficeCodes(int regionID);

}
