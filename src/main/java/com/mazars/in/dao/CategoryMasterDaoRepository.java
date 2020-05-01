package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.CategoryMaster;

@Repository
public interface CategoryMasterDaoRepository extends JpaRepository<CategoryMaster, Integer>{
	@Query("SELECT c FROM CategoryMaster c where lower(c.categoryName) like %:categoryname%")
	public List<CategoryMaster> findBycategoryName(@Param("categoryname") String categoryname);
}
