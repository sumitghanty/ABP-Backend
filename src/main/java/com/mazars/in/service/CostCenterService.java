package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.CostCenterMaster;

public interface CostCenterService {
	public void save(CostCenterMaster costCenter);
	public void update(CostCenterMaster costCenter);
	
	public List<CostCenterMaster> costCenterList();
	public List<CostCenterMaster> costCenterByEmailId(String emailId);
	
	public void delete(CostCenterMaster costCenter);
}
