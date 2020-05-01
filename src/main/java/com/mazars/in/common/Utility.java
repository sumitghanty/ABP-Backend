package com.mazars.in.common;

import java.util.UUID;

public class Utility {
	
	private static String uniqueID=null;
	public static String generateUID() {
	
		uniqueID= UUID.randomUUID().toString();
	
	return uniqueID;
	
	}
}
