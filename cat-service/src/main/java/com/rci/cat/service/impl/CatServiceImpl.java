
package com.rci.cat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.rci.cat.dao.CatDao;
import com.rci.cat.dao.entity.CatEntity;
import com.rci.cat.model.Cat;
import com.rci.cat.service.CatService;
import com.rci.cat.service.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CatService")
public class CatServiceImpl
    implements CatService
{

    @Autowired
    private CatDao CatDao;
    @Autowired
    private CatMapper CatMapper;

    @Override
    public List<Cat> getCats(Map<String, Object> headers) {
        List<Cat> CatList = new ArrayList<Cat>();
        for (CatEntity CatEntity: CatDao.getCats(headers)) {
            CatList.add(CatMapper.convertToResource(CatEntity));
        }
        return CatList;
    }

   
    @Override
    public Cat getCat(String Catid, Map<String, Object> headers) {
        return CatMapper.convertToResource(CatDao.getCat(Catid, headers));
    }

    @Override
    public Map<String, String> getArpAndTierTypes(Map<String, Object> headers){
    	return CatDao.getArpAndTierTypes();
    }
}
