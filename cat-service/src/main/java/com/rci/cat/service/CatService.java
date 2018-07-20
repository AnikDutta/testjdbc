
package com.rci.cat.service;

import java.util.List;
import java.util.Map;
import com.rci.cat.model.Cat;

public interface CatService {


    List<Cat> getCats(Map<String, Object> headers);

    Cat getCat(String Catid, Map<String, Object> headers);
    
    Map<String, String> getArpAndTierTypes(Map<String, Object> headers);

}
