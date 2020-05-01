package com.mazars.in.model.transactionmodel;

import java.util.Date;

public class CityConveyenceBooking {

	private int id;
	private int tripId;
	private int userId;	
	private String designation;
	private String carDriverName;
	private String carCarNumber;
	private String fromLocation;
	private String toLocation;
	private Date bookingDate;
	private Date bookingTime;
	private String travelerName;
	private int travelerPhone;
	private int totalAmount;
	private int entitledAmount;	
	private String status;	
	private int statusId;
	private String PendingWith;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCarDriverName() {
		return carDriverName;
	}
	public void setCarDriverName(String carDriverName) {
		this.carDriverName = carDriverName;
	}
	public String getCarCarNumber() {
		return carCarNumber;
	}
	public void setCarCarNumber(String carCarNumber) {
		this.carCarNumber = carCarNumber;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getTravelerName() {
		return travelerName;
	}
	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}
	public int getTravelerPhone() {
		return travelerPhone;
	}
	public void setTravelerPhone(int travelerPhone) {
		this.travelerPhone = travelerPhone;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getEntitledAmount() {
		return entitledAmount;
	}
	public void setEntitledAmount(int entitledAmount) {
		this.entitledAmount = entitledAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getPendingWith() {
		return PendingWith;
	}
	public void setPendingWith(String pendingWith) {
		PendingWith = pendingWith;
	}	

	
	
	
	
}
