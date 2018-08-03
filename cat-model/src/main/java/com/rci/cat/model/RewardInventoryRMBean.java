package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RewardInventoryRMBean {
	
	private List<FixedPriceBean> fixedPriceBeanList;
	//List<MultipleFixedPriceBean> multipleFixedPriceBeanList;
	
	private String bedRoomType;
	
	private int compNumber;
	private boolean holdAllowed;
	private String redemptionStartDate;
	private String redemptionEndDate;
	private String localeVal;
	private List<String> resortExcl;
	private List<String> resortIncl;
	private String travelStartDate;
	private String travelEndDate;
	private long maxReqVal;
	private int advanceDays;
	private List<String> poolGroups;
	private List<String> pools;
	private String rmRewardStatus;
	private long redemPercentForWeb;	
	private long redemPercentForCC;	
	private int fixedPriceBeanListSize;	
	private int multipleFixedPriceBeanListSize;
	private boolean redeemOnce;
	private boolean exclAddnPltDisc;
	
	public boolean isExclAddnPltDisc() {
		return exclAddnPltDisc;
	}
	public void setExclAddnPltDisc(boolean exclAddnPltDisc) {
		this.exclAddnPltDisc = exclAddnPltDisc;
	}
	public boolean isRedeemOnce() {
		return redeemOnce;
	}
	public void setRedeemOnce(boolean redeemOnce) {
		this.redeemOnce = redeemOnce;
	}
	public int getCompNumber() {
		return compNumber;
	}
	public void setCompNumber(int compNumber) {
		this.compNumber = compNumber;
	}
	public boolean isHoldAllowed() {
		return holdAllowed;
	}
	public void setHoldAllowed(boolean holdAllowed) {
		this.holdAllowed = holdAllowed;
	}
	public String getRedemptionStartDate() {
		return redemptionStartDate;
	}
	public void setRedemptionStartDate(String redemptionStartDate) {
		this.redemptionStartDate = redemptionStartDate;
	}
	public String getRedemptionEndDate() {
		return redemptionEndDate;
	}
	public void setRedemptionEndDate(String redemptionEndDate) {
		this.redemptionEndDate = redemptionEndDate;
	}
	public String getLocaleVal() {
		return localeVal;
	}
	public void setLocaleVal(String localeVal) {
		this.localeVal = localeVal;
	}
	public List<String> getResortExcl() {
		return resortExcl;
	}
	public void setResortExcl(List<String> resortExcl) {
		this.resortExcl = resortExcl;
	}
	public List<String> getResortIncl() {
		return resortIncl;
	}
	public void setResortIncl(List<String> resortIncl) {
		this.resortIncl = resortIncl;
	}
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
	public long getMaxReqVal() {
		return maxReqVal;
	}
	public void setMaxReqVal(long maxReqVal) {
		this.maxReqVal = maxReqVal;
	}
	public int getAdvanceDays() {
		return advanceDays;
	}
	public void setAdvanceDays(int advanceDays) {
		this.advanceDays = advanceDays;
	}
	public List<String> getPoolGroups() {
		return poolGroups;
	}
	public void setPoolGroups(List<String> poolGroups) {
		this.poolGroups = poolGroups;
	}
	public List<String> getPools() {
		return pools;
	}
	public void setPools(List<String> pools) {
		this.pools = pools;
	}

	public List<FixedPriceBean> getFixedPriceBeanList() {
		return fixedPriceBeanList;
	}
	public void setFixedPriceBeanList(List<FixedPriceBean> fixedPriceBeanList) {
		this.fixedPriceBeanList = fixedPriceBeanList;
	}
	
	public String getRmRewardStatus() {
		return rmRewardStatus;
	}
	public void setRmRewardStatus(String rmRewardStatus) {
		this.rmRewardStatus = rmRewardStatus;
	}
	
	public int getFixedPriceBeanListSize() {
		if(fixedPriceBeanList!=null)
		return fixedPriceBeanList.size();
		
		return 0;
	}
	
	public long getRedemPercentForWeb() {
		return redemPercentForWeb;
	}

	public void setRedemPercentForWeb(long redemPercentForWeb) {
		this.redemPercentForWeb = redemPercentForWeb;
	}

	public long getRedemPercentForCC() {
		return redemPercentForCC;
	}

	public void setRedemPercentForCC(long redemPercentForCC) {
		this.redemPercentForCC = redemPercentForCC;
	}
	public String getBedRoomType() {
		return bedRoomType;
	}
	public void setBedRoomType(String bedRoomType) {
		this.bedRoomType = bedRoomType;
	}
	public int getMultipleFixedPriceBeanListSize() {
		return multipleFixedPriceBeanListSize;
	}
	public void setMultipleFixedPriceBeanListSize(int multipleFixedPriceBeanListSize) {
		this.multipleFixedPriceBeanListSize = multipleFixedPriceBeanListSize;
	}
	public void setFixedPriceBeanListSize(int fixedPriceBeanListSize) {
		this.fixedPriceBeanListSize = fixedPriceBeanListSize;
	}
	
}
