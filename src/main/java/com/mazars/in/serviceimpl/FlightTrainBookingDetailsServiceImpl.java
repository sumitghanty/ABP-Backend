package com.mazars.in.serviceimpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mazars.in.common.Constants;
import com.mazars.in.controller.FlightTrainBookingController;
import com.mazars.in.dao.FlightTrainBookingDetailsDAO;
import com.mazars.in.model.intermediatemodel.CustomFlightModel;
import com.mazars.in.model.intermediatemodel.FlightFilterModel;
import com.mazars.in.model.intermediatemodel.FlightResponseModel;
import com.mazars.in.model.intermediatemodel.mmt.FlightSearchModel;
import com.mazars.in.model.intermediatemodel.mmt.MMTDataModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.service.FlightTrainBookingDetailsService;
import com.mazars.in.util.GenericPostAndGet;
import com.mazars.in.util.GetFlightSearch;
import com.mazars.in.util.MMTDataParser;



@Service
@Transactional
public class FlightTrainBookingDetailsServiceImpl implements FlightTrainBookingDetailsService {
	
	
	@Autowired
	private GenericPostAndGet genericPostAndGet;
	@Value("${URL_PROD}")
	private String url;
	@Value("${search}")
	private String search;
	@Value("${travelAgent}")
	private String travelAgent;
	private static final Logger logger = LogManager.getLogger(FlightTrainBookingController.class);
	FlightResponseModel r=null;
	String UrlParameter=null;
	MasterResponseModel response=null;
	@Override
	public MasterResponseModel flightSearch(FlightFilterModel filterModel) {
		logger.info("Inside FlightTrainBookingDetailsServiceImpl flightSearch method entry-->");
		try
		{
		GetFlightSearch getFlightSearch=new GetFlightSearch();
		 //r = getFlightSearch.searchFlights("http://prodpp.goibibobusiness.com/api/search/?",flightFilterModel);
		 
		String GET_URL=url+search;
		
		 String mmt_dateofarrival_search=filterModel.getQueryData().getDateOfArrival();
		if(mmt_dateofarrival_search!=null)
		{
			
		}
		else
			mmt_dateofarrival_search="";
		
		
		
		
		//UrlParameter=Constants.mmt_source_search+filterModel.getQueryData().getSource()+Constants.mmt_destination_search+filterModel.getQueryData().getDestination()+"&format="+"json"+Constants.mmt_dateofdeparture_search+filterModel.getQueryData().getDateOfDeparture()+Constants.mmt_dateofarrival_search+filterModel.getQueryData().getDateOfArrival()+Constants.mmt_adults_search+filterModel.getQueryData().getAdults()+Constants.mmt_counter_search+"100";
		
		UrlParameter=Constants.mmt_source_search+filterModel.getQueryData().getSource()+Constants.mmt_destination_search+filterModel.getQueryData().getDestination()+"&format="+"json"+Constants.mmt_dateofdeparture_search+filterModel.getQueryData().getDateOfDeparture()+Constants.mmt_dateofarrival_search+mmt_dateofarrival_search+Constants.mmt_adults_search+filterModel.getQueryData().getAdults()+Constants.mmt_counter_search+"100";
		
		 response=genericPostAndGet.genericGetMethod(GET_URL,UrlParameter);
		 
		 FlightResponseModel searchResults =  null;
			if(("MMT").equalsIgnoreCase(travelAgent)) {
				
			MMTDataModel dataModel = MMTDataParser.ParseMMTFlightData(response.getResponseMessage());
			
			
			 searchResults =  new FlightResponseModel();
			 
			 
			 
			searchResults.setOnwardflights(filterFlights(dataModel.getData().getOnwardflights(),filterModel));
			searchResults.setReturnflights(filterFlights(dataModel.getData().getReturnflights(),filterModel));
			
			
			response.setFlightResponse(searchResults);
		 
		 
		 
		 
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("Inside FlightTrainBookingDetailsServiceImpl flightSearch method exit-->");
		return response;
	}
	
	public static List<CustomFlightModel> filterFlights(List<FlightSearchModel> flightList,FlightFilterModel filterModel) {
		logger.info("Inside FlightTrainBookingDetailsServiceImpl filterFlights method entry-->");
		List<CustomFlightModel> filteredFlightList =  new ArrayList<CustomFlightModel>();
		FlightSearchModel flightObj = null;
			for(FlightSearchModel flightSearchModel:flightList)
			{
			flightObj = flightSearchModel;
			Gson g = new Gson();
			Type t = new TypeToken<FlightSearchModel>() {}.getType();CustomFlightModel responseModel =  MMTDataParser.createFlightReponseModel(flightObj);
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
		logger.info("Inside FlightTrainBookingDetailsServiceImpl filterFlights method exit-->");
		return filteredFlightList;
	}

}
