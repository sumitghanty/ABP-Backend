package com.mazars.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.TileMaster;

@Repository
public interface TileMasterDAO extends JpaRepository<TileMaster, Integer>{
	//public String save(List<TileMaster> master);
	
	/*@Query("select tm from TileMaster tm")
	public List<TileMaster> list();*/
}
