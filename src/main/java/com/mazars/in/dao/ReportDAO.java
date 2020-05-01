package com.mazars.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazars.in.model.transactionmodel.TripCreation;

public interface ReportDAO extends JpaRepository<TripCreation, Integer>{

	
	
	
}
