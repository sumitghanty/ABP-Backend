package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.transactionmodel.TripCreation;

public interface TripCreationService {
	
	public TripCreation save(TripCreation instance);
	public TripCreation update(TripCreation instance);
	
	public List<TripCreation> list();
	public List<TripCreation> tripListByEmailId(String emailId);
	public String delete(TripCreation instance);
	
	
	public TripCreation getTripDetailsByTripNumber(String tripNumber);
	

}
