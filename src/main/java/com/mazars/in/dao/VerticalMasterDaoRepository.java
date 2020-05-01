package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.OrganizationMaster;
import com.mazars.in.model.mastermodel.VerticalMaster;
@Repository
public interface VerticalMasterDaoRepository extends JpaRepository<VerticalMaster, Integer>{
	
	@Query("SELECT v FROM VerticalMaster v where lower(v.verticalName) like %:verticalname%")
	public List<VerticalMaster> findByVerticalName(@Param("verticalname") String verticalname);

}
