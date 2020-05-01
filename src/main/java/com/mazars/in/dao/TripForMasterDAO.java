package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.TripForMaster;
@Repository
public interface TripForMasterDAO extends JpaRepository<TripForMaster, Integer>{
	@Query("select t from TripForMaster t")
	public List<TripForMaster> getTripForMaster();
}
