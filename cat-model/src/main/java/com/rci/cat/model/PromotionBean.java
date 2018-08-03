package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PromotionBean {
	
	private long promotionId;
	private EventBean eventBean;
	private ContextBean contextBean;
	private RewardBean rewardBean;
	private List <CampaignBean> campaignBeans;
	private String promotionStatus;
	private String promotionCode;
	private List<RewardBean> rewardBeanList;
	private String promotionDBMStatus;
	private String audFileInclInd;
	
	
	
	public String getAudFileInclInd() {
		return audFileInclInd;
	}
	public void setAudFileInclInd(String audFileInclInd) {
		this.audFileInclInd = audFileInclInd;
	}
	public String getPromotionDBMStatus() {
		return promotionDBMStatus;
	}
	public void setPromotionDBMStatus(String promotionDBMStatus) {
		this.promotionDBMStatus = promotionDBMStatus;
	}
	public List<RewardBean> getRewardBeanList() {
		return rewardBeanList;
	}
	public void setRewardBeanList(List<RewardBean> rewardBeanList) {
		this.rewardBeanList = rewardBeanList;
	}
	public String getPromotionCode() {
		return promotionCode;
	}
	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}
	public String getPromotionStatus() {
		return promotionStatus;
	}
	public void setPromotionStatus(String promotionStatus) {
		this.promotionStatus = promotionStatus;
	}
	public EventBean getEventBean() {
		return eventBean;
	}
	public void setEventBean(EventBean eventBean) {
		this.eventBean = eventBean;
	}
	public RewardBean getRewardBean() {
		return rewardBean;
	}
	public void setRewardBean(RewardBean rewardBean) {
		this.rewardBean = rewardBean;
	}
	public long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(long promotionId) {
		this.promotionId = promotionId;
	}
	public List<CampaignBean> getCampaignBeans() {
		return campaignBeans;
	}
	public void setCampaignBeans(List<CampaignBean> campaignBeans) {
		this.campaignBeans = campaignBeans;
	}
	public ContextBean getContextBean() {
		return contextBean;
	}
	public void setContextBean(ContextBean contextBean) {
		this.contextBean = contextBean;
	}
	
	

}
