package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.LocationMaster;

public interface LocationService {

	public void save(LocationMaster location);
	public void update(LocationMaster location);
	
	public List<LocationMaster> locationList();
	
	public void delete(LocationMaster location);
	
}
