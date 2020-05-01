package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseHrMaster;
@Repository
public interface LocationWiseHrMasterDao extends JpaRepository<LocationWiseHrMaster, Integer>{
	@Query("SELECT o FROM LocationWiseHrMaster o where lower(o.approverUser1) like %:approver1% and lower(o.approverUser2) like %:approver2%")
	public List<LocationWiseHrMaster> findByApproverName(@Param("approver1") String approver1,@Param("approver2") String approver2);

}
