package com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.transactionmodel.FlightTrainBookingDetails;

public interface FlightTrainBookingDetailsDAO {
	public void save(FlightTrainBookingDetails instance);
	public void update(FlightTrainBookingDetails instance);
	
	public List<FlightTrainBookingDetails> list();
}
