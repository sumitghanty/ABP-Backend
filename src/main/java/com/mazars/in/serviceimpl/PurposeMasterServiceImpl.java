package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.PurposeMasterDAO;
import com.mazars.in.model.mastermodel.PurposeMaster;
import com.mazars.in.service.PurposeMasterService;
@Service
@Transactional
public class PurposeMasterServiceImpl implements PurposeMasterService{
private static final Logger logger = LogManager.getLogger(PurposeMasterServiceImpl.class);
	@Autowired
	private PurposeMasterDAO purposeMasterDAO;
	
	public PurposeMasterDAO getPurposeMasterDAO() {
		return purposeMasterDAO;
	}

	public void setPurposeMasterDAO(PurposeMasterDAO purposeMasterDAO) {
		this.purposeMasterDAO = purposeMasterDAO;
	}

	@Override
	public void save(PurposeMaster purposeMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PurposeMaster purposeMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PurposeMaster> purposeMasterList() {
		List<PurposeMaster> p=	purposeMasterDAO.findAll();
		return p;
	}

	@Override
	public void delete(PurposeMaster purposeMaster) {
		// TODO Auto-generated method stub
		
	}

}
