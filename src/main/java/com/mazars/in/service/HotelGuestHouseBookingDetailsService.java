package com.mazars.in.service;

import com.mazars.in.model.intermediatemodel.HotelFilterModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;

public interface HotelGuestHouseBookingDetailsService {

	public MasterResponseModel hotelSearch(HotelFilterModel hotelFilterModel,String url,String search);
	
	
	
	
}
