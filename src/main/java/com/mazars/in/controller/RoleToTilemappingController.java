package com.mazars.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.RoleToTilemapping;
import com.mazars.in.service.RoleToTilemappingService;

@RestController
public class RoleToTilemappingController {
@Autowired	
private RoleToTilemappingService roleService;
	@RequestMapping(value = "/createRoleToTile", method = RequestMethod.POST)
	public String createRoleToTile(@RequestBody RoleToTilemapping roleToTilemapping) {
		String toFrontEnd=roleService.save(roleToTilemapping);
		return toFrontEnd ;
	}
}
