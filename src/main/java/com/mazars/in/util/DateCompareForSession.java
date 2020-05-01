/*package com.mazars.in.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.mazars.in.common.Constants;
import com.mazars.in.model.transactionmodel.Login;
import com.mazars.in.service.LoginService;

public class DateCompareForSession {
	
	static String differenceInTime;
	
	@Autowired
	private LoginService loginService;
	public String sessionExpiredOrNot(String token,String emailID) throws ParseException
	{
	   Login loginDetails=loginService.getLoginDetails(token, emailID);	  
	   if(loginDetails!=null)
	   {
		   Date latestAccessDateFromDb=loginDetails.getLatestAccessTime(); 
		   Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
			String a=formatter.format(date);
			Date currentTime = formatter.parse(a);
			long diff = currentTime.getTime() - latestAccessDateFromDb.getTime();
			long diff2=diff/1000;
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			 System.out.println("difference in seconds="+diffSeconds+"diff in time="+diff
					 +"diffMinutes="+diffMinutes+"diff2--->"+diff2);
			
			if(diff2>Constants.session_Time_Out_Time)
			{
			
				return differenceInTime=Constants.session_Expired;
			}
			else
			{
				//loginService.setLatestAccessTime(currentTime,token,emailID);
				
				return differenceInTime=Constants.valid_Session;  
			}
	   }
	   else
	   {
		   
		   return differenceInTime=Constants.loginId_Or_Token_DoesNot_Matched;
	   }
		
	
		
	
	
}
}*/