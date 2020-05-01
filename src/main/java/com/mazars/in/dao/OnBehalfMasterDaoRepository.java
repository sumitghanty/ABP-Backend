package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.OnBehalfMaster;
@Repository
public interface OnBehalfMasterDaoRepository extends JpaRepository<OnBehalfMaster, Integer>{
	@Query("SELECT o FROM OnBehalfMaster o where lower(o.excuteName) like %:exename%")
	public List<OnBehalfMaster> findByexecutiveName(@Param("exename") String exename);
}
