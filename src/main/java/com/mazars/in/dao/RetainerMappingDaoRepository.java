package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.RetainerMapping;
@Repository
public interface RetainerMappingDaoRepository extends JpaRepository<RetainerMapping, Integer>{
	@Query("SELECT r FROM RetainerMapping r where r.retainerId=?1")
	public List<RetainerMapping> findByretainerid(@Param("retainerid") int retainerid);
}
