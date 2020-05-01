package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.EventCostCenterMapping;
@Repository
public interface EventCostCenterMappingDao extends JpaRepository<EventCostCenterMapping, Integer>{
	@Query("SELECT e FROM EventCostCenterMapping e where e.eventId =?1 and e.costCenterId=?2")
	public List<EventCostCenterMapping> findByeventCostCenter(@Param("eventid") int eventid,@Param("costcenterid") int costcenterid);
}
