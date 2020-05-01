package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.TravelTypeMaster;
@Repository
public interface TravelTypeMasterDAO extends JpaRepository<TravelTypeMaster, Integer>{
	@Query("select p from TravelTypeMaster p")
	public  List<TravelTypeMaster> getTravelTypeMaster();
}
