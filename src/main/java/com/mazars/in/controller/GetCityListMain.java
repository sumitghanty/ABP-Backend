package com.mazars.in.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;
import com.mazars.in.model.mmt.hotelmodel.MMTDataModel;
import com.mazars.in.service.CityMasterService;

public class GetCityListMain {
	private static CityMasterService cityMasterService;
	public GetCityListMain() {}
	
	@Autowired
	public GetCityListMain(CityMasterService masterService)
	{
		cityMasterService=masterService;
	}
	static int page=8;
	public static void main(String args[])
	{
	try {
		for(int i=1;i<=page;i++)
			
	{
			
		GetCityListMain.sendGET("http://www.goibibobusiness.com/api/hotels/b2b/get_city_list/?page=",i);
	}}
	catch(Exception e)
	{
	e.printStackTrace();
	}

	}

	public static void sendGET(String url,int page)
	{
		String GET_URL=url+String.valueOf(page);
		
		System.out.println("value of get url="+GET_URL);
	StringBuffer response = new StringBuffer();
	CityMaster city=null;
	List<CityMaster> cityMaster=new ArrayList<CityMaster>();
	try {

	URL obj = new URL(GET_URL);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	String USER_AGENT="";
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	con.setRequestProperty("Content-type", "application/JSON");
	con.setRequestProperty("Accept",  "application/JSON");
	String auth = "testapi@test.com" + ":" +"test@123";
	byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));

	String authHeaderValue = "Basic " + new String(encodedAuth);
	con.setRequestProperty("Authorization", authHeaderValue);

	con.setDoOutput(true);

	int responseCode = con.getResponseCode();

	System.out.println("GET Response Code :: " + responseCode);
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response1 = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
	response1.append(inputLine);
	}
	in.close();

	// print result
	System.out.println(response1.toString());
	 Gson gson = new Gson();
	 ObjectMapper mapper=new ObjectMapper();
	       Type type = new TypeToken<MMTDataModel>(){}.getType();
	       MMTDataModel cityMap = gson.fromJson(response1.toString(), type);
	       Iterator<Map.Entry<String, CityMaster>> itr = cityMap.getData().entrySet().iterator();
	       ArrayList<CityMaster> master=null;
	       while(itr.hasNext())
	       {
	        Map.Entry<String, CityMaster> entry = itr.next();
	       
	        CityMaster master2=(CityMaster)entry.getValue();
	        master2.setCityid(entry.getKey());
	        
	        cityMaster.add(master2);
	       }
           System.out.println("size of citylist"+cityMaster.size());
	       if(!CollectionUtils.isEmpty(cityMaster))
	       {
	       cityMasterService.save(cityMaster);
	       }

	} else {

	BufferedReader in1 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	String inputLine1;

	while ((inputLine1 = in1.readLine()) != null) {
	response.append(inputLine1);
	}
	in1.close();

	System.out.println(response.toString());

	System.out.println("GET request not worked");


	}


	}
	catch(Exception e)
	{
		e.printStackTrace();

	}
	}
	}

