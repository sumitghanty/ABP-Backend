package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.UserGroupMaster;
@Repository
public interface UserGroupMasterDaoRepository extends JpaRepository<UserGroupMaster, Integer>{
	@Query("SELECT u FROM UserGroupMaster u where lower(u.groupName) like %:groupname%")
	public List<UserGroupMaster> findBygroupName(@Param("groupname") String groupname);
}
