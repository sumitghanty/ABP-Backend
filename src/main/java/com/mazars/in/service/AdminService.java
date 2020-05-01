package com.mazars.in.service;

import java.util.List;

import com.mazars.in.model.intermediatemodel.UserDetails;
import com.mazars.in.model.mastermodel.User;

public interface AdminService {
	
	public void save();
	//public List<Organization> findAll();
	public List<UserDetails> getUserInfo(String searchparam);
	public List<UserDetails> updateUserInfo(List<UserDetails> userdetails);
	public List<User> getalluser();
	

}
