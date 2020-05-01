package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.DepartmentMaster;
@Repository
public interface DepartmentMasterDaoRepository extends JpaRepository<DepartmentMaster, Integer>{
	@Query("SELECT d FROM DepartmentMaster d where lower(d.departmentCode) like %:departmentname%")
	public List<DepartmentMaster> findBydepartmentName(@Param("departmentname") String departmentname);

}
