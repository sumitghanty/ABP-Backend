package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationMaster;
@Repository
public interface LocationMasterDaoRepository extends JpaRepository<LocationMaster, Integer>{
	@Query("SELECT l FROM LocationMaster l where lower(l.location) like %:locationname%")
	public List<LocationMaster> findBylocationName(@Param("locationname") String locationname);
}
