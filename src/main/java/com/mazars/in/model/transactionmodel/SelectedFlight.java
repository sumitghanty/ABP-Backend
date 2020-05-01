package com.mazars.in.model.transactionmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
//@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@EnableJpaAuditing
@OptimisticLocking(type = OptimisticLockType.NONE)
@Table(name="tbl_selected_flight")
public class SelectedFlight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="selected_flight_id")
	private int selectedFlightId;
	@Column(name="stops")
	private int flightStops;
	@Column(name="airline")
	private String airline;
	@Column(name="fare")
	private int fare;
	@Lob
	//,columnDefinition = "CLOB"
	@Column(name="flightData",columnDefinition="blob")
	private String flightData;
	@Column(name="flight_no")
	private String flightNo;
	@Column(name="origin")
	private String origin;
	@Column(name="destination")
	private String destination;
	@Column(name="final_arrival_time")
	private String finalArrivalTime;
	@Column(name="flight_or_train_booking_id")
	private int flightOrTrainBookingId;
	@Column(name="selection_type")
	private String selectionType;
	@Column(name="flight_arrival_time")
	private String flightArrivalTime;
	@Column(name="flight_departure_time")
	private String flightDepartureTime;
	public int getSelectedFlightId() {
		return selectedFlightId;
	}
	public void setSelectedFlightId(int selectedFlightId) {
		this.selectedFlightId = selectedFlightId;
	}
	public int getFlightStops() {
		return flightStops;
	}
	public void setFlightStops(int flightStops) {
		this.flightStops = flightStops;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getFlightData() {
		return flightData;
	}
	public void setFlightData(String flightData) {
		this.flightData = flightData;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getFinalArrivalTime() {
		return finalArrivalTime;
	}
	public void setFinalArrivalTime(String finalArrivalTime) {
		this.finalArrivalTime = finalArrivalTime;
	}
	public int getFlightOrTrainBookingId() {
		return flightOrTrainBookingId;
	}
	public void setFlightOrTrainBookingId(int flightOrTrainBookingId) {
		this.flightOrTrainBookingId = flightOrTrainBookingId;
	}
	public String getSelectionType() {
		return selectionType;
	}
	public void setSelectionType(String selectionType) {
		this.selectionType = selectionType;
	}
	public String getFlightArrivalTime() {
		return flightArrivalTime;
	}
	public void setFlightArrivalTime(String flightArrivalTime) {
		this.flightArrivalTime = flightArrivalTime;
	}
	public String getFlightDepartureTime() {
		return flightDepartureTime;
	}
	public void setFlightDepartureTime(String flightDepartureTime) {
		this.flightDepartureTime = flightDepartureTime;
	}
	
	
	
	
	
}
