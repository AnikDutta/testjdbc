
package com.rci.cat.service;

import java.util.Map;

import com.rci.cat.model.CatJsonModel;
import com.rci.cat.model.UserInfoModel;

public interface CatService {

	Map<String, String> getArpAndTierTypes(Map<String, Object> headers);
	CatJsonModel getInitData(String userID, Map<String, Object> headers);
	UserInfoModel getUserInfo(String userID,Map<String, Object> headers);
}
