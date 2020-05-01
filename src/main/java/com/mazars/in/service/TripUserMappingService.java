package com.mazars.in.service;

import com.mazars.in.model.transactionmodel.TripUserMapping;

public interface TripUserMappingService {

	
	public String save(TripUserMapping instance);
	public String update(TripUserMapping instance);
	
	public TripUserMapping list();
	public String delete(TripUserMapping instance);
}
