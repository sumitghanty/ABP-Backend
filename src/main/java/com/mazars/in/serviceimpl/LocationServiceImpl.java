package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.LocationMasterDaoRepository;
import com.mazars.in.model.mastermodel.LocationMaster;
import com.mazars.in.service.LocationService;
@Service
@Transactional
public class LocationServiceImpl implements LocationService{

private static final Logger logger = LogManager.getLogger(LocationServiceImpl.class);
	@Autowired
	private LocationMasterDaoRepository locationDAO;
	
	

	@Override
	public void save(LocationMaster location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LocationMaster location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LocationMaster> locationList() {
		List<LocationMaster> locationList=locationDAO.findAll();
		return locationList;
	}

	@Override
	public void delete(LocationMaster location) {
		// TODO Auto-generated method stub
		
	}
	

}
