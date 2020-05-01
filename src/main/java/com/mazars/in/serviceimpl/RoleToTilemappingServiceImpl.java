package com.mazars.in.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.dao.RoleToTilemappingDAO;
import com.mazars.in.model.mastermodel.RoleToTilemapping;
import com.mazars.in.service.RoleToTilemappingService;

@Service
@Transactional
public class RoleToTilemappingServiceImpl implements RoleToTilemappingService{
	
	@Autowired
	private RoleToTilemappingDAO roleToTilemappingDAO;
	

	@Override
	public String save(RoleToTilemapping roleToTilemapping) {
		roleToTilemappingDAO.save(roleToTilemapping);
		return "200";
	}

	@Override
	public String update(RoleToTilemapping roleToTilemapping) {
		roleToTilemappingDAO.save(roleToTilemapping);
		return "200";
	}

	@Override
	public List<RoleToTilemapping> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleToTilemapping> tripListByEmailId(String emailId) {
		List<RoleToTilemapping> list = roleToTilemappingDAO.roleListByEmailId(emailId);

		return list;
	}

	@Override
	public String delete(RoleToTilemapping roleToTilemapping) {
		roleToTilemappingDAO.delete(roleToTilemapping);
		return "200";
	}
	
}
