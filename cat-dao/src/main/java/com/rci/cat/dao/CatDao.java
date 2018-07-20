
package com.rci.cat.dao;

import java.util.List;
import java.util.Map;
import com.rci.cat.dao.entity.CatEntity;

public interface CatDao {


    List<CatEntity> getCats(Map<String, Object> headers);

    Object postCat(CatEntity CatEntity, Map<String, Object> headers);

    CatEntity getCat(String Catid, Map<String, Object> headers);

    int putCat(CatEntity CatEntity, Map<String, Object> headers);

    int deleteCat(String Catid, Map<String, Object> headers);
    
    Map<String, String> getArpAndTierTypes();

}
