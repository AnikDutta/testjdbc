package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LandingPageUrlBean {
	
	private Long offerLandingPageKey;	
	private String offerLandingPageXMLIDS;	
	private String offerLandingPageDimensionNames;

	public Long getOfferLandingPageKey() {
		return offerLandingPageKey;
	}
	public void setOfferLandingPageKey(Long offerLandingPageKey) {
		this.offerLandingPageKey = offerLandingPageKey;
	}

	public String getOfferLandingPageXMLIDS() {
		return offerLandingPageXMLIDS;
	}
	public void setOfferLandingPageXMLIDS(String offerLandingPageXMLIDS) {
		this.offerLandingPageXMLIDS = offerLandingPageXMLIDS;
	}

	public String getOfferLandingPageDimensionNames() {
		return offerLandingPageDimensionNames;
	}
	public void setOfferLandingPageDimensionNames(
			String offerLandingPageDimensionNames) {
		this.offerLandingPageDimensionNames = offerLandingPageDimensionNames;
	}

}
