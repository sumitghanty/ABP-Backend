package com.mazars.in.controller;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.common.Constants;
import com.mazars.in.model.intermediatemodel.FlightFilterModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.service.FlightTrainBookingDetailsService;
@RestController
public class FlightTrainBookingController {

	
	MasterResponseModel masterResponseModel=new MasterResponseModel();
	@Autowired
	private DateCompareForSession dateCompareForSession;
	String differenceInTime=null;
	
	@Autowired
	private FlightTrainBookingDetailsService flightTrainBookingDetailsService;
	
	private static final Logger logger = LogManager.getLogger(FlightTrainBookingController.class);
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/flightSearchService", method = RequestMethod.POST)
	public MasterResponseModel flightSearchService(@RequestBody FlightFilterModel flightFilterModel,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException
	{
		
		logger.info("Inside FlightTrainBookingController flightSearchService method entry-->");
		
		//String get=url+search;
	differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
    if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
    {
	masterResponseModel=flightTrainBookingDetailsService.flightSearch(flightFilterModel);
	masterResponseModel.setResponseMessage(Constants.success_Message);
	logger.info("Inside FlightTrainBookingController flightSearchService method exit-->");
	return masterResponseModel;
		// r=getFlightSearch.searchFlights("http://prodpp.goibibobusiness.com/api/search/?",flightFilterModel);
		//book,reprice,confirm
		//System.out.println(new Gson().toJson(r));
		
   }
    else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
	{
		masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
		masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
		logger.info("Inside FlightTrainBookingController flightSearchService method exit-->");
		return masterResponseModel;
	}
    else
    { 
    	masterResponseModel.setResponseCode(Constants.session_Expired_Code);
    	masterResponseModel.setResponseMessage(Constants.session_Expired);
    	logger.info("Inside FlightTrainBookingController flightSearchService method exit-->");
    	return masterResponseModel;
    }
   
		

	}

}
