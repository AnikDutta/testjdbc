package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContextBean {
	
	private String contextName;
	private long contextId;
	
	
	public String getContextName() {
		return contextName;
	}
	public void setContextName(String contextName) {
		this.contextName = contextName;
	}
	public long getContextId() {
		return contextId;
	}
	public void setContextId(long contextId) {
		this.contextId = contextId;
	}
	
	

}
