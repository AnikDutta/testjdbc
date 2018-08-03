package com.rci.cat.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class CatPropertiesModel implements Serializable {
	String proerties;

	public CatPropertiesModel() {
		super();
	}

	public String getProerties() {
		return proerties;
	}

	public void setProerties(String proerties) {
		this.proerties = proerties;
	}
	
}
