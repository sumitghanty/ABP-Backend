package com.mazars.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.service.RoleMasterService;

@RestController
public class RoleMasterController {
	@Autowired
	private RoleMasterService roleMasterService;
	@RequestMapping(value = "/createRole", method = RequestMethod.POST)
	public String createRole(@RequestBody RoleMaster roleMaster,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) {
		roleMasterService.save(roleMaster);
		//roleMasterService.getTilesForUser(null);
		return "success";
	}
}
