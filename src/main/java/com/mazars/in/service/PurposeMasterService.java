package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.PurposeMaster;

public interface PurposeMasterService {
	public void save(PurposeMaster purposeMaster);
	public void update(PurposeMaster purposeMaster);
	
	public List<PurposeMaster> purposeMasterList();
	//public List<Location> locationListByEmailId(String emailId);
	
	public void delete(PurposeMaster purposeMaster);
}
