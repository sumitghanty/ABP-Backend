package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.LocationWiseFinanceMaster;
@Repository
public interface LocationWiseFinanceDao extends JpaRepository<LocationWiseFinanceMaster, Integer>{
	@Query("SELECT o FROM LocationWiseFinanceMaster o where lower(o.approverUser1) like %:approver1%")
	public List<LocationWiseFinanceMaster> findByApproverName(@Param("approver1") String approver1);
}
