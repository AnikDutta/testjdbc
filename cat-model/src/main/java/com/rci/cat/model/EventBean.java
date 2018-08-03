package com.rci.cat.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EventBean {

	private String eventType;
	//MOOR3 Change starts	 
	private List<String> eventNameList = null;
	//MOOR3 Change ends
	private long eventId;
	private String eventDescription;
	private String eventName;
	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
/**
 * Added the Getter method for Event Name - MOOR 3
 * @return
 */
	public List<String> getEventNameList() {
		return eventNameList;
	}
/**
 * Added the Setter method for Event Name - MOOR 3
 * @param eventNameList
 */
	public void setEventNameList(List<String> eventNameList) {
		this.eventNameList = eventNameList;
	}
	
	
}
