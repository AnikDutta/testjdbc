package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardInventoryMKTBean {

	private LandingPageUrlBean landingPageUrlBean;
	private LandingPageRegionSelBean landingPageRegionSelBean;
	private LandingURLPojo landingURLPojo;
	
	private String redemptionChannel;
	private List<String> membershipTypeLst;
	private boolean landingPageURL;	
	private boolean redeemOnce;
	private boolean exclAddnPltDisc;
	
	public boolean isExclAddnPltDisc() {
		return exclAddnPltDisc;
	}
	public void setExclAddnPltDisc(boolean exclAddnPltDisc) {
		this.exclAddnPltDisc = exclAddnPltDisc;
	}

	public boolean isLandingPageURL() {
		return landingPageURL;
	}
	public void setLandingPageURL(boolean landingPageURL) {
		this.landingPageURL = landingPageURL;
	}
	public LandingPageUrlBean getLandingPageUrlBean() {
		return landingPageUrlBean;
	}
	public void setLandingPageUrlBean(LandingPageUrlBean landingPageUrlBean) {
		this.landingPageUrlBean = landingPageUrlBean;
	}
	public LandingPageRegionSelBean getLandingPageRegionSelBean() {
		return landingPageRegionSelBean;
	}
	public void setLandingPageRegionSelBean(
			LandingPageRegionSelBean landingPageRegionSelBean) {
		this.landingPageRegionSelBean = landingPageRegionSelBean;
	}
	public LandingURLPojo getLandingURLPojo() {
		return landingURLPojo;
	}
	public void setLandingURLPojo(LandingURLPojo landingURLPojo) {
		this.landingURLPojo = landingURLPojo;
	}
	public List<String> getMembershipTypeLst() {
		return membershipTypeLst;
	}
	public void setMembershipTypeLst(List<String> membershipTypeLst) {
		this.membershipTypeLst = membershipTypeLst;
	}
	public String getRedemptionChannel() {
		return redemptionChannel;
	}
	public void setRedemptionChannel(String redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}
	public boolean isRedeemOnce() {
		return redeemOnce;
	}
	public void setRedeemOnce(boolean redeemOnce) {
		this.redeemOnce = redeemOnce;
	}
	
}
