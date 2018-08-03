package com.rci.cat.model;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OfferDto {
			
	
	private List<PromotionBean> promotionBeans;
	private List<TravelWindowBean> travelWindowBeans;
	
	private Integer localeSize;
	
	private Long offerUUID;
	private String offerCode;
	private String offerStatus = "";
	private Boolean topPriority;
	private String offerName;
	private String offerType;
	private String offerXMLID;
	private String errorCode;
	private Long clonedFrom;
	private Boolean isError;
	private String region;
	private String regionId;
	private List<Long> locales;
	
	private String offerStartDate;
	private String offerEndDate;
	private String depositByDate;
	private String offerCCEndDate;
	private String eventVal;
	private String contextVal;
	private String rewardVal;
	private String redemptionChannel;
	private String membershipType;
	
	private Boolean isPlatinumPreview;
	private String standardDelay;
	private Boolean isInclusionAudienceFile;
	private Boolean isExclusionAudienceFile;
	private Boolean isNoAudienceFile;
	private String tierType;
	private String audienceFileType = "";
	private String byepassUrl = "";	
	private Map<String, String> arpDetails;
	private List<String> tierTypeList;
	private List<String> platinumPreviewList;
	private Integer totalExtraRewardRows;
	private Map<Long, Long> redeemPercentValues;
	private List<String> offerXMLIDList;
		
	public Long getOfferUUID() {
		return offerUUID;
	}
	public void setOfferUUID(Long offerUUID) {
		this.offerUUID = offerUUID;
	}
	
	public List<String> getOfferXMLIDList() {
		return offerXMLIDList;
	}

	public void setOfferXMLIDList(List<String> offerXMLIDList) {
		this.offerXMLIDList = offerXMLIDList;
	}

	public Map<Long, Long> getRedeemPercentValues() {
		return redeemPercentValues;
	}

	public void setRedeemPercentValues(Map<Long, Long> redeemPercentValues) {
		this.redeemPercentValues = redeemPercentValues;
	}

	public Integer getTotalExtraRewardRows() {
		return totalExtraRewardRows;
	}

	public void setTotalExtraRewardRows(Integer totalExtraRewardRows) {
		this.totalExtraRewardRows = totalExtraRewardRows;
	}

	public String getByepassUrl() {
		return byepassUrl;
	}

	public void setByepassUrl(String byepassUrl) {
		this.byepassUrl = byepassUrl;
	}

	public String getTierType() {
		return tierType;
	}

	public void setTierType(String tierType) {
		this.tierType = tierType;
	}

	public String getAudienceFileType() {
		return audienceFileType;
	}

	public void setAudienceFileType(String audienceFileType) {
		this.audienceFileType = audienceFileType;
	}

	public Boolean isInclusionAudienceFile() {
		return isInclusionAudienceFile;
	}

	public void setInclusionAudienceFile(Boolean isInclusionAudienceFile) {
		this.isInclusionAudienceFile = isInclusionAudienceFile;
	}

	public Boolean isExclusionAudienceFile() {
		return isExclusionAudienceFile;
	}

	public void setExclusionAudienceFile(Boolean isExclusionAudienceFile) {
		this.isExclusionAudienceFile = isExclusionAudienceFile;
	}

	public Boolean isNoAudienceFile() {
		return isNoAudienceFile;
	}

	public void setNoAudienceFile(Boolean isNoAudienceFile) {
		this.isNoAudienceFile = isNoAudienceFile;
	}

	public Boolean isPlatinumPreview() {
		return isPlatinumPreview;
	}

	public void setPlatinumPreview(Boolean isPlatinumPreview) {
		this.isPlatinumPreview = isPlatinumPreview;
	}

	public String getStandardDelay() {
		return standardDelay;
	}

	public void setStandardDelay(String standarDelay) {
		this.standardDelay = standarDelay;
	}
	public List<TravelWindowBean> getTravelWindowBeans() {
		return travelWindowBeans;
	}

	public void setTravelWindowBeans(List<TravelWindowBean> travelWindowBeans) {
		this.travelWindowBeans = travelWindowBeans;
	}

	public String getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(String offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public String getOfferEndDate() {
		return offerEndDate;
	}

	public void setOfferEndDate(String offerEndDate) {
		this.offerEndDate = offerEndDate;
	}

	public String getDepositByDate() {
		return depositByDate;
	}

	public void setDepositByDate(String depositByDate) {
		this.depositByDate = depositByDate;
	}

	public String getOfferCCEndDate() {
		return offerCCEndDate;
	}

	public void setOfferCCEndDate(String offerCCEndDate) {
		this.offerCCEndDate = offerCCEndDate;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public Boolean getIsError() {
		return isError;
	}

	public void setIsError(Boolean isError) {
		this.isError = isError;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	

	public String getOfferCode() {
		return offerCode;
	}

	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}

	public String getOfferStatus() {
		return offerStatus;
	}

	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}

	public String getOfferXMLID() {
		return offerXMLID;
	}

	public void setOfferXMLID(String offerXMLID) {
		this.offerXMLID = offerXMLID;
	}

	public Long getClonedFrom() {
		return clonedFrom;
	}

	public void setClonedFrom(Long clonedFrom) {
		this.clonedFrom = clonedFrom;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public List<PromotionBean> getPromotionBeans() {
		return promotionBeans;
	}

	public void setPromotionBeans(List<PromotionBean> promotionBean) {
		this.promotionBeans = promotionBean;
	}

	public Boolean isTopPriority() {
		return topPriority;
	}

	public void setTopPriority(Boolean topPriority) {
		this.topPriority = topPriority;
	}
	
	public String getEventVal() {
		return eventVal;
	}

	public void setEventVal(String eventVal) {
		this.eventVal = eventVal;
	}

	public String getContextVal() {
		return contextVal;
	}

	public void setContextVal(String contextVal) {
		this.contextVal = contextVal;
	}

	public String getRewardVal() {
		return rewardVal;
	}

	public void setRewardVal(String rewardVal) {
		this.rewardVal = rewardVal;
	}

	public String getRedemptionChannel() {
		return redemptionChannel;
	}

	public void setRedemptionChannel(String redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	public Map<String, String> getArpDetails() {
		return arpDetails;
	}

	public void setArpDetails(Map<String, String> arpDetails) {
		this.arpDetails = arpDetails;
	}
	public List<String> getTierTypeList() {
		return tierTypeList;
	}

	public void setTierTypeList(List<String> tierTypeList) {
		this.tierTypeList = tierTypeList;
	}
	public List<String> getPlatinumPreviewList() {
		return platinumPreviewList;
	}

	public void setPlatinumPreviewList(List<String> platinumPreviewList) {
		this.platinumPreviewList = platinumPreviewList;
	}

	public Boolean getIsPlatinumPreview() {
		return isPlatinumPreview;
	}

	public void setIsPlatinumPreview(Boolean isPlatinumPreview) {
		this.isPlatinumPreview = isPlatinumPreview;
	}

	public Boolean getIsInclusionAudienceFile() {
		return isInclusionAudienceFile;
	}

	public void setIsInclusionAudienceFile(Boolean isInclusionAudienceFile) {
		this.isInclusionAudienceFile = isInclusionAudienceFile;
	}

	public Boolean getIsExclusionAudienceFile() {
		return isExclusionAudienceFile;
	}

	public void setIsExclusionAudienceFile(Boolean isExclusionAudienceFile) {
		this.isExclusionAudienceFile = isExclusionAudienceFile;
	}

	public Boolean getIsNoAudienceFile() {
		return isNoAudienceFile;
	}

	public void setIsNoAudienceFile(Boolean isNoAudienceFile) {
		this.isNoAudienceFile = isNoAudienceFile;
	}

	public Boolean getTopPriority() {
		return topPriority;
	}

	public void setLocaleSize(Integer localeSize) {
		this.localeSize = localeSize;
	}

	
	public List<Long> getLocales() {
		return locales;
	}

	public void setLocales(List<Long> locales) {
		this.locales = locales;
	}
	public Integer getLocaleSize() {
		return localeSize;
	}

	
}
