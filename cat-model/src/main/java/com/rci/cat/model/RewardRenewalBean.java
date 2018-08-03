package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardRenewalBean {
		
	private String membershipType;
	private String redemptionChannel;
	private boolean landingPageURL;
	private boolean redeemOnce;
	private String displayCountDown;
	
	private String rewardStartDate;
	private String rewardEndDate;
	private String maxRedCount="1";
		
	public String getMaxRedCount() {
		return maxRedCount;
	}
	public void setMaxRedCount(String maxRedCount) {
		this.maxRedCount = maxRedCount;
	}
	public boolean isLandingPageURL() {
		return landingPageURL;
	}
	public void setLandingPageURL(boolean landingPageURL) {
		this.landingPageURL = landingPageURL;
	}
	public boolean isRedeemOnce() {
		return redeemOnce;
	}
	public void setRedeemOnce(boolean redeemOnce) {
		this.redeemOnce = redeemOnce;
	}
	public String getDisplayCountDown() {
		return displayCountDown;
	}
	public void setDisplayCountDown(String countDown) {
		this.displayCountDown = countDown;
	}
	
//	public List<RenewalSetBean> getRenewalSetBeanList() {
//		return renewalSetBeanList;
//	}
//	public void setRenewalSetBeanList(List<RenewalSetBean> renewalSetBeanList) {
//		this.renewalSetBeanList = renewalSetBeanList;
//	}
	
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
	public String getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	public String getRedemptionChannel() {
		return redemptionChannel;
	}
	public void setRedemptionChannel(String redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}
	
}
