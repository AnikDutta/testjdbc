package com.rci.cat.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//@JsonInclude(Include.NON_EMPTY)
public class CatJsonModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private String status;
    private ApiDataModel data;
    private String errorCode;
    private String message;
    
    public CatJsonModel() {
		super();
	}

	public CatJsonModel(String status, ApiDataModel data, String errorCode, String message) {
		super();
		this.status = status;
		this.data = data;
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApiDataModel getData() {
		return data;
	}

	public void setData(ApiDataModel data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
