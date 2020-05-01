package com.mazars.in.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mazars.in.common.Constants;
import com.mazars.in.model.intermediatemodel.CustomFlightModel;
import com.mazars.in.model.intermediatemodel.FlightFilterModel;
import com.mazars.in.model.intermediatemodel.FlightResponseModel;
import com.mazars.in.model.intermediatemodel.mmt.FlightSearchModel;
import com.mazars.in.model.intermediatemodel.mmt.MMTDataModel;

public class GetFlightSearch {

	
	@Value("${travelAgent}")
	private static String travelAgent;
	
	//private static String travelAgent = "MMT";
	/*public static void main(String[] args) {

		// String GET_URL ="http://prodpp.goibibobusiness.com/api/search/?source=CCU&destination=GAU&format=json&dateofdeparture=20200328&adults=1&counter=100 ";

		// String USER_AGENT = "Mozilla/5.0";

		try {

			FlightFilterModel filterModel = new FlightFilterModel();
			MmtQueryData mmtQueryData = new MmtQueryData();
			mmtQueryData.setSource("BOM");
			mmtQueryData.setDestination("CCU");
			mmtQueryData.setDateOfDeparture("20200929");
			mmtQueryData.setDateOfArrival("20201003");
			mmtQueryData.setAdults("1");
			filterModel.setQueryData(mmtQueryData);
			CustomFilterData  customFilterData = new CustomFilterData();
			customFilterData.setAirline("indigo");
			customFilterData.setStops(1);
			//  customFilterData.setDepartureTime("0600-1200");
			customFilterData.setArrivalTime("1200-1800");
			filterModel.setCustomFilters(customFilterData);
         	
			FlightResponseModel r = 	searchFlights("http://prodpp.goibibobusiness.com/api/search/?",filterModel);
			
System.out.println(new Gson().toJson(r));


		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("GET DONE");

	}*/

	public  FlightResponseModel searchFlights(String GET_URL,FlightFilterModel filterModel) throws Exception {
		
		GenericPostAndGet genericPostAndGet=new GenericPostAndGet();
	//	String respone=genericPostAndGet.genericGetMethod(GET_URL,filterModel);
		String response =  callHttpGET(GET_URL,filterModel);
	
		FlightResponseModel searchResults =  null;
		if(travelAgent.equals("MMT")) {
			
		MMTDataModel dataModel = MMTDataParser.ParseMMTFlightData(response);
		
		
		 searchResults =  new FlightResponseModel();
		searchResults.setOnwardflights(filterFlights(dataModel.getData().getOnwardflights(),filterModel));
		searchResults.setReturnflights(filterFlights(dataModel.getData().getReturnflights(),filterModel));
	
		}
		return searchResults;
		
	}


	public static String callHttpGET(String GET_URL,FlightFilterModel filterModel) throws Exception

