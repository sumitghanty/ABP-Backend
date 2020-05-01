package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mmt.hotelmodel.CityMaster;


@Repository
public interface CityMasterDAO extends JpaRepository<CityMaster, Integer>{

	//public void save(List<CityMaster> citymaster);
	//public void update(CityMaster citymaster);
	@Query("select c from CityMaster c where c.countryName='india'")
	public List<CityMaster> getCityMaster();
	
	@Query("select city from CityMaster city")
	public List<CityMaster> list();

	
	//public void saveAll(List<CityMaster> citymaster);
	
	

}
