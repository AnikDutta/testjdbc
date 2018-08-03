package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DBMOfferBean {
	
	private List <CampaignBean> campaigns;
	private String dbmOfferStatus;

	
	public List<CampaignBean> getcampaigns() {
		return campaigns;
	}


	public void setCampaigns(List<CampaignBean> campaigns) {
		this.campaigns = campaigns;
	}

	public String getdbmOfferStatus() {
		return dbmOfferStatus;
	}
	public void setDbmOfferStatus(String dbmOfferStatus) {
		this.dbmOfferStatus = dbmOfferStatus;
	}

}
