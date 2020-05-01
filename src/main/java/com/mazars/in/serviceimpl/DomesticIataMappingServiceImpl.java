package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mazars.in.dao.DomesticIataMappingDAO;
import com.mazars.in.model.mastermodel.DomesticIataMapping;
import com.mazars.in.service.DomesticIataMappingService;

@Service
@Transactional
public class DomesticIataMappingServiceImpl implements DomesticIataMappingService{

	
	private static final Logger logger = LogManager.getLogger(DomesticIataMappingServiceImpl.class);
	
	@Autowired
	private DomesticIataMappingDAO domesticIataMappingDAO;

	@Override
	public String save(DomesticIataMapping domesticIataMapping) {
		// TODO Auto-generated method stub		
		domesticIataMappingDAO.save(domesticIataMapping);
		return "200";
		
	}

	@Override
	public String update(DomesticIataMapping domesticIataMapping) {
		// TODO Auto-generated method stub
		domesticIataMappingDAO.save(domesticIataMapping);
		return "200" ;
		
	}

	@Override
	public List<DomesticIataMapping> list() {
		// TODO Auto-generated method stub
		List<DomesticIataMapping> list = domesticIataMappingDAO.list();
		return list;
		
	}

	@Override
	public String delete(DomesticIataMapping domesticIataMapping) {
		// TODO Auto-generated method stub
		domesticIataMappingDAO.delete(domesticIataMapping);	
		return "200";
		
	}

}
