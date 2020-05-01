package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.CostCenterMaster;
@Repository
public interface CostCenterMasterDaoRepository extends JpaRepository<CostCenterMaster, Integer>{
	@Query("SELECT c FROM CostCenterMaster c where lower(c.costCenter) like %:costcenter%")
	public List<CostCenterMaster> findBycostCenterName(@Param("costcenter") String costcenter);
}
