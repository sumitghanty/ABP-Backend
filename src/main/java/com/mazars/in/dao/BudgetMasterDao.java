package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.BudgetMaster;
@Repository
public interface BudgetMasterDao extends JpaRepository<BudgetMaster, Integer>{
	@Query("SELECT o FROM BudgetMaster o where lower(o.user_email_id) like %:emailid%")
	public List<BudgetMaster> findByUseremailid(@Param("emailid") String emailid);
}
