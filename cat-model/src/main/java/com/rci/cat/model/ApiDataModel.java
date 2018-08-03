package com.rci.cat.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class ApiDataModel implements Serializable{
	private UserInfoModel userInfo;
	private CatPropertiesModel catProperties;
	private UserMasterDetailsModel userMasterDetails;
	
	private OfferDto offerDto;
	private RewardBean rewardBean;
	
	public ApiDataModel() {
		super();
	}
	public ApiDataModel(UserInfoModel userInfo, CatPropertiesModel catProperties,
			UserMasterDetailsModel userMasterDetails) {
		super();
		this.userInfo = userInfo;
		this.catProperties = catProperties;
		this.userMasterDetails = userMasterDetails;
	}
	public UserInfoModel getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoModel userInfo) {
		this.userInfo = userInfo;
	}
	public CatPropertiesModel getCatProperties() {
		return catProperties;
	}
	public void setCatProperties(CatPropertiesModel catProperties) {
		this.catProperties = catProperties;
	}
	public UserMasterDetailsModel getUserMasterDetails() {
		return userMasterDetails;
	}
	public void setUserMasterDetails(UserMasterDetailsModel userMasterDetails) {
		this.userMasterDetails = userMasterDetails;
	}
	public OfferDto getOfferDto() {
		return offerDto;
	}
	public void setOfferDto(OfferDto offerDto) {
		this.offerDto = offerDto;
	}
	public RewardBean getRewardBean() {
		return rewardBean;
	}
	public void setRewardBean(RewardBean rewardBean) {
		this.rewardBean = rewardBean;
	}
}
