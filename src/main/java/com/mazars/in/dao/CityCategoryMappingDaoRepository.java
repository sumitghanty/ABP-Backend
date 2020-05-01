package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.CityCategoryMapping;
@Repository
public interface CityCategoryMappingDaoRepository extends JpaRepository<CityCategoryMapping, Integer>{
	@Query("SELECT e FROM CityCategoryMapping e where e.cityID =?1 and e.cityCategoryId=?2")
	public List<CityCategoryMapping> findBycitycategoryid(@Param("cityid") int cityid,@Param("categoryid") int categoryid);

}
