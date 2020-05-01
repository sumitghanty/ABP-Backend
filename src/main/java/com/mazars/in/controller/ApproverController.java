/*package com.mazars.in.main;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.common.Constants;
import com.mazars.in.service.TripApproveService;
import com.mazars.in.transactionmodel.MasterResponseModel;
import com.mazars.in.transactionmodel.TripCreation;
import com.mazars.in.util.DateCompareForSession;

@RestController
public class ApproverController {
	
	TripCreation tripReturnToFrontEnd=null;
	MasterResponseModel masterResponseModel=new MasterResponseModel();
	DateCompareForSession dateCompareForSession=new DateCompareForSession();
	ClassPathXmlApplicationContext context1=CommonController.con;
	String differenceInTime=null;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = "/approveTrip", method = RequestMethod.POST)
	public MasterResponseModel approveTrip(@RequestBody TripCreation trip,@RequestHeader("token") String token,@RequestHeader("emailId") String emailId) throws ParseException {
		System.out.println("context1"+context1);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		differenceInTime=dateCompareForSession.sessionExpiredOrNot(token,emailId);
        if(differenceInTime.equalsIgnoreCase(Constants.valid_Session))
        {
		TripApproveService tripApproveService = context.getBean(TripApproveService.class);
		tripReturnToFrontEnd=tripApproveService.approveTrip(trip);
		
		
		masterResponseModel.setTripcreation(tripReturnToFrontEnd);
		masterResponseModel.setResponseCode(Constants.trip_Successfully_Code);
		masterResponseModel.setResponseMessage(Constants.trip_Created_Successfully);
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
	
	
}
*/