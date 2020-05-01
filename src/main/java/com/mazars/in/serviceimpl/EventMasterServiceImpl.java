package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.EventMasterDaoRepository;
import com.mazars.in.model.mastermodel.EventMaster;
import com.mazars.in.service.EventMasterService;
@Service
@Transactional
public class EventMasterServiceImpl implements EventMasterService{
private static final Logger logger = LogManager.getLogger(CostCenterServiceImpl.class);
	@Autowired
	private EventMasterDaoRepository eventMasterDAO;
	
	
	@Override
	public void save(EventMaster eventMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EventMaster eventMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventMaster> eventMasterList() {
		List<EventMaster> eventMasterList=eventMasterDAO.findAll();
		return eventMasterList;
	}

	@Override
	public void delete(EventMaster eventMaster) {
		// TODO Auto-generated method stub
		
	}

}
