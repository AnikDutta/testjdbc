package com.rci.cat.model;


import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardDetailsBean {
		
		
	private String currency;
	private JSONObject exchangeOfficeBean;
	private boolean allOffice;
	private JSONObject exchangeFeeRedemptionChannelOff;
		
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public JSONObject getExchangeOfficeBean() {
		return exchangeOfficeBean;
	}
	public void setExchangeOfficeBean(JSONObject exchangeOfficeBean) {
		this.exchangeOfficeBean = exchangeOfficeBean;
	}
	public boolean isAllOffice() {
		return allOffice;
	}
	public void setAllOffice(boolean isAllOffice) {
		this.allOffice = isAllOffice;
	}
	public JSONObject getExchangeFeeRedemptionChannelOff() {
		return exchangeFeeRedemptionChannelOff;
	}
	public void setExchangeFeeRedemptionChannelOff(
			JSONObject exchangeFeeRedemptionChannelOff) {
		this.exchangeFeeRedemptionChannelOff = exchangeFeeRedemptionChannelOff;
	}
	
	
	

}
