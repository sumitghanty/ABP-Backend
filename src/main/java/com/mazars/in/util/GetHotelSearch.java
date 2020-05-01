package com.mazars.in.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mazars.in.model.intermediatemodel.CustomHotelFilterData;
import com.mazars.in.model.intermediatemodel.CustomHotelModel;
import com.mazars.in.model.intermediatemodel.HotelFilterModel;
import com.mazars.in.model.intermediatemodel.mmt.HotelSearchModel;
import com.mazars.in.model.intermediatemodel.mmt.MmtHotelQueryData;

public class GetHotelSearch {
	
	

	public static void main(String[] args) {
		
		
		HotelFilterModel h = new HotelFilterModel();
		CustomHotelFilterData c = new CustomHotelFilterData();
		c.setGuestRating(3);
		c.setHotelRating(0);
		c.setType("Guest House");
		h.setCustomFilters(c);
		MmtHotelQueryData mmtHotelQueryData = new MmtHotelQueryData();
		mmtHotelQueryData.setCityId("5975825609933066454");
		mmtHotelQueryData.setCheckInDate("20200929");
		mmtHotelQueryData.setCheckOutDate("20200930");
		mmtHotelQueryData.setRooms(1);
		mmtHotelQueryData.setGuests(2);
		h.setQueryData(mmtHotelQueryData);
		
		
		
		try {
		String response = callGET("http://www.goibibobusiness.com/api/hotels/b2b/v2/get_city_hotels/",  h);
		
		
		
		List<CustomHotelModel> list = filterHotels( MMTDataParser.ParseMMTHotelData(response),h);
		
		System.out.println("size"+list.size());
		
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 System.out.println("GET DONE");
	}
	
	
	public static List<CustomHotelModel> filterHotels(List<HotelSearchModel> hotelList,HotelFilterModel filterModel) {
		
		
		List<CustomHotelModel> resultSet =  new ArrayList<CustomHotelModel>();
		CustomHotelModel customHotelObj = null;
		for(int i = 0;i< hotelList.size();i++) {
			customHotelObj = MMTDataParser.createHotelReponseModel(hotelList.get(i));
			
			if(filterModel.getCustomFilters().getGuestRating() <= customHotelObj.getGuestRating()
					&& filterModel.getCustomFilters().getHotelRating() <= customHotelObj.getStarRating()
					) {
				
					
						resultSet.add(customHotelObj);
					
			
				
			}
		}

		return resultSet;
	}

	public static String callGET(String url, HotelFilterModel hotelFilterModel) 
	{
		//String GET_URL="http://prodpp.goibibobusiness.com/api/v1/hotels/search?vhid="+vhid1+"&query="+query;
		//String GET_URL1="http://prodpp.goibibobusiness.com/api/v1/hotels/search?vhid=[\"111583935748037978\",\"1521351329634574589\",\"313781802421733199\",\"1850885978059945015\"]&query=hotels-4213513766539949483-20200929-20200930-1-2_0 ";
		//GET_URL1 = "http://www.goibibobusiness.com/api/hotels/b2b/v2/get_city_hotels/?query=hotels-1914808440588557366-20200620-20200621-1-2_0";
	//GET_URL1 = "http://prodpp.goibibobusiness.com/api/search/?source=CCU&destination=GAU&format=json&dateofdeparture=20200928&adults=1&counter=100 ";
		
		String GET_URL = url+"?query=hotels-"+hotelFilterModel.getQueryData().getCityId()+"-"+hotelFilterModel.getQueryData().getCheckInDate()+"-"+hotelFilterModel.getQueryData().getCheckOutDate()+"-"+hotelFilterModel.getQueryData().getRooms()+"-"+hotelFilterModel.getQueryData().getGuests()+"_0";
	
		System.out.println(GET_URL);
		
		StringBuffer response = new StringBuffer();
		 try {
			 
			 URL obj = new URL(GET_URL);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				String USER_AGENT="";
				con.setRequestProperty("User-Agent", USER_AGENT);
				String auth = "testapi@test.com" + ":" +"test@123";
				 byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));

				 String authHeaderValue = "Basic " + new String(encodedAuth);
				con.setRequestProperty("Authorization", authHeaderValue);
				int responseCode = con.getResponseCode();
				
				System.out.println("GET Response Code :: " + responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					 response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print result
					System.out.println(response.toString());
					
					
		//  }
					
						 
				} else {
					
					BufferedReader in1 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					 String inputLine1;

					 while ((inputLine1 = in1.readLine()) != null) {
					 response.append(inputLine1);
					 }
					 in1.close();
					 // print result+
					 System.out.println(response.toString());
					
					System.out.println("GET request not worked");	
					
			 
		 }
	   }
		 catch(Exception e)
		 {
			 System.out.println("error"+e.toString());
		 }
		 return response.toString();
	}
	

}
