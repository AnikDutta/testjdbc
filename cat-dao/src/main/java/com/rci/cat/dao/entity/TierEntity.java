package com.rci.cat.dao.entity;

import java.io.Serializable;

public class TierEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long TIER_CD;
    private String TIER_DESC;
    
    public TierEntity() {
	super();
    }

    public Long getTIER_CD() {
		return TIER_CD;
	}

	public void setTIER_CD(Long tIER_CD) {
		TIER_CD = tIER_CD;
	}

	public String getTIER_DESC() {
		return TIER_DESC;
	}

	public void setTIER_DESC(String tIER_DESC) {
		TIER_DESC = tIER_DESC;
	}

	public TierEntity(Long TIER_CD, String TIER_DESC) {
		super();
		this.TIER_CD = TIER_CD;
		this.TIER_DESC = TIER_DESC;
    } 

   
}
