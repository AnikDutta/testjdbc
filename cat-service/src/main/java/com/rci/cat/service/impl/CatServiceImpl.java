
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
public class CatServiceImpl implements CatService
{

    @Autowired
    private CatDao CatDao;
    @Autowired
    private CatMapper CatMapper;

   
    @Override
    public Map<String, String> getArpAndTierTypes(Map<String, Object> headers){
    	return CatDao.getArpAndTierTypes(headers);
    }
}
