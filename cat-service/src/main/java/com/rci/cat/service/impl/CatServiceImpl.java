
package com.rci.cat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.rci.cat.dao.CatDao;
import com.rci.cat.dao.entity.CurrencyOffice;
import com.rci.cat.model.ApiDataModel;
import com.rci.cat.model.CatJsonModel;
import com.rci.cat.model.CatPropertiesModel;
import com.rci.cat.model.CurrencyOfficeModel;
import com.rci.cat.model.UserInfoModel;
import com.rci.cat.model.UserMasterDetailsModel;
import com.rci.cat.service.CatService;
import com.rci.cat.service.helper.CatServiceHelper;
import com.rci.cat.service.mapper.CurrencyOfficeMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("catService")
public class CatServiceImpl implements CatService
{

    @Autowired
    private CatDao CatDao;
    
    @Autowired
    private CurrencyOfficeMapper currencyOfficeMapper;
    
    @Override
    public Map<String, String> getArpAndTierTypes(Map<String, Object> headers){
    	return CatDao.getArpAndTierTypes(headers);
    }
    
    @Override
    public CatJsonModel getInitData(String userID,Map<String, Object> headers){
    	CatJsonModel initData = new CatJsonModel();
    	ApiDataModel data = new ApiDataModel();
    	String errorCode = new String();
    	String message = new String();
    	String status = new String();
    	Map<Integer,String> regions = new HashMap<Integer, String>();
    	Map<Integer,Map<Integer,String>> regionLocaleMap = new HashMap<Integer,Map<Integer,String>>();
    	Map<Integer,String> rewardTypeMap = new HashMap<Integer,String>();
    	Map<Integer,Map<Integer,String>> rewardSubTypeMap = new HashMap<Integer,Map<Integer,String>>();
    	UserInfoModel userInfo = new UserInfoModel();
    	CatPropertiesModel catProperties = new CatPropertiesModel();
    	UserMasterDetailsModel userMasterDetails = new UserMasterDetailsModel();
    	userInfo = getUserInfo(userID,headers);
    	userMasterDetails.setArpDetails(CatDao.getArpAndTierTypes(headers));
    	userMasterDetails.setTierConfigTypes(CatDao.getTierConfigTypes(headers));
    	userMasterDetails.setAllLocalesMap(CatDao.getAllRegionLocales());
    	
    	regions = CatDao.getRegions();
		
		Iterator<Integer> regionIDSetItr = regions.keySet().iterator();
		while(regionIDSetItr.hasNext()){
			int regionID = regionIDSetItr.next().intValue();
			regionLocaleMap.put(new Integer(regionID), CatDao.getRegionLocales(regionID));
		}
		
		userMasterDetails.setOfferRegions(regions);
		userMasterDetails.setLocales(regionLocaleMap.get(new Integer(userInfo.getUserRegion())));
		
		userMasterDetails.setChannel(CatDao.getOfferChannels(headers));	
    	
		//Hard-coded in existing code. Not fetching from DB.
		userMasterDetails.setMembershipType(CatServiceHelper.getSortedMembershipTypes());
		
		userMasterDetails.setCurrencyCodes(CatDao.getCurrencyCodes(headers));
		
		List<CurrencyOffice> exchCurrOfficesEntity=CatDao.getCurrencyOfficeMap(headers).get(userInfo.getUserRegion());
		List<String> currencies = new ArrayList<String>();
		List<CurrencyOfficeModel> exchCurrOffices = new ArrayList<CurrencyOfficeModel>(); 
		
		for (CurrencyOffice currOffice : exchCurrOfficesEntity)
			currencies.add(currOffice.getCurrencyCode());
		
		for (CurrencyOffice CurrencyOfficeEntity: exchCurrOfficesEntity) {
			exchCurrOffices.add(currencyOfficeMapper.convertToResource(CurrencyOfficeEntity));
        }
		userMasterDetails.setExchCurrencyCodes(currencies);
		userMasterDetails.setCurrencyOfficeMapper(exchCurrOffices);
		
		rewardTypeMap = CatDao.getRewardTypes();		
		
		Iterator<Integer> rewardIDItr = rewardTypeMap.keySet().iterator();
		while(rewardIDItr.hasNext())
		{
			int rewardID = rewardIDItr.next().intValue();
			rewardSubTypeMap.put(new Integer(rewardID), CatDao.getRewardSubTypes(rewardID));
		}	
		userMasterDetails.setRewardTypes(rewardTypeMap);
		userMasterDetails.setRewardSubTypes(rewardSubTypeMap);
		
		userMasterDetails.setBedRoomCodes(CatDao.getBedRoomTypes());
		userMasterDetails.setErrorCodes(CatDao.getErrorCodes(headers));
				
    	data.setCatProperties(catProperties);
    	data.setUserInfo(userInfo);
    	data.setUserMasterDetails(userMasterDetails);
    	initData.setData(data);
    	initData.setErrorCode(errorCode);
    	initData.setMessage(message);
    	initData.setStatus(status);
    	return initData;
    }
    
    //@TODO - Move method to separate service class
    @Override
    public UserInfoModel getUserInfo(String userID,Map<String, Object> headers){
    	UserInfoModel userInfo = new UserInfoModel();
    	//TODO -- Call userService
    	userInfo.setUserID("ctrq678");
    	userInfo.setUserRegion("1");
    	userInfo.setUserRegionStr("NorthAmerica");
    	return userInfo;
    }
    
}
