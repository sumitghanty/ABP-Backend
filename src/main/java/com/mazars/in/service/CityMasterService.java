package com.mazars.in.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mazars.in.model.mmt.hotelmodel.CityMaster;



public interface CityMasterService {
	
	public void save(List<CityMaster> citymaster);
	public void update(CityMaster citymaster);
	
	public List<CityMaster> list();

}
