/**
 * 
 */
package com.rci.cat.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tui0se0
 * 
 * Entity to hold the Currency office Code mappings for offer setup for a region
 *
 */
public class CurrencyOfficeModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currencyCode;
	
	private Map<String, List<String>> officeCodes = new HashMap<String, List<String>>();

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the officeCodes
	 */
	public Map<String, List<String>> getOfficeCodes() {
		return officeCodes;
	}

	/**
	 * @param officeCodes the officeCodes to set
	 */
	public void setOfficeCodes(Map<String, List<String>> officeCodes) {
		this.officeCodes = officeCodes;
	}

	
	public String toString(){
		
		StringBuffer str = new StringBuffer();
		
		str.append(	" CurrencyOffice [" +
					" currencyCode :" + currencyCode +
					" officeCodes :" + officeCodes +
					" ]");
		
		return str.toString();
		
	}

}
