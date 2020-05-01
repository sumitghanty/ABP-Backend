package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.UserMapping;
@Repository
public interface UserMappingDaoRepository extends JpaRepository<UserMapping, Integer>{
	@Query("SELECT um FROM UserMapping um where um.userId=?1")
	public List<UserMapping> findByuserid(@Param("userid") int userid);
}
