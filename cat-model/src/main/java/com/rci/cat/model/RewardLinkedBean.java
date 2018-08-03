package com.rci.cat.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardLinkedBean {
	
	private List<String> membershipTypeList;
	private String redemptionChannel;
	private Map<String,List<String>> officeDetailsMap;

	private boolean allOffice;
	

	private String bypassLinkUrl;
	private String rewardStartDate;
	private String rewardEndDate;
	
	public String getRedemptionChannel() {
		return redemptionChannel;
	}
	public void setRedemptionChannel(String redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}
	public List<String> getMembershipTypeList() {
		return membershipTypeList;
	}
	public void setMembershipTypeList(List<String> membershipTypeList) {
		this.membershipTypeList = membershipTypeList;
	}

	public String getBypassLinkUrl() {
		return bypassLinkUrl;
	}
	public void setBypassLinkUrl(String bypassLinkUrl) {
		this.bypassLinkUrl = bypassLinkUrl;
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
	public Map<String, List<String>> getOfficeDetailsMap() {
		return officeDetailsMap;
	}

	public void setOfficeDetailsMap(Map<String, List<String>> officeDetailsMap) {
		this.officeDetailsMap = officeDetailsMap;
	}
	
	public boolean isAllOffice() {
		return allOffice;
	}
	public void setAllOffice(boolean allOffice) {
		this.allOffice = allOffice;
	}
}
