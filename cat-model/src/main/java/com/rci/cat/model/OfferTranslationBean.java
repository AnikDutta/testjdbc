package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OfferTranslationBean 
{
	private String name;
	private String desc;
	private String details;
	
	private String imageURL;
	private String applicationType;
	private String locale;
	private boolean isRootContent;
	private String country;
	private Boolean isPlatinumPreview;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Boolean getIsPlatinumPreview() {
		return isPlatinumPreview;
	}
	public void setIsPlatinumPreview(Boolean isPlatinumPreview) {
		this.isPlatinumPreview = isPlatinumPreview;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public boolean getIsRootContent() {
		return isRootContent;
	}
	public void setIsRootContent(boolean isRootContent) {
		this.isRootContent = isRootContent;
	}
	

	public String toString()
	{
		return new String("Name=" + getName() + "||" +
							"Desc=" + getDesc() + "||" + 
							"Details=" + getDetails() + "||" + 
							"imageURL=" + imageURL+ "||"  + 
							"applicationType=" + applicationType + "||" + 
							"locale=" + locale + "||" + 
							"isRootContent=" + isRootContent + "||"  
							 );
	}

}
