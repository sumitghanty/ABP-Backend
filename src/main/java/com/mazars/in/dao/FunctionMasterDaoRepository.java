package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.FunctionMaster;
@Repository
public interface FunctionMasterDaoRepository extends JpaRepository<FunctionMaster, Integer>{
	@Query("SELECT f FROM FunctionMaster f where lower(f.functionName) like %:functionname%")
	public List<FunctionMaster> findByfunctionName(@Param("functionname") String functionname);

}
