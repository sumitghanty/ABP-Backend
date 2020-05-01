package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.BudgetMasterMapping;
@Repository
public interface BudgetMasterMappingDao extends JpaRepository<BudgetMasterMapping, Integer>{
	@Query("SELECT u FROM BudgetMasterMapping u where u.budgetId =?1")
	public List<BudgetMasterMapping> findBybudgetId(@Param("budgetid") int budgetid);
}
