package com.mazars.in.dao;

import java.util.List;

import com.mazars.in.model.transactionmodel.HotelGuestHouseBookingDetails;

public interface HotelGuestHouseBookingDetailsDAO {
	public void save(HotelGuestHouseBookingDetails instance);
	public void update(HotelGuestHouseBookingDetails instance);
	
	public List<HotelGuestHouseBookingDetails> list();
}
