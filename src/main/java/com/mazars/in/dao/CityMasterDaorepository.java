package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mmt.hotelmodel.CityMaster;


@Repository
public interface CityMasterDaorepository extends JpaRepository<CityMaster, Integer> {

	@Query("SELECT c FROM CityMaster c where lower(c.cityName) LIKE %:cityname%")
	public List<CityMaster> findByCityName(@Param("cityname") String cityname);
}
