package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseFinanceMapping;
@Repository
public interface LocationWiseFinanceMappingDao extends JpaRepository<LocationWiseFinanceMapping, Integer>{
	@Query("SELECT u FROM LocationWiseFinanceMapping u where u.locationwisefinancemasterid =?1")
	public List<LocationWiseFinanceMapping> findByfinanceId(@Param("financeid") int financeid);
}
