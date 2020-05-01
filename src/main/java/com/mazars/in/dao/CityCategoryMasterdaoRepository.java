package com.mazars.in.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.CityCategoryMaster;
@Repository
public interface CityCategoryMasterdaoRepository extends JpaRepository<CityCategoryMaster, Integer> {
	@Query("SELECT cc FROM CityCategoryMaster cc where lower(cc.categoryTypeDesc) like %:categorytype%")
	public List<CityCategoryMaster> findByCategoryName(@Param("categorytype") String categorytype);
}
