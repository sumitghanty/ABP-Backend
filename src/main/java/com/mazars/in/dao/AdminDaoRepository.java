package com.mazars.in.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.OrganizationMaster;

@Repository
public interface AdminDaoRepository extends JpaRepository<OrganizationMaster, Integer> {
	
	/*@Query("SELECT o FROM Organization o where o.organizationName = :orgname")
	public Optional<Organization> findByName(@Param("orgname") String orgname);*/

}
