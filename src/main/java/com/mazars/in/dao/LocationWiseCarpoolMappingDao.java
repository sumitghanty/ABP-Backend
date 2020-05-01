package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseCarpoolMapping;
@Repository
public interface LocationWiseCarpoolMappingDao extends JpaRepository<LocationWiseCarpoolMapping, Integer>{
	@Query("SELECT u FROM LocationWiseCarpoolMapping u where u.locationwisecarpoolmasterid =?1")
	public List<LocationWiseCarpoolMapping> findBycarpooltId(@Param("carpoolid") int carpoolid);
}
