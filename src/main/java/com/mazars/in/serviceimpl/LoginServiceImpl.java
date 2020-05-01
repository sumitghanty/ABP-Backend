package com.mazars.in.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazars.in.common.Utility;
import com.mazars.in.dao.LoginDAO;
import com.mazars.in.model.transactionmodel.Login;
import com.mazars.in.service.LoginService;
@Service

public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDAO;
	
	public Login getLogin(String googleToken,String userId,String emailId)  {
		Login login=new Login();
		try
	    {
		Date date = new Date();
		//SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String strDate = formatter.format(date); 
		Date date1=formatter.parse(strDate);  
		formatter = new SimpleDateFormat("");  
	    strDate = formatter.format(date);  
		login.setGoogleToken(googleToken);
		login.setUserId(userId);
		login.setGeneratedToken(Utility.generateUID());
		login.setUserEmail(emailId);
		login.setLoginTime(date1);
		login.setLatestAccessTime(date1);
		//login.setLogoutTime(date1);
		loginDAO.save(login);
	}
	catch(Exception e)
	{
		System.out.println("samit"+e.toString());
	}
		return  login;
	}

	/*public Long getLoginById(String googleToken,String emailId)
	{
		Long a=loginDAO.getLoginById(googleToken, emailId);
		return a;
	}
	*/
	public Date getLatestAccessTime(String googleToken,String emailId)
	{
		/*Date latestDateAndTime=loginDAO.getLatestAccessTime(googleToken, emailId);
		System.out.println("latestDateAndTime"+latestDateAndTime);
		
		return latestDateAndTime;*/
		return null;
	}
	public void setLatestAccessTime(Date currentTime,String token,String emailID)
	{
		loginDAO.setLatestAccessTime(currentTime,token);
		//return latestDateAndTime;
	}

	@Override
	public Login getLoginDetails(String token, String emailId) {
		Login login=loginDAO.getLoginDetails(emailId,token);		
		return login;
	}
}
