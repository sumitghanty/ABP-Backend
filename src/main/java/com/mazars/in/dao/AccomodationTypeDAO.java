package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.AccomodationType;
@Repository
public interface AccomodationTypeDAO extends JpaRepository<AccomodationType, Integer>{
	@Query("select a from AccomodationType a")
	public List<AccomodationType> getAccomodationType();
}
