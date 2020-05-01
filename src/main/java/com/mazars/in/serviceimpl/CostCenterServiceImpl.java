package com.mazars.in.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mazars.in.dao.CostCenterMasterDaoRepository;
import com.mazars.in.model.mastermodel.CostCenterMaster;
import com.mazars.in.service.CostCenterService;
@Service
@Transactional
public class CostCenterServiceImpl implements CostCenterService{
private static final Logger logger = LogManager.getLogger(CostCenterServiceImpl.class);
	
    @Autowired
	private CostCenterMasterDaoRepository costCenterDAO;
	
	
	

	@Override
	public void save(CostCenterMaster costCenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CostCenterMaster costCenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CostCenterMaster> costCenterList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CostCenterMaster> costCenterByEmailId(String emailId) {
		/*List<CostCenterMaster> costCenterList=costCenterDAO.costCenterList();
		return costCenterList;*/
		return null;
	}

	@Override
	public void delete(CostCenterMaster costCenter) {
		// TODO Auto-generated method stub
		
	}

}
