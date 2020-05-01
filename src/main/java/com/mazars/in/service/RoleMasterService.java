package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.TileMaster;
import com.mazars.in.model.mastermodel.User;

public interface RoleMasterService {
	
	public RoleMaster save(RoleMaster roleMaster);
	public RoleMaster update(RoleMaster roleMaster);
	
	public List<RoleMaster> roleMasterList();
	//public List<Location> locationListByEmailId(String emailId);
	
	public void delete(RoleMaster roleMaster);
	
	public List<TileMaster> getTilesForUser(User user);
}
