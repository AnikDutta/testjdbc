package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchOfferBean {
	
	
	private Long offerUUID;
	private String offerCode;
	private String offerStatus;
	private String topPriorityVal;

	private String offerName;
	private List<String> offerType;
	private String offerTypeVal;
	private String dojoStartDate;
	private String dojoEndDate;
	private String localeVal;
	
	private Boolean topPriority;
	private String userId;
	private List<String> redemptionChannel;
	private List<String> membershipType;
	private List<String> tierTypeType;
	private String referenceNbr;
	private String offerLocale;
	private List<Long> offerLocales;
	
	private String createdUserID;
	private String updatedUserID;
	private String rewardStartDate;
	private String rewardEndDate;
	private List<String> offerRegion;
	private String offerRgn;
	private String rewardType;
	private String rewardSubType;
		

	public String getRewardSubType() {
		return rewardSubType;
	}
	public void setRewardSubType(String rewardSubType) {
		this.rewardSubType = rewardSubType;
	}

	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public long getOfferUUID() {
		return offerUUID;
	}
	public void setOfferUUID(long offerUUID) {
		this.offerUUID = offerUUID;
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

	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public List<String> getOfferType() {
		return offerType;
	}

	public void setOfferType(List<String> offerType) {
		this.offerType = offerType;
	}
	public String getOfferTypeVal() {
		return offerTypeVal;
	}

	public void setOfferTypeVal(String offerTypeVal) {
		this.offerTypeVal = offerTypeVal;
	}

	public String getDojoStartDate() {
		return dojoStartDate;
	}

	public void setDojoStartDate(String dojoStartDate) {
		this.dojoStartDate = dojoStartDate;
	}
	public String getDojoEndDate() {
		return dojoEndDate;
	}

	public void setDojoEndDate(String dojoEndDate) {
		this.dojoEndDate = dojoEndDate;
	}
	public String getLocaleVal() {
		return localeVal;
	}

	public void setLocaleVal(String localeVal) {
		this.localeVal = localeVal;
	}
	public boolean isTopPriority() {
		return topPriority;
	}

	public boolean getTopPriority() {
		return topPriority;
	}

	public void setTopPriority(boolean topPriority) {
		this.topPriority = topPriority;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getRedemptionChannel() {
		return redemptionChannel;
	}

	public void setRedemptionChannel(List<String> redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}

	
	public String getTopPriorityVal() {
		return topPriorityVal;
	}




	public void setTopPriorityVal(String topPriorityVal) {
		this.topPriorityVal = topPriorityVal;
	}
	
	public List<String> getMembershipType() {
		return membershipType;
	}




	public void setMembershipType(List<String> membershipType) {
		this.membershipType = membershipType;
	}




	public String getReferenceNbr() {
		return referenceNbr;
	}




	public void setReferenceNbr(String referenceNbr) {
		this.referenceNbr = referenceNbr;
	}




	public String getOfferLocale() {
		return offerLocale;
	}




	public void setOfferLocale(String offerLocale) {
		this.offerLocale = offerLocale;
	}




	public List<Long> getOfferLocales() {
		return offerLocales;
	}




	public void setOfferLocales(List<Long> offerLocales) {
		this.offerLocales = offerLocales;
	}




	public String getCreatedUserID() {
		return createdUserID;
	}




	public void setCreatedUserID(String createdUserID) {
		this.createdUserID = createdUserID;
	}




	public String getUpdatedUserID() {
		return updatedUserID;
	}




	public void setUpdatedUserID(String updatedUserID) {
		this.updatedUserID = updatedUserID;
	}


	public List<String> getOfferRegion() {
		return offerRegion;
	}

	public void setOfferRegion(List<String> offerRegion) {
		this.offerRegion = offerRegion;
	}

	public String getOfferRgn() {
		return offerRgn;
	}


	public void setOfferRgn(String offerRgn) {
		this.offerRgn = offerRgn;
	}


	public List<String> getTierTypeType() {
		return tierTypeType;
	}


	public void setTierTypeType(List<String> tierTypeType) {
		this.tierTypeType = tierTypeType;
	}

	public String getRewardStartDate() {
		return rewardStartDate;
	}

	public void setRewardStartDate(String rewardStartDate) {
		this.rewardStartDate = rewardStartDate;
	}

	public String getRewardEndDate() {
		return rewardEndDate;
	}

	public void setRewardEndDate(String rewardEndDate) {
		this.rewardEndDate = rewardEndDate;
	}
}