package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseCarpoolMaster;
@Repository
public interface LocationWiseCarpoolMasterDao extends JpaRepository<LocationWiseCarpoolMaster, Integer>{
	@Query("SELECT o FROM LocationWiseCarpoolMaster o where lower(o.User1) like %:approver1% and lower(o.User2) like %:approver2%")
	public List<LocationWiseCarpoolMaster> findByuserName(@Param("approver1") String approver1,@Param("approver2") String approver2);

}
