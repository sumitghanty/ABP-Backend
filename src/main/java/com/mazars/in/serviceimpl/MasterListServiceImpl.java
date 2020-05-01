package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.AccomodationTypeDAO;
import com.mazars.in.dao.CityMasterDAO;
import com.mazars.in.dao.PurposeMasterDAO;
import com.mazars.in.dao.RetainerDaoRepository;
import com.mazars.in.dao.TravelTypeMasterDAO;
import com.mazars.in.dao.TripForMasterDAO;
import com.mazars.in.model.mastermodel.AccomodationType;
import com.mazars.in.model.mastermodel.PurposeMaster;
import com.mazars.in.model.mastermodel.Retainer;
import com.mazars.in.model.mastermodel.TravelTypeMaster;
import com.mazars.in.model.mastermodel.TripForMaster;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;
import com.mazars.in.service.MasterListService;
@Service
@Transactional
public class MasterListServiceImpl implements MasterListService{
	
	@Autowired
	private TravelTypeMasterDAO travelTypeMasterDAO;
	@Autowired
	private PurposeMasterDAO purposeMasterDAO;

	
	@Autowired
	private TripForMasterDAO tripForMasterDAO;
	
	@Autowired
	private RetainerDaoRepository retainerMasterDAO;
	
	@Autowired
	private CityMasterDAO cityMasterDAO;
	
	@Autowired
	private AccomodationTypeDAO accomodationTypeDAO;
	
	@Override
	public List<PurposeMaster> getPurposeMaster() {
		List<PurposeMaster> purposeMaster=purposeMasterDAO.findAll();
		return purposeMaster;
	}

	@Override
	public List<TravelTypeMaster> getTravelTypeMaster() {
		List<TravelTypeMaster> travelTypeMaster=travelTypeMasterDAO.findAll();
		return travelTypeMaster;
	}

	@Override
	public List<TripForMaster> getTripForMaster() {
		return tripForMasterDAO.findAll();
	}

	@Override
	public List<Retainer> getRetainerMaster() {
		return retainerMasterDAO.findAll();
	}

	@Override
	public List<CityMaster> getCityMaster() {
		return cityMasterDAO.getCityMaster();
	}

	@Override
	public List<AccomodationType> getAccomodationType() {
		return accomodationTypeDAO.findAll();
	}

}
