package com.wander.dto;

public class ItineraryDTO {
	
	private String itineraryId;
	private String firstDay;
	private String restOfDays;
	private String lastDay;
	
	public ItineraryDTO(String itineraryId, String firstDay, String restOfDays, String lastDay) {
		super();
		this.itineraryId = itineraryId;
		this.firstDay = firstDay;
		this.restOfDays = restOfDays;
		this.lastDay = lastDay;
	}

	public String getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(String itineraryId) {
		this.itineraryId = itineraryId;
	}

	public String getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(String firstDay) {
		this.firstDay = firstDay;
	}

	public String getRestOfDays() {
		return restOfDays;
	}

	public void setRestOfDays(String restOfDays) {
		this.restOfDays = restOfDays;
	}

	public String getLastDay() {
		return lastDay;
	}

	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}
	
	
}
