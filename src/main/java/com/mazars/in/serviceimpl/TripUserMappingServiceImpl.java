package com.mazars.in.serviceimpl;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.TripUserMappingDAO;
import com.mazars.in.model.transactionmodel.TripUserMapping;
import com.mazars.in.service.TripUserMappingService;
@Service
@Transactional
public class TripUserMappingServiceImpl implements TripUserMappingService{
	private static final Logger logger = LogManager.getLogger(TripUserMappingServiceImpl.class);
	
	private TripUserMappingDAO tripUserMappingDAO;
	
	
	

	public TripUserMappingDAO getTripUserMappingDAO() {
		return tripUserMappingDAO;
	}

	public void setTripUserMappingDAO(TripUserMappingDAO tripUserMappingDAO) {
		this.tripUserMappingDAO = tripUserMappingDAO;
	}

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String save(TripUserMapping instance) {
		tripUserMappingDAO.save(instance);
		return "200";
	}

	@Override
	public String update(TripUserMapping instance) {
		tripUserMappingDAO.update(instance);
		return null;
	}

	@Override
	public TripUserMapping list() {
		TripUserMapping tripUserMapping=tripUserMappingDAO.list();
		return tripUserMapping;
	}

	@Override
	public String delete(TripUserMapping instance) {
		tripUserMappingDAO.delete(instance);
		return null;
	}

}
