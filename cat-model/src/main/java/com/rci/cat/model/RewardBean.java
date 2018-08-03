package com.rci.cat.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardBean {
	
	private RewardRenewalBean rewardRenewalBean;
	private RewardInventoryMKTBean rewardInventoryMktBean;
	private RewardInventoryRMBean rewardInventoryRmBean;
	private RewardLinkedBean rewardLinkedBean;
	private List<OfferTranslationBean> translationList;
	private List<LandingPageUrlBean> landingPageUrlBeanList = new ArrayList<LandingPageUrlBean>();
	private List<SearchCriteriaBean> searchCriteriaBeanList = new ArrayList<SearchCriteriaBean>();
	
	private Long rewardId;
	private String rewardType;
	private String rewardSubType;

	private String errorCode;
	private boolean isError;
	private String rewardStatus;
	private String rewardMKTStatus;
	private String rewardRMStatus;
	private String rewardDBMStatus;
	
	private int landingPageUrlListSize;
	
	private int translationListSize;
	private String rejectUserGroup;
	private List<Long> rewardIdList;
	private String rewardIds;
	private String fixedAmountOff;
		
	public String getRewardIds() {
		return rewardIds;
	}
	public void setRewardIds(String rewardIds) {
		this.rewardIds = rewardIds;
	}
	public List<Long> getRewardIdList() {
		return rewardIdList;
	}
	public void setRewardIdList(List<Long> rewardIdList) {
		this.rewardIdList = rewardIdList;
	}
	public String getRejectUserGroup() {
		return rejectUserGroup;
	}
	public void setRejectUserGroup(String rejectUserGroup) {
		this.rejectUserGroup = rejectUserGroup;
	}
	public int getLandingPageURLListSize() {
		int count=0;
		if(landingPageUrlBeanList!=null && landingPageUrlBeanList.size()>0)
		{
			count=count+landingPageUrlBeanList.size();
		}
		if(searchCriteriaBeanList!=null && searchCriteriaBeanList.size()>0)
		{
			count=count+searchCriteriaBeanList.size();
			
		}
		return count;
	}
	public int gettranslationListSize() {
		int count=0;
		if(translationList!=null && translationList.size()>0)
		{
			count= translationList.size();
		}
		return count;
	}
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
	public String getRewardSubType() {
		return rewardSubType;
	}
	public void setRewardSubType(String rewardSubType) {
		this.rewardSubType = rewardSubType;
	}
	public RewardRenewalBean getRewardRenewalBean() {
		return rewardRenewalBean;
	}
	public void setRewardRenewalBean(RewardRenewalBean rewardRenewalBean) {
		this.rewardRenewalBean = rewardRenewalBean;
	}
	
	public Long getRewardId() {
		return rewardId;
	}
	public void setRewardId(Long rewardId) {
		this.rewardId = rewardId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean getIsError() {
		return isError;
	}

	public void setIsError(boolean isError) {
		this.isError = isError;
	}
	public String getRewardStatus() {
		return rewardStatus;
	}
	public void setRewardStatus(String rewardStatus) {
		this.rewardStatus = rewardStatus;
	}

	public String getRewardMKTStatus() {
		return rewardMKTStatus;
	}
	public void setRewardMKTStatus(String rewardMKTStatus) {
		this.rewardMKTStatus = rewardMKTStatus;
	}
	public String getRewardRMStatus() {
		return rewardRMStatus;
	}
	public void setRewardRMStatus(String rewardRMStatus) {
		this.rewardRMStatus = rewardRMStatus;
	}
	public List<OfferTranslationBean> getTranslationList() {
		return translationList;
	}
	
	
	public String getRewardDBMStatus() {
		return rewardDBMStatus;
	}
	public void setRewardDBMStatus(String rewardDBMStatus) {
		this.rewardDBMStatus = rewardDBMStatus;
	}
	public void setTranslationList(List<OfferTranslationBean> translationList) {
		this.translationList = translationList;
	}
	public List<LandingPageUrlBean> getLandingPageUrlBeanList() {
		return landingPageUrlBeanList;
	}
	public void setLandingPageUrlBeanList(
			List<LandingPageUrlBean> landingPageUrlBeanList) {
		this.landingPageUrlBeanList = landingPageUrlBeanList;
	}
	public List<SearchCriteriaBean> getSearchCriteriaBeanList() {
		return searchCriteriaBeanList;
	}
	public void setSearchCriteriaBeanList(
			List<SearchCriteriaBean> searchCriteriaBeanList) {
		this.searchCriteriaBeanList = searchCriteriaBeanList;
	}
	public RewardLinkedBean getRewardLinkedBean() {
		return rewardLinkedBean;
	}
	public void setRewardLinkedBean(RewardLinkedBean rewardLinkedBean) {
		this.rewardLinkedBean = rewardLinkedBean;
	}
	public String getFixedAmountOff() {
		return fixedAmountOff;
	}
	public void setFixedAmountOff(String fixedAmountOff) {
		this.fixedAmountOff = fixedAmountOff;
	}
	
	
	public int getTranslationListSize() {
		return translationListSize;
	}
	public void setTranslationListSize(int translationListSize) {
		this.translationListSize = translationListSize;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public RewardInventoryMKTBean getRewardInventoryMktBean() {
		return rewardInventoryMktBean;
	}
	public void setRewardInventoryMktBean(RewardInventoryMKTBean rewardInventoryMktBean) {
		this.rewardInventoryMktBean = rewardInventoryMktBean;
	}
	public RewardInventoryRMBean getRewardInventoryRmBean() {
		return rewardInventoryRmBean;
	}
	public void setRewardInventoryRmBean(RewardInventoryRMBean rewardInventoryRmBean) {
		this.rewardInventoryRmBean = rewardInventoryRmBean;
	}
	public int getLandingPageUrlListSize() {
		return landingPageUrlListSize;
	}
	public void setLandingPageUrlListSize(int landingPageUrlListSize) {
		this.landingPageUrlListSize = landingPageUrlListSize;
	}
	
		
}
