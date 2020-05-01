package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.Retainer;
@Repository
public interface RetainerDaoRepository extends JpaRepository<Retainer, Integer>{
	@Query("SELECT r FROM Retainer r where r.retaineremployeecode=?1")
	public List<Retainer> findByretainerEmployeecode(@Param("empcode") int empcode);

	@Query("select r from Retainer r")
	public List<Retainer> getRetainerMaster();
}
