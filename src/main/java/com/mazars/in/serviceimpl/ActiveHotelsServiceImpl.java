package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.ActiveHotelsDAO;
import com.mazars.in.model.mastermodel.ActiveHotels;
import com.mazars.in.service.ActiveHotelsService;

@Service
@Transactional
public class ActiveHotelsServiceImpl implements ActiveHotelsService{

	
	private static final Logger logger = LogManager.getLogger(ActiveHotelsServiceImpl.class);
	
	@Autowired
	private ActiveHotelsDAO activeHotelsDAO;	
	
	@Override
	public String save(ActiveHotels activeHotels) {			
		activeHotelsDAO.save(activeHotels);
		return "200";
		
	}

	@Override
	public String update(ActiveHotels activeHotels) {
		// TODO Auto-generated method stub
		activeHotelsDAO.save(activeHotels);
		return "200" ;
		
	}

	@Override
	public List<ActiveHotels> list() {
		// TODO Auto-generated method stub
		List<ActiveHotels> list = activeHotelsDAO.findAll();
		return list;
		
	}

	@Override
	public String delete(ActiveHotels activeHotels) {
		// TODO Auto-generated method stub
		activeHotelsDAO.delete(activeHotels);	
		return "200";
		
	}

}
