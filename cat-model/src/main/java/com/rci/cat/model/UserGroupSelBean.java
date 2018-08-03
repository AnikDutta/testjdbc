package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserGroupSelBean {
	private boolean selRM;
	private boolean selDBM;
	private boolean selMkt;
		
	public boolean isSelRM() {
		return selRM;
	}
	public void setSelRM(boolean selRM) {
		this.selRM = selRM;
	}

	public boolean isSelDBM() {
		return selDBM;
	}
	public void setSelDBM(boolean selDBM) {
		this.selDBM = selDBM;
	}
	public boolean isSelMkt() {
		return selMkt;
	}

	public void setSelMkt(boolean selMkt) {
		this.selMkt = selMkt;
	}

		
}
