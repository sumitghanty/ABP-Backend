package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.CityMasterDAO;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;
import com.mazars.in.service.CityMasterService;
@Service
@Transactional
public class CityMasterServiceImpl implements CityMasterService{
	
	@Autowired
	private CityMasterDAO cityMasterDAO;
	@Override
	public void save(List<CityMaster> citymaster) {
		cityMasterDAO.saveAll(citymaster);
	}

	@Override
	public void update(CityMaster citymaster) {
		cityMasterDAO.save(citymaster);
		
	}

	@Override
	public List<CityMaster> list() {
		List<CityMaster> city=cityMasterDAO.list();
		return city;
	}
	
	
	

}
