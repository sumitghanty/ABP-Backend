package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.TileMasterDAO;
import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.service.TileMasterService;

@Service
@Transactional
public class TileMasterServiceImpl implements TileMasterService{
private static final Logger logger = LogManager.getLogger(TileMasterServiceImpl.class);
	
    @Autowired
	private TileMasterDAO tileMasterDAO;

	@Override
	public String save(List<TileMaster> master) {
		tileMasterDAO.saveAll(master);
	return null;
	
	}

	@Override
	public List<TileMaster> list() {
		
		return tileMasterDAO.findAll();
				
	}

}
