
package com.rci.cat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.rci.cat.dao.CatDao;
import com.rci.cat.model.Cat;
import com.rci.cat.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("catService")
public class CatServiceImpl implements CatService
{

    @Autowired
    private CatDao CatDao;
   
    @Override
    public Map<String, String> getArpAndTierTypes(Map<String, Object> headers){
    	return CatDao.getArpAndTierTypes(headers);
    }
}
