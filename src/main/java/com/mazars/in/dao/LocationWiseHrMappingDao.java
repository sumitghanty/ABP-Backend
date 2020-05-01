package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseHrMapping;
@Repository
public interface LocationWiseHrMappingDao extends JpaRepository<LocationWiseHrMapping, Integer>{
	@Query("SELECT u FROM LocationWiseHrMapping u where u.locationwisehrmasterid =?1")
	public List<LocationWiseHrMapping> findByhrId(@Param("hrid") int hrid);
}
