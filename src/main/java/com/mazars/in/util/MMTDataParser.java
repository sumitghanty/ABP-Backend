package com.mazars.in.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.mazars.in.model.intermediatemodel.CustomFlightModel;
import com.mazars.in.model.intermediatemodel.CustomHotelModel;
import com.mazars.in.model.intermediatemodel.mmt.FlightSearchModel;
import com.mazars.in.model.intermediatemodel.mmt.HotelSearchModel;
import com.mazars.in.model.intermediatemodel.mmt.MMTDataModel;

public class MMTDataParser {
	private static Gson gson = new Gson();
	
	public static MMTDataModel ParseMMTFlightData(String data) {

		Gson g = new Gson();

		Type type = new TypeToken<MMTDataModel>() {}.getType();
		MMTDataModel mmtModel =  g.fromJson(data, type);
		return mmtModel;

	}
	
	public static List<HotelSearchModel> ParseMMTHotelData(String data) {

		 JsonParser parser = new JsonParser();
			
		 JsonElement jsonTree =  parser.parse(data);
		 JsonObject jsonO = jsonTree.getAsJsonObject();
		 JsonElement root = jsonO.get("data");
		 
		 if(root == null) {
			  root = jsonO.get("errors");
			  if(root != null) {
				  return new ArrayList<HotelSearchModel>();
			  }
		 }
			 
			 
		             jsonTree =  parser.parse(root.toString());
			 	    jsonO = jsonTree.getAsJsonObject();
		           JsonElement city_hotel_info = jsonO.get("city_hotel_info");
				  
				  jsonTree =  parser.parse(city_hotel_info.toString());
					 
				  
				  JsonArray hotelArr = jsonTree.getAsJsonArray();
				  
				  List<HotelSearchModel> hotelList =  new ArrayList<HotelSearchModel>();
				//  HotelSearchModel hotelObj = null;
				  Gson gson = new Gson();
				  Type type = new TypeToken<List<HotelSearchModel>>() {}.getType();
			//	  for(int i = 0;i< hotelArr.size();i++) {
				  
				
				  hotelList = gson.fromJson(hotelArr.toString(), type);
		return hotelList;

	}
	
	public static CustomHotelModel createHotelReponseModel(HotelSearchModel hotelModel) {
		CustomHotelModel customHotelModel = new CustomHotelModel();
		customHotelModel.setPrice(hotelModel.getPrc());
		customHotelModel.setAmenities(hotelModel.getFm());
		customHotelModel.setGuestRating(hotelModel.getGr());
		customHotelModel.setName(hotelModel.getHn());
		customHotelModel.setImageUrl(hotelModel.getTmob());
		customHotelModel.setStarRating(hotelModel.getHr());
		customHotelModel.setType(hotelModel.getHt());
		customHotelModel.setHotelData(gson.toJson(hotelModel));
		
		return customHotelModel;
	}

	public static CustomFlightModel createFlightReponseModel(FlightSearchModel flightModel) {

		CustomFlightModel flightResponseModel =null;

		flightResponseModel= new CustomFlightModel();

		flightResponseModel.setAirline(flightModel.getAirline());
		flightResponseModel.setFare(flightModel.getFare().getGrossamount());
		flightResponseModel.setFlightNo(flightModel.getFlightno());

		flightResponseModel.setFlightData(gson.toJson(flightModel));
		flightResponseModel.setDepTime(flightModel.getDeptime());
		flightResponseModel.setArrTime(flightModel.getArrtime());
		flightResponseModel.setOrigin(flightModel.getOrigin());
		flightResponseModel.setDestination(flightModel.getDestination());
		flightResponseModel.setStops(flightModel.getOnwardflights().size());
		if(flightResponseModel.getStops() == 0) {
			flightResponseModel.setFinalArrivalTime(flightModel.getArrtime());  
		}else{

			int lastStop = flightModel.getOnwardflights().size();
			flightResponseModel.setFinalArrivalTime(flightModel.getOnwardflights().get(lastStop-1).getArrtime());
		}


		CustomFlightModel flightOnwardsModel =null;
		List<CustomFlightModel> onwardFlights = new ArrayList<CustomFlightModel>();
	
		
		for(int i = 0;i< flightModel.getOnwardflights().size();i++) {
			 flightOnwardsModel = new CustomFlightModel();

			flightOnwardsModel.setFlightData(flightModel.getOnwardflights().get(i).getFlightData());
			flightOnwardsModel.setOrigin(flightModel.getOnwardflights().get(i).getOrigin());
			flightOnwardsModel.setDestination(flightModel.getOnwardflights().get(i).getDestination());
			flightOnwardsModel.setFlightNo(flightModel.getOnwardflights().get(i).getFlightno());
			flightOnwardsModel.setDepTime(flightModel.getOnwardflights().get(i).getDeptime());
			flightOnwardsModel.setArrTime(flightModel.getOnwardflights().get(i).getArrtime());
			onwardFlights.add(flightOnwardsModel);
			flightResponseModel.setOnwardflights(onwardFlights);
			

		}
		return flightResponseModel;
	}

}
