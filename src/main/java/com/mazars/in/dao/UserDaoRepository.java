package com.mazars.in.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.mastermodel.User;
@Repository
public interface UserDaoRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u where u.employeeCode =?1")
	public List<User> findByemployeeCode(@Param("empcode") int empcode);
	
	@Query("select u from User u")
	public List<User> list();
	
	@Query(("select u from User u where u.employeeCode=:userId"))
	public User getUserData(@Param("userId") String userId);
	
	
	
	
	//public void delete(User user);
	
	@Query("from User where userEmailId=:userEmail")
	public User loginVerification(@Param("userEmail") String userEmail);
	
	@Query("SELECT u FROM User u where lower(u.userEmailId) like %:searchparam% or lower(u.userFirstName) like %:searchparam%")
	public List<User> findByempcodeemailid(@Param("searchparam") String searchparam);
}
