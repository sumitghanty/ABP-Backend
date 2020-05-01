package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.SubDepartmentMaster;

@Repository
public interface SubDepartmentMasterDaoRepository extends JpaRepository<SubDepartmentMaster, Integer>{
	@Query("SELECT sd FROM SubDepartmentMaster sd where lower(sd.subdepartmentCode) like %:subdepname%")
	public List<SubDepartmentMaster> findBysubdepertmentName(@Param("subdepname") String subdepname);
}
