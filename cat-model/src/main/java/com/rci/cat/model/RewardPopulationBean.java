package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardPopulationBean implements Comparable<RewardPopulationBean> 
{
	
	private String rewardID;
	private String redemptionChannel;
	private long redeemPercentOff;
	
	
	public String getRewardID() {
		return rewardID;
	}
	public long getRedeemPercentOff() {
		return redeemPercentOff;
	}
	public void setRedeemPercentOff(long redeemPercentOff) {
		this.redeemPercentOff = redeemPercentOff;
	}
	public void setRewardID(String rewardID) {
		this.rewardID = rewardID;
	}
	public String getRedemptionChannel() {
		return redemptionChannel;
	}
	public void setRedemptionChannel(String redemptionChannel) {
		this.redemptionChannel = redemptionChannel;
	}
	
	@Override
	public int compareTo(RewardPopulationBean reward) {
		
		Long rewardId = Long.valueOf(reward.getRewardID());
		return (int) (Long.valueOf(this.rewardID) - rewardId);
	}
		

}
