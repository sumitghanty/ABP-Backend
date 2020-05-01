package com.mazars.in.model.transactionmodel;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EnableJpaAuditing
@Table(name="tbl_flight_train_booking_details")
@OptimisticLocking(type = OptimisticLockType.NONE)
public class FlightTrainBookingDetails implements Serializable {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="flight_or_train_booking_id")
	private int flightOrTrainBookingId;
	
	@Column(name="line_item_id")
	private int lineItemId;
	@Column(name="trip_id")
	private int tripId;
	
	@Column(name="booking_type")
	private String bookingType;
	@Column(name="flight_train_number")
	private String flightTrainNumber;
	@Column(name="flight_train_name")
	private String flightTrainName;
	@Column(name="amount")
	private float amount;
	@Column(name="from_location")
	private String fromLocation;
	@Column(name="to_location")
	private String toLocation;
	@Column(name="ticket_class")
	private String ticketClass;
	@Column(name="trip_type")
	private String tripType;
	@Column(name="remarks")
	private String remarks;
	@Column(name="estimated_cose")
	private int estimatedCost;
	@Column(name="time_of_travel")
	private String timeOfTravel;
	@Column(name="status")
	private String staus;
	@Column(name="sub_status")
	private String subStatus;
	@Column(name="pending_With")
	private String pendingWith;
	@Column(name="pending_With_email")
	private String pendingWithEmail;
	@Column(name="is_active")
	private boolean isActive;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="flight_or_train_booking_id")
	private Set<FlightToUserMapping> flightToUserMapping;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="flight_or_train_booking_id")
	private Set<SelectedFlight> selectedFlight;
	
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tripcreation_id",nullable=false)
	private TripCreation tripCreation;*/
	
/*	@OneToMany(fetch = FetchType.EAGER, mappedBy = "flightTrainBooking",cascade = CascadeType.ALL)
	private List<TripUserMapping> flightUserMapping;
	*/

	
	


	public int getFlightOrTrainBookingId() {
		return flightOrTrainBookingId;
	}



	public Set<FlightToUserMapping> getFlightToUserMapping() {
		return flightToUserMapping;
	}



	public void setFlightToUserMapping(Set<FlightToUserMapping> flightToUserMapping) {
		this.flightToUserMapping = flightToUserMapping;
	}



	public Set<SelectedFlight> getSelectedFlight() {
		return selectedFlight;
	}



	public void setSelectedFlight(Set<SelectedFlight> selectedFlight) {
		this.selectedFlight = selectedFlight;
	}



	public void setFlightOrTrainBookingId(int flightOrTrainBookingId) {
		this.flightOrTrainBookingId = flightOrTrainBookingId;
	}



	public int getLineItemId() {
		return lineItemId;
	}



	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}



	public int getTripId() {
		return tripId;
	}



	public void setTripId(int tripId) {
		this.tripId = tripId;
	}



	public String getBookingType() {
		return bookingType;
	}



	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}



	public String getFlightTrainNumber() {
		return flightTrainNumber;
	}



	public void setFlightTrainNumber(String flightTrainNumber) {
		this.flightTrainNumber = flightTrainNumber;
	}



	public String getFlightTrainName() {
		return flightTrainName;
	}



	public void setFlightTrainName(String flightTrainName) {
		this.flightTrainName = flightTrainName;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
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



	public String getTicketClass() {
		return ticketClass;
	}



	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}



	public String getTripType() {
		return tripType;
	}



	public void setTripType(String tripType) {
		this.tripType = tripType;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public int getEstimatedCost() {
		return estimatedCost;
	}



	public void setEstimatedCost(int estimatedCost) {
		this.estimatedCost = estimatedCost;
	}



	public String getTimeOfTravel() {
		return timeOfTravel;
	}



	public void setTimeOfTravel(String timeOfTravel) {
		this.timeOfTravel = timeOfTravel;
	}



	public String getStaus() {
		return staus;
	}



	public void setStaus(String staus) {
		this.staus = staus;
	}



	public String getSubStatus() {
		return subStatus;
	}



	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}



	public String getPendingWith() {
		return pendingWith;
	}



	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}



	public String getPendingWithEmail() {
		return pendingWithEmail;
	}



	public void setPendingWithEmail(String pendingWithEmail) {
		this.pendingWithEmail = pendingWithEmail;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
