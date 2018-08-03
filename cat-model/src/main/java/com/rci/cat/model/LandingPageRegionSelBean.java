package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LandingPageRegionSelBean {

	private String regionXMLID;
	private String regionName;
	private List<LandingURLPojo> lpRegions;
	
	public String getRegionXMLID() {
		return regionXMLID;
	}
	public void setRegionXMLID(String regionXMLID) {
		this.regionXMLID = regionXMLID;
	}
	public List<LandingURLPojo> getLpRegions() {
		return lpRegions;
	}
	public void setLpRegions(List<LandingURLPojo> lpRegions) {
		this.lpRegions = lpRegions;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}	
	
}
