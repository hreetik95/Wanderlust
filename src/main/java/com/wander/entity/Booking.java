package com.wander.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="BOOKING")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer noOfPeople;
	private Float totalCost;
	private LocalDate timeOfBooking;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="DESTINATION_ID")
	private Destination destination;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", unique = true)
	private User user;

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

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
