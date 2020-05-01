package com.mazars.in.model.transactionmodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Entity
@EnableJpaAuditing
@OptimisticLocking(type = OptimisticLockType.NONE)
@Table(name="tbl_trip_user_mapping")
public class TripUserMapping implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trip_user_id")
	private int tripUserId;
	@Column(name="trip_id")
	private int tripId;
	@Column(name="passenger_name")
	private String passengerName;
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="employee_email")
	private String employeeEmail;
	@Column(name="seat")
	private String seat;
	@Column(name="meal")
	private String meal;
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	
	@Column(name="age") 
	private int age;
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="cost_center")
	private int costCentre;
	
	@Column(name="event_code")
	private int eventCode;
	
	@Column(name="organization_name")
	private String organizationName;
	
	public int getTripUserId() {
		return tripUserId;
	}
	public void setTripUserId(int tripUserId) {
		this.tripUserId = tripUserId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public int getCostCentre() {
		return costCentre;
	}
	public void setCostCentre(int costCentre) {
		this.costCentre = costCentre;
	}
	public int getEventCode() {
		return eventCode;
	}
	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}
	
	
	
	
	

	
	
}
