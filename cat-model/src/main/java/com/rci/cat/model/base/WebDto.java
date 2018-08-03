//package com.rci.cat.model.base;
//
//import java.util.List;
//import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.rci.cat.model.OfferDto;
//
//
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//public class WebDto {
//	
//	private DBMOfferBean dbmBean;
//	private List<RewardDetailsBean> rewardDetailsBeanList;
//	private SearchOfferBean searchOfferBean;
//	private UserGroupSelBean groupSelBean;
//	private List<RewardPopulationBean> rewardPopulationBeanList;
//	private OfferDto offerDto;
//	private List<TravelWindowBean> travelWindowBeanList;
//			
//	private Map<String, String> userGroupMap;
//	private String userRegion;
//	private String beanType;
//	private String errCode;
//	private String userID;
//	private String bedRoomType;
//	private String varPrice;
//	private String varCurrencyType;
//	private String actionType;
//	//private String prevString;
//	private String rewardType;
//	private String rewardStartDate;
//	private String rejectUserGrp;
//	private String rewardEndDate;
//	private String maxRedCount;
//	private List<String> servicingOfficeCodes;
//	private List<Long> rewardIdList;
//	private Boolean error;
//	private Integer term;
//	private Double percentOff;
//	private Boolean enrolledForAutoRenewal = false;
//	private String officeCodeAr = "";
//	private String discountAmountAr = "";
//	private String currencyTypeAr = "";
//	private String rewardTypeAr = "";
//	private Boolean platinumPreview = false;
//	private String standardDelay = "";	
//	
//	
//	
//	
//	
//	//end platinum preview
//	public List<RewardPopulationBean> getRewardPopulationBean() {
//		return rewardPopulationBeanList;
//	}
//
//	public void setRewardPopulationBean(
//			List<RewardPopulationBean> rewardPopulationBean) {
//		this.rewardPopulationBeanList = rewardPopulationBean;
//	}
//
//	public String getRejectUserGrp() {
//		return rejectUserGrp;
//	}
//
//	public void setRejectUserGrp(String rejectUserGrp) {
//		this.rejectUserGrp = rejectUserGrp;
//	}
//
//	public String getRewardStartDate() {
//		return rewardStartDate;
//	}
//
//	public void setRewardStartDate(String rewardStartDate) {
//		this.rewardStartDate = rewardStartDate;
//	}
//
//	public String getRewardEndDate() {
//		return rewardEndDate;
//	}
//
//	public void setRewardEndDate(String rewardEndDate) {
//		this.rewardEndDate = rewardEndDate;
//	}
//
//	public String getMaxRedCount() {
//		return maxRedCount;
//	}
//
//	public void setMaxRedCount(String maxRedCount) {
//		this.maxRedCount = maxRedCount;
//	}
//
//	public List<TravelWindowBean> getTravelWindowBeanList() {
//		return travelWindowBeanList;
//	}
//
//	public void setTravelWindowBeanList(
//			List<TravelWindowBean> travelWindowBeanList) {
//		this.travelWindowBeanList = travelWindowBeanList;
//	}
//
//	public List<Long> getRewardIdList() {
//		return rewardIdList;
//	}
//
//	public void setRewardIdList(List<Long> rewardIdList) {
//		this.rewardIdList = rewardIdList;
//	}
//
//	public List<RewardDetailsBean> getRewardDetailsBeanList() {
//		return rewardDetailsBeanList;
//	}
//
//	public void setRewardDetailsBeanList(
//			List<RewardDetailsBean> rewardDetailsBeanList) {
//		this.rewardDetailsBeanList = rewardDetailsBeanList;
//	}
//
//	public OfferDto getOfferDto() {
//		return offerDto;
//	}
//
//	public void setOfferDto(OfferDto offerDto) {
//		this.offerDto = offerDto;
//	}
//
//	public String getUserID() {
//		return userID;
//	}
//
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
//
//	public String getUserRegion() {
//		return userRegion;
//	}
//
//	public void setUserRegion(String userRegion) {
//		this.userRegion = userRegion;
//	}
//
//	public String getErrCode() {
//		return errCode;
//	}
//
//	public void setErrCode(String errCode) {
//		this.errCode = errCode;
//	}
//
//	/**
//	 * @return String ( Possible values DBM_USER , RM_USER , MKT_USER )
//	 */
//	public Map<String, String> getUserGroup() {
//		return userGroupMap;
//	}
//
//	/**
//	 * set String ( Possible values Possible values DBM_USER , RM_USER ,
//	 * MKT_USER )
//	 */
//	public void setUserGroup(Map<String, String> groupMap) {
//		this.userGroupMap = groupMap;
//	}
//
//	public String getBeanType() {
//		return beanType;
//	}
//
//	public void setBeanType(String beanType) {
//		this.beanType = beanType;
//	}
//
//	public UserGroupSelBean getGroupSelBean() {
//		return groupSelBean;
//	}
//
//	public void setGroupSelBean(UserGroupSelBean groupSelBean) {
//		this.groupSelBean = groupSelBean;
//	}
//
//	public DBMOfferBean getDbmBean() {
//		return dbmBean;
//	}
//
//	public void setDbmBean(DBMOfferBean dbmBean) {
//		this.dbmBean = dbmBean;
//	}
//
//	public SearchOfferBean getSearchOfferBean() {
//		return searchOfferBean;
//	}
//
//	public void setSearchOfferBean(SearchOfferBean searchOfferBean) {
//		this.searchOfferBean = searchOfferBean;
//	}
//
//	public String getBedRoomType() {
//		return bedRoomType;
//	}
//
//	public void setBedRoomType(String bedRoomType) {
//		this.bedRoomType = bedRoomType;
//	}
//
//	public String getVarPrice() {
//		return varPrice;
//	}
//
//	public void setVarPrice(String varPrice) {
//		this.varPrice = varPrice;
//	}
//
//	public String getVarCurrencyType() {
//		return varCurrencyType;
//	}
//
//	public void setVarCurrencyType(String varCurrencyType) {
//		this.varCurrencyType = varCurrencyType;
//	}
//
//	public String getActionType() {
//		return actionType;
//	}
//
//	public void setActionType(String actionType) {
//		this.actionType = actionType;
//	}
//
////	public String getPrevString() {
////		return prevString;
////	}
////
////	public void setPrevString(String prevString) {
////		this.prevString = prevString;
////	}
//
//	public String getRewardType() {
//		return rewardType;
//	}
//
//	public void setRewardType(String rewardType) {
//		this.rewardType = rewardType;
//	}
//
//	public Integer getTerm() {
//		return term;
//	}
//
//	public void setTerm(Integer term) {
//		this.term = term;
//	}
//
//	public Double getPercentOff() {
//		return percentOff;
//	}
//
//	public void setPercentOff(Double percentOff) {
//		this.percentOff = percentOff;
//	}
//
//	public List<String> getServicingOfficeCodes() {
//		return servicingOfficeCodes;
//	}
//
//	public void setServicingOfficeCodes(List<String> servicingOfficeCodes) {
//		this.servicingOfficeCodes = servicingOfficeCodes;
//	}
//
//	public Boolean isError() {
//		return error;
//	}
//
//	public void setError(Boolean error) {
//		this.error = error;
//	}
//
//	public Boolean isEnrolledForAutoRenewal() {
//		return enrolledForAutoRenewal;
//	}
//
//	public void setEnrolledForAutoRenewal(Boolean enrolledForAutoRenewal) {
//		this.enrolledForAutoRenewal = enrolledForAutoRenewal;
//	}
//
//	public String getDiscountAmountAr() {
//		return discountAmountAr;
//	}
//
//	public void setDiscountAmountAr(String discountAmountAr) {
//		this.discountAmountAr = discountAmountAr;
//	}
//
//	public String getCurrencyTypeAr() {
//		return currencyTypeAr;
//	}
//
//	public void setCurrencyTypeAr(String currencyTypeAr) {
//		this.currencyTypeAr = currencyTypeAr;
//	}
//
//	public String getRewardTypeAr() {
//		return rewardTypeAr;
//	}
//
//	public void setRewardTypeAr(String rewardTypeAr) {
//		this.rewardTypeAr = rewardTypeAr;
//	}
//
//	public String getOfficeCodeAr() {
//		return officeCodeAr;
//	}
//
//	public void setOfficeCodeAr(String officeCodeAr) {
//		this.officeCodeAr = officeCodeAr;
//	}
//
//	public boolean isPlatinumPreview() {
//		return platinumPreview;
//	}
//
//	public void setPlatinumPreview(boolean platinumPreview) {
//		this.platinumPreview = platinumPreview;
//	}
//
//	public String getStandardDelay() {
//		return standardDelay;
//	}
//
//	public void setStandardDelay(String standardDelay) {
//		this.standardDelay = standardDelay;
//	}
//	
//
//}
