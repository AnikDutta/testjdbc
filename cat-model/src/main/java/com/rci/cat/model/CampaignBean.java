package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CampaignBean {
	private String campaignType;
	
	private List <AudienceList> customers;
	
	public String getCampaignType() {
		return campaignType;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}
	public List<AudienceList> getcustomers() {
		return customers;
	}
	public void setCustomers(List<AudienceList> customers) {
		this.customers = customers;
	}
	
	
}
