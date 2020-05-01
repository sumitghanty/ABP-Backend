package com.mazars.in.model.intermediatemodel;

import java.util.List;



public class CustomFlightModel {

	
	
	int stops;
	String airline;
	String depTime;
	String arrTime;
	int fare;
	String flightData;
	String flightNo;
	String origin;
	String destination;
String finalArrivalTime;
	
	public String getFinalArrivalTime() {
		return finalArrivalTime;
	}
	public void setFinalArrivalTime(String finalArrivalTime) {
		this.finalArrivalTime = finalArrivalTime;
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
	private List<CustomFlightModel> onwardflights;
	public List<CustomFlightModel> getOnwardflights() {
		return onwardflights;
	}
	public void setOnwardflights(List<CustomFlightModel> onwardflights) {
		this.onwardflights = onwardflights;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightData() {
		return flightData;
	}
	public void setFlightData(String flightData) {
		this.flightData = flightData;
	}
	public int getStops() {
		return stops;
	}
	public void setStops(int stops) {
		this.stops = stops;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
}
