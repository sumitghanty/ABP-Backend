package com.mazars.in.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Util {
public static String getAgeOfReq(String creationDate) {
	if(creationDate == null || creationDate == "") {
		return "";
	}
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	 Date startDate = null;
	  
	    try {
	    	startDate = format.parse(creationDate);
	       
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	
			Date endDate   = new Date();// Set end date

			long duration  = endDate.getTime() - startDate.getTime();

			
			long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
			return diffInDays+"";
	
}
}
