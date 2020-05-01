/*package com.mazars.in.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mazars.in.model.transactionmodel.Login;


	@Repository
	public interface LoginDAORepository extends JpaRepository<Login, Integer>{
		
		 
		public Login getLogin(String googleToken,int userId,String emailId);
		
		public Long getLoginById(String googleToken,String emailId);
		
		public Date getLatestAccessTime(String googleToken,String emailId);
		
		public Date setLatestAccessTime(Date currentTime,String token,String emailID);
		
		 @Query("select l from Login l where l.userEmail=:emailId and l.generatedToken=:generatedToken order by id")
		public Login getLoginDetails(@Param("email") String emailId,@Param("generatedToken") String generatedToken);
	
	}

	

*/