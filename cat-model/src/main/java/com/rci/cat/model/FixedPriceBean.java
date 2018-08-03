package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FixedPriceBean {
	
	private String currencyCode;
	private long redemptionValue;
	private int priceRangeMinValue;
	private int priceRangeMaxValue;
	private boolean markForDeletion;
	private boolean valFromSOA;
	
	public boolean isValFromSOA() {
		return valFromSOA;
	}
	public void setValFromSOA(boolean valFromSOA) {
		this.valFromSOA = valFromSOA;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public long getRedemptionValue() {
		return redemptionValue;
	}
	public void setRedemptionValue(long redemptionValue) {
		this.redemptionValue = redemptionValue;
	}

	public int getPriceRangeMinValue() {
		return priceRangeMinValue;
	}
	public void setPriceRangeMinValue(int priceRangeMinValue) {
		this.priceRangeMinValue = priceRangeMinValue;
	}
	public int getPriceRangeMaxValue() {
		return priceRangeMaxValue;
	}
	public void setPriceRangeMaxValue(int priceRangeMaxValue) {
		this.priceRangeMaxValue = priceRangeMaxValue;
	}
	@Override
	public String toString() {
		
		return "currencyCode :  " + currencyCode + "\t redemptionValue  :  " + redemptionValue  + "\t priceRangeMinValue  :  " + priceRangeMinValue  + "\t priceRangeMaxValue  :  " + priceRangeMaxValue  + "\t markForDeletion  :  " + markForDeletion;
	}
	public boolean isMarkForDeletion() {
		return markForDeletion;
	}
	public void setMarkForDeletion(boolean markForDeletion) {
		this.markForDeletion = markForDeletion;
	}

}
