package com.rci.cat.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class UserMasterDetailsModel implements Serializable {
	
	private Map<Integer, String> allLocalesMap;
	private Map<String, String> arpDetails;
	private List<String> tierConfigTypes;
	private Map<Integer, String> locales;
	private Map<String, String> channel;
	private Map<String, String> membershipType;
	private Map<Integer, String> offerRegions;
	private List<String> currencyCodes;
	private List<String> exchCurrencyCodes;
	private List<CurrencyOfficeModel> currencyOfficeMapper;
	private Map<Integer, String> rewardTypes;
	private Map<Integer,Map<Integer,String>> rewardSubTypes;
	private List<String> bedRoomCodes;
	private Map<String, String> errorCodes;
	
	public UserMasterDetailsModel() {
		super();
	}
	public UserMasterDetailsModel(Map<Integer, String> allLocalesMap, Map<String, String> arpDetails,
			List<String> tierConfigTypes, Map<Integer, String> locales, Map<String, String> channel,
			Map<String, String> membershipType, Map<Integer, String> offerRegions, List<String> currencyCodes,
			List<String> exchCurrencyCodes, String officeCodeJsonArrayString, List<CurrencyOfficeModel> exchCurrOffices,
			Map<Integer, String> rewardTypes, Map<Integer, Map<Integer, String>> rewardSubTypes,
			List<String> bedRoomCodes, Map<String, String> errorCodes) {
		super();
		this.allLocalesMap = allLocalesMap;
		this.arpDetails = arpDetails;
		this.tierConfigTypes = tierConfigTypes;
		this.locales = locales;
		this.channel = channel;
		this.membershipType = membershipType;
		this.offerRegions = offerRegions;
		this.currencyCodes = currencyCodes;
		this.exchCurrencyCodes = exchCurrencyCodes;
		this.currencyOfficeMapper = exchCurrOffices;
		this.rewardTypes = rewardTypes;
		this.rewardSubTypes = rewardSubTypes;
		this.bedRoomCodes = bedRoomCodes;
		this.errorCodes = errorCodes;
	}
	public Map<Integer, String> getAllLocalesMap() {
		return allLocalesMap;
	}
	public void setAllLocalesMap(Map<Integer, String> allLocalesMap) {
		this.allLocalesMap = allLocalesMap;
	}
	public Map<String, String> getArpDetails() {
		return arpDetails;
	}
	public void setArpDetails(Map<String, String> arpDetails) {
		this.arpDetails = arpDetails;
	}
	public List<String> getTierConfigTypes() {
		return tierConfigTypes;
	}
	public void setTierConfigTypes(List<String> tierConfigTypes) {
		this.tierConfigTypes = tierConfigTypes;
	}
	public Map<Integer, String> getLocales() {
		return locales;
	}
	public void setLocales(Map<Integer, String> locales) {
		this.locales = locales;
	}
	public Map<String, String> getChannel() {
		return channel;
	}
	public void setChannel(Map<String, String> channel) {
		this.channel = channel;
	}
	public Map<String, String> getMembershipType() {
		return membershipType;
	}
	public void setMembershipType(Map<String, String> membershipType) {
		this.membershipType = membershipType;
	}
	public Map<Integer, String> getOfferRegions() {
		return offerRegions;
	}
	public void setOfferRegions(Map<Integer, String> offerRegions) {
		this.offerRegions = offerRegions;
	}
	public List<String> getCurrencyCodes() {
		return currencyCodes;
	}
	public void setCurrencyCodes(List<String> currencyCodes) {
		this.currencyCodes = currencyCodes;
	}
	public List<String> getExchCurrencyCodes() {
		return exchCurrencyCodes;
	}
	public void setExchCurrencyCodes(List<String> exchCurrencyCodes) {
		this.exchCurrencyCodes = exchCurrencyCodes;
	}
	public List<CurrencyOfficeModel> getCurrencyOfficeMapper() {
		return currencyOfficeMapper;
	}
	public void setCurrencyOfficeMapper(List<CurrencyOfficeModel> exchCurrOffices) {
		this.currencyOfficeMapper = exchCurrOffices;
	}
	public Map<Integer, String> getRewardTypes() {
		return rewardTypes;
	}
	public void setRewardTypes(Map<Integer, String> rewardTypes) {
		this.rewardTypes = rewardTypes;
	}
	public Map<Integer, Map<Integer, String>> getRewardSubTypes() {
		return rewardSubTypes;
	}
	public void setRewardSubTypes(Map<Integer, Map<Integer, String>> rewardSubTypes) {
		this.rewardSubTypes = rewardSubTypes;
	}
	public List<String> getBedRoomCodes() {
		return bedRoomCodes;
	}
	public void setBedRoomCodes(List<String> bedRoomCodes) {
		this.bedRoomCodes = bedRoomCodes;
	}
	public Map<String, String> getErrorCodes() {
		return errorCodes;
	}
	public void setErrorCodes(Map<String, String> errorCodes) {
		this.errorCodes = errorCodes;
	}
}
