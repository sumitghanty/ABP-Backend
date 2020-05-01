package com.mazars.in.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mazars.in.model.mastermodel.RoleToTilemapping;


public interface RoleToTilemappingService {
	public String save(RoleToTilemapping roleToTilemapping);
	public String update(RoleToTilemapping roleToTilemapping);
	
	public List<RoleToTilemapping> list();
	public List<RoleToTilemapping> tripListByEmailId(String emailId);
	public String delete(RoleToTilemapping roleToTilemapping);
}
