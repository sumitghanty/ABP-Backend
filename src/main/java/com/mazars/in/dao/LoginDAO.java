package com.mazars.in.dao;





import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mazars.in.model.transactionmodel.Login;
@Repository
@Transactional
public interface LoginDAO extends JpaRepository<Login, Integer>{
	//Login findByuserEmailngeneratedToken(String emailId,String generatedToken);
	/*public Login getLogin(String googleToken,int userId,String emailId);
	public Long getLoginById(String googleToken,String emailId);*/
	@Query("SELECT l.latestAccessTime from Login l WHERE l.userEmail= ?1 AND l.generatedToken= ?2 order by id")
	public Date getLatestAccessTime(String emailId,String generatedToken);
	
	/*@Query("select l from Login l where l.userEmail=:emailId and l.generatedToken=:generatedToken and latestAccessTime=:currentTime order by id")
	public Date setLatestAccessTime(@Param("currentTime") Date currentTime,@Param("emailId") String emailId,@Param("generatedToken") String generatedToken);*/
	
	@Transactional
	@Modifying
	@Query("update Login l set l.latestAccessTime=?1 where l.generatedToken=?2")
	public void setLatestAccessTime(Date currentTime,String generatedToken);
	
	
	 @Query("SELECT l from Login l WHERE l.userEmail=:emailId and l.generatedToken=:generatedToken")
	public Login getLoginDetails(@Param("emailId") String emailId,@Param("generatedToken") String generatedToken);
	
	/* @Query("SELECT l from Login l WHERE l.generatedToken=:generatedToken")
		public Login getLoginDetails(@Param("generatedToken") String generatedToken);*/
	
	 
	
}
