package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.EventMaster;
@Repository
public interface EventMasterDaoRepository extends JpaRepository<EventMaster, Integer> {
	@Query("SELECT e FROM EventMaster e where e.eventCode =?1")
	public List<EventMaster> findByeventCode(@Param("eventcode") int eventcode);
}
