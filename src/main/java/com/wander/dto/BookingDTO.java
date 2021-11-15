package com.wander.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

public class BookingDTO {

	private Integer bookingId;
	@NotNull(message = "{checkIn.absent}")
	@FutureOrPresent(message = "{checkIn.mustBeFutureOrPresent}")
	private LocalDate checkIn;
	@NotNull(message = "{checkOut.absent}")
	@Future(message = "{checkOut.mustBeFuture}")
	private LocalDate checkOut;
	@NotNull(message = "noOfPeople.absent")
	private Integer noOfPeople;
	@NotNull(message = "{totalCost.absent}")
	private Float totalCost;
	private LocalDate timeOfBooking;
	private DestinationDTO destination;
	private UserDTO user;
	
	
	
	public BookingDTO(Integer bookingId, LocalDate checkIn, LocalDate checkOut, Integer noOfPeople, Float totalCost,
			LocalDate timeOfBooking, DestinationDTO destination, UserDTO user) {
		super();
		this.bookingId = bookingId;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.noOfPeople = noOfPeople;
		this.totalCost = totalCost;
		this.timeOfBooking = timeOfBooking;
		this.destination = destination;
		this.user = user;
	}
	
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}
	public LocalDate getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public Float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	public LocalDate getTimeOfBooking() {
		return timeOfBooking;
	}
	public void setTimeOfBooking(LocalDate timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	public DestinationDTO getDestination() {
		return destination;
	}
	public void setDestination(DestinationDTO destination) {
		this.destination = destination;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}
