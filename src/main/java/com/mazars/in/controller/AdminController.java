package com.mazars.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.intermediatemodel.UserDetails;
import com.mazars.in.model.intermediatemodel.UserModel;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.service.AdminService;

@RestController
public class AdminController {

@Autowired
AdminService adminservice;

@RequestMapping(value="/createMasterData",method=RequestMethod.POST)
public void createMasterData() {
	
	 adminservice.save();
	
}

@RequestMapping(value="/getalluser",method=RequestMethod.POST)
public List<User> getalluser() {
	
	return adminservice.getalluser();
	
}

@RequestMapping(value="/getUserInfo",method=RequestMethod.POST)
public List<UserDetails> getUserInfo(@RequestBody UserModel userdata) {
	String searchparam=userdata.getSearch();
	return adminservice.getUserInfo(searchparam);
	
}

@RequestMapping(value="/updateUserInfo",method=RequestMethod.POST)
public List<UserDetails> updateUserInfo(@RequestBody List<UserDetails> userdetails) {
	
	return adminservice.updateUserInfo(userdetails);
	
}




}
