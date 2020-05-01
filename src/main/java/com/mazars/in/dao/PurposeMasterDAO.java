package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.PurposeMaster;
@Repository
public interface PurposeMasterDAO extends JpaRepository<PurposeMaster, Integer>{

	@Query("select p from PurposeMaster p")
	public List <PurposeMaster> getPurposeMaster();
	/*public void save(PurposeMaster purposeMaster);
	public void update(PurposeMaster purposeMaster);
	
	public List<PurposeMaster> purposeMasterList();
	//public List<Location> locationListByEmailId(String emailId);
	
	public void delete(PurposeMaster purposeMaster);*/
	
}
