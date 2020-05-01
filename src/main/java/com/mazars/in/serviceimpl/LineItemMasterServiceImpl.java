package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.LineItemMasterDAO;
import com.mazars.in.model.transactionmodel.LineItemMaster;
import com.mazars.in.service.LineItemMasterService;
@Service
@Transactional
public class LineItemMasterServiceImpl implements LineItemMasterService{

	private LineItemMasterDAO lineItemMasterDAO;
	
	
	public LineItemMasterDAO getlineItemMasterDAO() {
		return lineItemMasterDAO;
	}

	public void setlineItemMasterDAO(LineItemMasterDAO lineItemMasterDAO) {
		this.lineItemMasterDAO = lineItemMasterDAO;
	}

	@Override
	public String save(LineItemMaster lineItemMaster) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		lineItemMasterDAO.save(lineItemMaster);
		return null;
	}

	@Override
	public String update(LineItemMaster lineItemMaster) {
		lineItemMasterDAO.update(lineItemMaster);
		return null;
	}

	@Override
	public List<LineItemMaster> list() {
		List<LineItemMaster> lineItemMaster=lineItemMasterDAO.list();
		return lineItemMaster;
	}

	@Override
	public String delete(LineItemMaster lineItemMaster) {
		lineItemMasterDAO.delete(lineItemMaster);
		return null;
	}

}
