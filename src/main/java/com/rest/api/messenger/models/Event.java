package com.rest.api.messenger.models;

import java.util.Date;

import com.rest.api.utils.DateFormatUtil;

public class Event {

	long id;
	String eventName;
	String eventType;
	String eventDescription;
	String eventPlace;
	String startDate;
	String endDate;
	String eventOrganizer1;
	String organizerContact1;
	String eventOrganizer2;
	String organizerContact2;
	String eventOrganizer3;
	String organizerContact3;

	public Event() {

	}

	public Event(long id, String eventName, String eventType, String eventDesc, String eventPlace, String eo1, String eo1Contact, String startDate, String endDate) {
		this.id=id;
		this.eventName=eventName;
		this.eventType = eventType;
		this.eventDescription = eventDesc;
		this.eventPlace = eventPlace;
		this.startDate = DateFormatUtil.getUserDisplayFormat(startDate);
		this.endDate = DateFormatUtil.getUserDisplayFormat(endDate);
		this.eventOrganizer1 = eo1;
		this.organizerContact1 = eo1Contact;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public String getEventOrganizer1() {
		return eventOrganizer1;
	}

	public void setEventOrganizer1(String eventOrganizer1) {
		this.eventOrganizer1 = eventOrganizer1;
	}

	public String getOrganizerContact1() {
		return organizerContact1;
	}

	public void setOrganizerContact1(String organizerContact1) {
		this.organizerContact1 = organizerContact1;
	}

	public String getEventOrganizer2() {
		return eventOrganizer2;
	}

	public void setEventOrganizer2(String eventOrganizer2) {
		this.eventOrganizer2 = eventOrganizer2;
	}

	public String getOrganizerContact2() {
		return organizerContact2;
	}

	public void setOrganizerContact2(String organizerContact2) {
		this.organizerContact2 = organizerContact2;
	}

	public String getEventOrganizer3() {
		return eventOrganizer3;
	}

	public void setEventOrganizer3(String eventOrganizer3) {
		this.eventOrganizer3 = eventOrganizer3;
	}

	public String getOrganizerContact3() {
		return organizerContact3;
	}

	public void setOrganizerContact3(String organizerContact3) {
		this.organizerContact3 = organizerContact3;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = DateFormatUtil.getUserDisplayFormat(startDate);
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = DateFormatUtil.getUserDisplayFormat(endDate);
	}
	
}
