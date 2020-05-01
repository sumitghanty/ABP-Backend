package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.AccomodationType;
import com.mazars.in.model.mastermodel.PurposeMaster;
import com.mazars.in.model.mastermodel.Retainer;
import com.mazars.in.model.mastermodel.TravelTypeMaster;
import com.mazars.in.model.mastermodel.TripForMaster;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;


public interface MasterListService {
	public List <PurposeMaster> getPurposeMaster();
	public  List<TravelTypeMaster> getTravelTypeMaster();
	public List<TripForMaster> getTripForMaster();
	public List<Retainer> getRetainerMaster();
	public List<CityMaster> getCityMaster();
	public List<AccomodationType> getAccomodationType();
}
