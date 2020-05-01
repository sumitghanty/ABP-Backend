/*
 * This class will store login related information
 * 
 * 
 */


package com.mazars.in.model.transactionmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@Entity
@EnableJpaAuditing
@Table(name="tbl_login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="user_id")
	private String userId;
	@Column(name="user_email")
	private String userEmail;
	@Column(name="userName")
	private String userName;
	//@CreationTimestamp
	@Column(name="login_time")
	private Date loginTime;
	
	@Column(name="logout_time")
	private Date logoutTime;
	@Column(name="google_token",columnDefinition="LONGTEXT")
	private String googleToken;
	
	@Column(name="latest_access_time")
	
	private Date latestAccessTime;
	
	@Column(name="generated_token")
	private String generatedToken;
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public String getGoogleToken() {
		return googleToken;
	}
	public void setGoogleToken(String googleToken) {
		this.googleToken = googleToken;
	}
	public String getGeneratedToken() {
		return generatedToken;
	}
	public void setGeneratedToken(String generatedToken) {
		this.generatedToken = generatedToken;
	}
	public Date getLatestAccessTime() {
		return latestAccessTime;
	}
	public void setLatestAccessTime(Date latestAccessTime) {
		this.latestAccessTime = latestAccessTime;
	}
	
	
}
