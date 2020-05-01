package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.CityCategoryMaster;
import com.mazars.in.model.mastermodel.OrganizationMaster;
@Repository
public interface OrganizationMasterDaoRepository  extends JpaRepository<OrganizationMaster, Integer>{
	@Query("SELECT o FROM OrganizationMaster o where lower(o.organizationName) like %:orgname%")
	public List<OrganizationMaster> findByOrganizationName(@Param("orgname") String orgname);
}
