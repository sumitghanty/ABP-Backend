/*
 * 
 * This is controller class for trip
 */

package com.mazars.in.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.common.Constants;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.model.transactionmodel.TripCreation;
import com.mazars.in.service.TripCreationService;
import com.mazars.in.service.UserService;


@RestController
public class TripController {	
	@Autowired
	private TripCreationService tripCreationService;
	
	@Autowired
	private DateCompareForSession dateCompareForSession;
	
	
	
	@Autowired
	private UserService userService;
	private static final Logger logger = LogManager.getLogger(TripController.class);
	/**
	  * This method is for create the trip
	  * @param trip
	  * @return 
	 * @throws ParseException 
	  */
	TripCreation tripReturnToFrontEnd=null;
	MasterResponseModel masterResponseModel=new MasterResponseModel();
	//DateCompareForSession dateCompareForSession=new DateCompareForSession();
	String differenceInTime=null;
	//static LoginService loginService;
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/createTrip", method = RequestMethod.POST)
	public MasterResponseModel createTrip(@RequestBody TripCreation trip,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		String createdByName="";
		logger.info("Inside Trip Creation controller createTrip method entry-->");
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
        	Date date = new Date();
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
    		String strDate = formatter.format(date); 
    		Date date1=formatter.parse(strDate);
        	trip.setCreatedDate(date1);
        	
        	//code to get user details based on email id in the trip
        	User user=userService.loginVerification(emailId);
        	if(user!=null)
        	{
        	createdByName=user.getUserFirstName()+""+user.getUserMiddleName()+""+user.getUserLastName();
        	}
        	
        trip.setCreatedBy(createdByName);
		tripReturnToFrontEnd=tripCreationService.save(trip);
		masterResponseModel.setTripcreation(tripReturnToFrontEnd);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Created_Successfully);
		logger.info("Inside Trip Creation controller createTrip method exit-->");
		return masterResponseModel;
		}
		else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
			logger.info("Inside Trip Creation controller createTrip method exit-->");
			return masterResponseModel;
		}
        else
        { 
        	masterResponseModel.setResponseCode(Constants.session_Expired_Code);
        	masterResponseModel.setResponseMessage(Constants.session_Expired);
        	masterResponseModel.setTripCreationList(null);
        	masterResponseModel.setTripcreation(null);
        	logger.info("Inside Trip Creation controller createTrip method exit-->");
        	return masterResponseModel;	
        }
        
		}
	/**
	  * This method is for update the trip
	  * @param trip
	  * @return 
	 * @throws ParseException 
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/updateTrip", method = RequestMethod.POST)
	public MasterResponseModel updateTrip(@RequestBody TripCreation trip,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		logger.info("Inside Trip Creation controller updateTrip method entry-->");
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
        	if(trip.getApproveByApprover()!=null)
        	{
        		if(trip.getApproveByApprover().equalsIgnoreCase("approve"))
        		{
        		trip.setApproveByApprover(trip.getApproveByApprover());
        		 trip.setPendingWithEmail("");
        		}
        	}
        	
        	if(trip.getFinalSubmitForTripApprover()!=null)
        	{
        		if(trip.getFinalSubmitForTripApprover()==1)
        		{
        trip.setPendingWithEmail(trip.getPendingWithEmail());
        	}}
		TripCreation tripReturnToFrontEnd=tripCreationService.update(trip);
		masterResponseModel.setTripcreation(tripReturnToFrontEnd);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Updated_Successfully);
		logger.info("Inside Trip Creation controller updateTrip method exit-->");
		return masterResponseModel;
		}
        else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
			logger.info("Inside Trip Creation controller updateTrip method exit-->");
			return masterResponseModel;
		}
		else
		{
			masterResponseModel.setResponseCode(Constants.session_Expired_Code);
        	masterResponseModel.setResponseMessage(Constants.session_Expired);
        	masterResponseModel.setTripCreationList(null);
        	masterResponseModel.setTripcreation(null);
        	logger.info("Inside Trip Creation controller updateTrip method exit-->");
        	return masterResponseModel;
		}

	}



 /**
  * 
  * 
  * This method is for delete the trip
  * @param trip
  * @return
 * @throws ParseException 
  */
	@RequestMapping(value = "/deleteTrip", method = RequestMethod.POST)
	public MasterResponseModel deleteTrip(@RequestBody TripCreation trip,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
		String toFrontEnd=tripCreationService.delete(trip);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Deleted_Successfully);
		return masterResponseModel ;
        }
        else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
		return masterResponseModel;
		}
		else
		{
			masterResponseModel.setResponseCode(Constants.session_Expired_Code);
        	masterResponseModel.setResponseMessage(Constants.session_Expired);
        	masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
        	return masterResponseModel;
		}
        

	}
	/**
	  * 
	  * 
	  * This method is for getting the trip
	  * @param trip
	  * @return
	 * @throws ParseException 
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getTripList", method = RequestMethod.GET)
	public MasterResponseModel getTripList(@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
		List <TripCreation> tripCreationList=tripCreationService.list();
		masterResponseModel.setTripCreationList(tripCreationList);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Fetched_Successfully);
        return masterResponseModel;
	}
        
        
        else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
		return masterResponseModel;
		}
		else
		{
			masterResponseModel.setResponseCode(Constants.session_Expired_Code);
        	masterResponseModel.setResponseMessage(Constants.session_Expired);
        	masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
        	return masterResponseModel;
		}
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getTripListByEmailId", method = RequestMethod.GET)
	public MasterResponseModel getTripListByEmailId(@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
		List <TripCreation> tripCreationList=tripCreationService.tripListByEmailId(emailId);
		if(tripCreationList.size()>0)
		{
		masterResponseModel.setTripCreationList(tripCreationList);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_List_Data);
        return masterResponseModel;
		}
		else
		{
		masterResponseModel.setResponseMessage(Constants.trip_List_Data_Not_Present);
		masterResponseModel.setResponseCode(Constants.data_Not_Present_Code);
		return masterResponseModel;
		}
	}
	else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
	{
		masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
		masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
		masterResponseModel.setTripCreationList(null);
		masterResponseModel.setTripcreation(null);
	return masterResponseModel;
	}
	else
	{
		masterResponseModel.setResponseCode(Constants.session_Expired_Code);
    	masterResponseModel.setResponseMessage(Constants.session_Expired);
    	masterResponseModel.setTripCreationList(null);
		masterResponseModel.setTripcreation(null);
    	return masterResponseModel;
	}

}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/getTripDetailsByTripNumberForApprover", method = RequestMethod.POST)
	public MasterResponseModel getTripDetailsByTripNumberForApprover(@RequestHeader("token") String token,@RequestHeader("emailId") String emailId,@RequestBody TripCreation tripCreation) throws ParseException {
		
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
        	
        String tripNumber=tripCreation.getTripNumber();
		TripCreation tripDetails=tripCreationService.getTripDetailsByTripNumber(tripNumber);
		masterResponseModel.setTripcreation(tripDetails);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Fetched_Successfully);
        return masterResponseModel;
	}
        
        
        else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
		return masterResponseModel;
		}
		else
		{
			masterResponseModel.setResponseCode(Constants.session_Expired_Code);
        	masterResponseModel.setResponseMessage(Constants.session_Expired);
        	masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
        	return masterResponseModel;
		}
	}

	
	/**
	  * This method is for update expense
	  * @param trip
	  * @return 
	 * @throws ParseException 
	  */
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/updateExpense", method = RequestMethod.POST)
	public MasterResponseModel updateExpense(@RequestBody TripCreation trip,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		logger.info("Inside Trip Creation controller updateTrip method entry-->");
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
       if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
       {
       	if(trip.getApproveByApprover()!=null)
       	{
       		if(trip.getApproveByApprover().equalsIgnoreCase("approve"))
       		{
       		trip.setApproveByApprover(trip.getApproveByApprover());
       		 trip.setPendingWithEmail("");
       		}
       	}
       	
       	if(trip.getFinalSubmitForTripApprover()!=null)
       	{
       		if(trip.getFinalexpensesubmit()==1)
       		{
       trip.setPendingWithEmail(trip.getPendingWithEmail());
       	}}
		TripCreation tripReturnToFrontEnd=tripCreationService.update(trip);
		masterResponseModel.setTripcreation(tripReturnToFrontEnd);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Updated_Successfully);
		logger.info("Inside Trip Creation controller updateTrip method exit-->");
		return masterResponseModel;
		}
       else if(differenceInTime.equalsIgnoreCase(Constants.loginId_Or_Token_DoesNot_Matched))
		{
			masterResponseModel.setResponseCode(Constants.loginId_Or_Token_DoesNot_Matched_code);
			masterResponseModel.setResponseMessage(Constants.loginId_Or_Token_DoesNot_Matched);
			masterResponseModel.setTripCreationList(null);
			masterResponseModel.setTripcreation(null);
			logger.info("Inside Trip Creation controller updateTrip method exit-->");
			return masterResponseModel;
		}
		else
		{
			masterResponseModel.setResponseCode(Constants.session_Expired_Code);
       	masterResponseModel.setResponseMessage(Constants.session_Expired);
       	masterResponseModel.setTripCreationList(null);
       	masterResponseModel.setTripcreation(null);
       	logger.info("Inside Trip Creation controller updateTrip method exit-->");
       	return masterResponseModel;
		}

	}




}