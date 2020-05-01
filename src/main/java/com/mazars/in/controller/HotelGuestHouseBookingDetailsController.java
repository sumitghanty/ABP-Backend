package com.mazars.in.controller;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.common.Constants;
import com.mazars.in.model.intermediatemodel.HotelFilterModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.service.HotelGuestHouseBookingDetailsService;

@RestController
public class HotelGuestHouseBookingDetailsController {
	private static final Logger logger = LogManager.getLogger(HotelGuestHouseBookingDetailsController.class);
	MasterResponseModel masterResponseModel=new MasterResponseModel();
	@Autowired
	private DateCompareForSession dateCompareForSession;
	String differenceInTime=null;
	
	@Autowired
	private HotelGuestHouseBookingDetailsService hotelGuestHouseBookingDetailsService;
	//@Autowired
	private Environment env;
	@Value("${URL_WWWHotels}")
	String url;
	
	@Value("${HotelByCity}")
	String search;
	@RequestMapping(value = "/hotelSearchService", method = RequestMethod.POST)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public MasterResponseModel hotelSearchService(@RequestBody HotelFilterModel hotelFilterModel,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException
	{
		logger.info("Inside HotelGuestHouseBookingDetailsController hotelSearchService method entry-->");
		
		String get=url+search;
		
	differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
    if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
    {
	

	masterResponseModel=hotelGuestHouseBookingDetailsService.hotelSearch(hotelFilterModel,url,search);
	masterResponseModel.setResponseMessage(Constants.success_Message);
	logger.info("Inside HotelGuestHouseBookingDetailsController hotelSearchService method exit-->");	
	return masterResponseModel;

	}
    else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
	{
		masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
		masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
		logger.info("Inside HotelGuestHouseBookingDetailsController hotelSearchService method exit-->");
		return masterResponseModel;
	}
    else
    { 
    	masterResponseModel.setResponseCode(Constants.session_Expired_Code);
    	masterResponseModel.setResponseMessage(Constants.session_Expired);
    	logger.info("Inside HotelGuestHouseBookingDetailsController hotelSearchService method exit-->");
    	return masterResponseModel;
    }
	
	
}
}