	{


		StringBuffer response = new StringBuffer();
		try {

			
			URL obj = new URL(GET_URL+Constants.mmt_source_search+filterModel.getQueryData().getSource()+Constants.mmt_destination_search+filterModel.getQueryData().getDestination()+"&format="+"json"+Constants.mmt_dateofdeparture_search+filterModel.getQueryData().getDateOfDeparture()+Constants.mmt_dateofarrival_search+filterModel.getQueryData().getDateOfArrival()+Constants.mmt_adults_search+filterModel.getQueryData().getAdults()+Constants.mmt_counter_search+"100");
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
		
			if (responseCode == 200) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				//StringBuffer response = new StringBuffer();


				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);

				}
				in.close();
			}else {


				BufferedReader in1 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine1;

				while ((inputLine1 = in1.readLine()) != null) {
					response.append(inputLine1);
				}
				in1.close();
				// print result+
				System.out.println(response.toString());
				
				
			}
		}catch(Exception e)
		{
			
		}

		return response.toString();
	}

	public static MMTDataModel ParseMMTData(String data) {

		Gson g = new Gson();

		Type type = new TypeToken<MMTDataModel>() {}.getType();
		MMTDataModel mmtModel =  g.fromJson(data, type);
		return mmtModel;

	}

	public static CustomFlightModel createFlightReponseModel(FlightSearchModel flightModel) {

		CustomFlightModel flightResponseModel =null;

		flightResponseModel= new CustomFlightModel();

		flightResponseModel.setAirline(flightModel.getAirline());
		flightResponseModel.setFare(flightModel.getFare().getGrossamount());

		flightResponseModel.setFlightData(new Gson().toJson(flightModel));
		flightResponseModel.setDepTime(flightModel.getDeptime());

		flightResponseModel.setStops(flightModel.getOnwardflights().size());
		if(flightResponseModel.getStops() == 0) {
			flightResponseModel.setArrTime(flightModel.getArrtime());  
		}else{

			int lastStop = flightModel.getOnwardflights().size();
			flightResponseModel.setArrTime(flightModel.getOnwardflights().get(lastStop-1).getArrtime());
		}



		return flightResponseModel;
	}
	public static List<CustomFlightModel> filterFlights(List<FlightSearchModel> flightList,FlightFilterModel filterModel) {

		List<CustomFlightModel> filteredFlightList =  new ArrayList<CustomFlightModel>();
		FlightSearchModel flightObj = null;

		for(int i = 0;i< flightList.size();i++) {


			flightObj = flightList.get(i);
			//	  System.out.println("arr:"+arr);


			Gson g = new Gson();
			Type t = new TypeToken<FlightSearchModel>() {}.getType();



			CustomFlightModel responseModel =  MMTDataParser.createFlightReponseModel(flightObj);

			int onwardDepRangeStart = 0;
			int onwardDepRangeEnd = 2400;
			int onwardArrRangeStart = 0;
			int onwardArrRangeEnd = 2400;
			if(filterModel.getCustomFilters().getDepartureTime() != null && !filterModel.getCustomFilters().getDepartureTime().equals("")) {
				onwardDepRangeStart = Integer.parseInt(filterModel.getCustomFilters().getDepartureTime().split("-")[0]);
				onwardDepRangeEnd = Integer.parseInt(filterModel.getCustomFilters().getDepartureTime().split("-")[1]);
			}

			if(filterModel.getCustomFilters().getArrivalTime() != null && !filterModel.getCustomFilters().getArrivalTime().equals("")) {
				onwardArrRangeStart = Integer.parseInt(filterModel.getCustomFilters().getArrivalTime().split("-")[0]);
				onwardArrRangeEnd = Integer.parseInt(filterModel.getCustomFilters().getArrivalTime().split("-")[1]);
			}

			//				 if( responseModel.getAirline().equalsIgnoreCase(filterModel.getCustomFilters().getAirline()) &&
			//						 
			//					 responseModel.getStops() <= filterModel.getCustomFilters().getStops() 
			//				 

			//							 && Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) >= onwardDepRangeStart &&
			//					 
			//					 Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) <= onwardDepRangeEnd &&	 
			//                     
			//					 Integer.parseInt(responseModel.getArrTime().replaceAll(":", "")) >= onwardArrRangeStart &&
			//					 
			//					 Integer.parseInt(responseModel.getArrTime().replaceAll(":", "")) <= onwardArrRangeEnd	
			//						 ) 
			if( (responseModel.getAirline().equalsIgnoreCase(filterModel.getCustomFilters().getAirline()) || filterModel.getCustomFilters().getAirline().contentEquals(""))
					&& responseModel.getStops() <= filterModel.getCustomFilters().getStops() 
					&& Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) >= onwardDepRangeStart
					&& Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) <= onwardDepRangeEnd 

					)
			{


				filteredFlightList.add(responseModel);
				// System.out.println(new Gson().toJson(flightObj));
			}



		}
		
		return filteredFlightList;
	}
	public static void sendGET(String GET_URL,FlightFilterModel filterModel) throws Exception

	{
		StringBuffer response = new StringBuffer();
		try {

			String old_url = "http://prodpp.goibibobusiness.com/api/search/?source=BOM&format=json&dateofdeparture=20200929&adults=1&counter=100&destination=GAU";
			System.out.println("url:"+old_url+":end");

			URL obj = new URL(GET_URL+"source="+filterModel.getQueryData().getSource()+"&destination="+filterModel.getQueryData().getDestination()+"&format="+"json"+"&dateofdeparture="+filterModel.getQueryData().getDateOfDeparture()+"&dateofarrival="+filterModel.getQueryData().getDateOfArrival()+"&adults="+filterModel.getQueryData().getAdults()+"&counter="+"100");
			//	 URL obj = new URL(old_url);	
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
			if (responseCode == 200) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				//StringBuffer response = new StringBuffer();


				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);

				}
				in.close();

				// print result
				//System.out.println(response.toString());
				System.out.println(" Success =="+response);

				Gson g = new Gson();

				Type t1 = new TypeToken<MMTDataModel>() {}.getType();
				MMTDataModel res = g.fromJson(response.toString(), t1);
				System.out.println("sfdfsdf"+res.getData().getOnwardflights().get(0).getAirline());



				Type t = new TypeToken<FlightSearchModel>() {}.getType();
				Object o = g.fromJson(response.toString(), t);

				System.out.println(g.toJson(o));

				JsonParser p = new JsonParser();
				JsonElement jsonTree =  p.parse(response.toString());

				if(jsonTree.isJsonObject()) {
					JsonObject jsonO = jsonTree.getAsJsonObject();
					JsonElement e = jsonO.get("data");
					//	 System.out.println("e:"+e);

					jsonTree =  p.parse(e.toString());
					if(jsonTree.isJsonObject()) {
						System.out.println("true");
						String onward= "onwardflights";
						JsonObject jsonA = jsonTree.getAsJsonObject();
						JsonElement a = jsonA.get(onward);
						//		  System.out.println("a:"+a);



						jsonTree =  p.parse(a.toString());

						if(jsonTree.isJsonArray()) {
							JsonArray jsonArr = jsonTree.getAsJsonArray();


							FlightSearchModel flightObj = null;
							List<FlightSearchModel> flightList =  new ArrayList<FlightSearchModel>();


							for(int i = 0;i< jsonArr.size();i++) {


								JsonElement arr = jsonArr.get(i);
								//	  System.out.println("arr:"+arr);


								g = new Gson();
								t = new TypeToken<FlightSearchModel>() {}.getType();


								flightObj = g.fromJson(arr.toString(), t);
								flightObj.setFlightData(arr.toString());

								CustomFlightModel responseModel =  createFlightReponseModel(flightObj);

								int onwardDepRangeStart = 0;
								int onwardDepRangeEnd = 2400;
								int onwardArrRangeStart = 0;
								int onwardArrRangeEnd = 2400;
								if(filterModel.getCustomFilters().getDepartureTime() != null && !filterModel.getCustomFilters().getDepartureTime().equals("")) {
									onwardDepRangeStart = Integer.parseInt(filterModel.getCustomFilters().getDepartureTime().split("-")[0]);
									onwardDepRangeEnd = Integer.parseInt(filterModel.getCustomFilters().getDepartureTime().split("-")[1]);
								}

								if(!filterModel.getCustomFilters().getArrivalTime().equals("")) {
									onwardArrRangeStart = Integer.parseInt(filterModel.getCustomFilters().getArrivalTime().split("-")[0]);
									onwardArrRangeEnd = Integer.parseInt(filterModel.getCustomFilters().getArrivalTime().split("-")[1]);
								}

								//						 if( responseModel.getAirline().equalsIgnoreCase(filterModel.getCustomFilters().getAirline()) &&
								//								 
								//							 responseModel.getStops() <= filterModel.getCustomFilters().getStops() 
								//						 

								//									 && Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) >= onwardDepRangeStart &&
								//							 
								//							 Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) <= onwardDepRangeEnd &&	 
								//                             
								//							 Integer.parseInt(responseModel.getArrTime().replaceAll(":", "")) >= onwardArrRangeStart &&
								//							 
								//							 Integer.parseInt(responseModel.getArrTime().replaceAll(":", "")) <= onwardArrRangeEnd	
								//						 ) 
								if( responseModel.getAirline().equalsIgnoreCase(filterModel.getCustomFilters().getAirline()) 
										&& responseModel.getStops() <= filterModel.getCustomFilters().getStops() 
										&& Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) >= onwardDepRangeStart
										&& Integer.parseInt(responseModel.getDepTime().replaceAll(":", "")) <= onwardDepRangeEnd 

										)
								{


									flightList.add(flightObj);
									// System.out.println(new Gson().toJson(flightObj));
								}



							}

							System.out.println(flightList.size());
							// createFlightReponseModel(totalList);
							//					  if(jsonTree.isJsonObject()) {
							//						  
							//						  JsonObject jsonObj = jsonTree.getAsJsonObject();
							//						  JsonElement o1 = jsonObj.get("origin");
							//						  
							//					  }
							//						  FlightSearchModel o11 = new FlightSearchModel();
							//						  o11.setOrigin(o11.toString().replaceAll("\"", ""));
							//						  System.out.println("o1:"+o11.toString().replaceAll("\"", ""));

						}

					}

				}



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
		}catch(Exception e)
		{
			System.out.println("error"+e.toString());
		}
	}



}
