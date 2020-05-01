package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseRailwayAgentMapping;
@Repository
public interface LocationWiseRailwayAgentMappingDao extends JpaRepository<LocationWiseRailwayAgentMapping, Integer>{
	@Query("SELECT u FROM LocationWiseRailwayAgentMapping u where u.locationwiserailwaymasterid =?1")
	public List<LocationWiseRailwayAgentMapping> findByrailwayagentId(@Param("railwayid") int railwayid);
}
