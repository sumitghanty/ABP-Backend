package com.mazars.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.FinancialYearMaster;
@Repository
public interface FinancialYearMasterdaoRepository  extends JpaRepository<FinancialYearMaster, Integer>{

}
