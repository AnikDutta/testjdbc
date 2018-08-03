package com.rci.cat.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserRoleBean implements Serializable{

	String [] userRoles;
	List<String> userCapabilities;
	
	public String[] getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(String[] userRoles) {
		this.userRoles = userRoles;
	}
	
	public List<String> getUserCapabilities() {
		return userCapabilities;
	}
	public void setUserCapabilities(List<String> userCapabilities) {
		this.userCapabilities = userCapabilities;
	}
}
