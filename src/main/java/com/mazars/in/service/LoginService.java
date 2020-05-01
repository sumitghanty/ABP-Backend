package com.mazars.in.service;

import java.util.Date;

import com.mazars.in.model.transactionmodel.Login;

public interface LoginService {
	
	public Login getLogin(String googleToken,String userId,String emailId);
	//public Long getLoginById(String googleToken,String emailId);
	public Date getLatestAccessTime(String googleToken,String emailId);
	public void setLatestAccessTime(Date currentTime,String token,String emailID);
	public Login getLoginDetails(String token,String emailId);

}
