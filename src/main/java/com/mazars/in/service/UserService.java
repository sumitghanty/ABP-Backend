package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.mastermodel.RoleToTilemapping;
import com.mazars.in.model.mastermodel.User;

public interface UserService {
	public User save(User user);
	public User update(User user);
	
	public List<User> list();
	public String delete(User user);
	public User getUserData(String userId);
	public User loginVerification(String userEmail);
	public List<RoleToTilemapping> getRoleData(User user1,List<RoleMaster> roleMaster);
}
