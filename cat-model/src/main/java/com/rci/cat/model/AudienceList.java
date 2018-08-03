package com.rci.cat.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AudienceList {

	private long referenceNumber;
	private long memberIdCount;

	public long getreferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public long getmemberIdCount() {
		return memberIdCount;
	}
	public void setMemberIdCount(long memberIdCount) {
		this.memberIdCount = memberIdCount;
	}
	
}
