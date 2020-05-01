package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.RoleToTilemapping;

@Repository
public interface RoleToTilemappingDAO extends JpaRepository<RoleToTilemapping, Integer>{


	//public void save(RoleToTilemapping roleToTilemapping);
	//public void update(RoleToTilemapping roleToTilemapping);
	
	//public List<RoleToTilemapping> list();
	
	@Query("from RoleToTilemapping where userEmailId=:emailId")
	public List<RoleToTilemapping> roleListByEmailId(@Param("emailId") String emailId);
	
	//public void delete(RoleToTilemapping roleToTilemapping);
	
}
