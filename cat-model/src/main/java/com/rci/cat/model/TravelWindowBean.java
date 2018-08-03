package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TravelWindowBean {
	
	String travelStartDate;
	String travelEndDate;
	String advanceDays;
	
	public String getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(String travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public String getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(String travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public String getAdvanceDays() {
		return advanceDays;
	}
	public void setAdvanceDays(String advanceDays) {
		this.advanceDays = advanceDays;
	}
	
}
