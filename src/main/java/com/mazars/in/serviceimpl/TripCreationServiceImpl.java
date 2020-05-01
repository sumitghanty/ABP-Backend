package com.mazars.in.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.mazars.in.dao.TripCreationDAO;
import com.mazars.in.dao.TripNumberDataDAO;
import com.mazars.in.model.transactionmodel.TripCreation;
import com.mazars.in.model.transactionmodel.TripNumberData;
import com.mazars.in.service.TripCreationService;
@Service
@Transactional
public class TripCreationServiceImpl  implements TripCreationService{
	private static final Logger logger = LogManager.getLogger(TripCreationServiceImpl.class);
	public final static String NON_SALES_TRIP_NUMBER_RANGE="01";
	public final static String SALES_TRIP_NUMBER_RANGE="02";
	public final static String SALES_TYPE="P";
	public final static String NON_SALES_TYPE="T";
	public final static String SEPERATOR="/";
	public final static long NS_START=1000000000;
	public final static long S_START=2000000000;
	
	@Autowired
	private TripCreationDAO tripCreationDAO;
	
	@Autowired 
	private TripNumberDataDAO tripNumberDataDAO;
	
	
	
	public TripCreation save(TripCreation trip) {
		logger.info("Inside TripCreationServiceImpl save method entry-->");
		logger.info("infor"+new Gson().toJson(trip));
		//TripCreationDAO tripMasterDAO = context.getBean(TripCreationDAO.class);
        

		/*for(int i =0;i<trip.getFlightOrTrainBooking().size();i++) {
			trip.getFlightOrTrainBooking().get(i).setTripCreation(trip);;

			for(int j =0;j<trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().size();j++) {
				trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().get(j).setFlightTrainBooking(trip.getFlightOrTrainBooking().get(i));
			}
		}*/
		
		String tripNumber=trip.getTripNumber();
		tripNumber=getTripNumber("Sales");
		trip.setTripNumber(tripNumber);
		TripCreation tripReturn=tripCreationDAO.save(trip);
		logger.info("Inside TripCreationServiceImpl save method exit-->");
		return tripReturn;

	}

public String getTripNumber(String type) {
	logger.info("Inside TripCreationServiceImpl getTripNumber method entry-->");
		Date date= new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");		
		String sTripNumber = "";
		String year = "";// GET THE cURRENT YEAR
		TripNumberData oTripNumberData = new TripNumberData();
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int year1 = now.get(Calendar.YEAR);       // The current year
		year=String.valueOf(year1);
		oTripNumberData.setYear(year);
		if(type.equals("TRIP")) // For Type TRIP
		{			
			oTripNumberData.setType(NON_SALES_TYPE);
			oTripNumberData.setNumber(String.valueOf(NS_START));
			
		}else { // For Type SALES
			oTripNumberData.setType(SALES_TYPE);
			oTripNumberData.setNumber(String.valueOf(S_START));
		}
		List<TripNumberData> oTripNumberDataList=tripNumberDataDAO.getLatestTripNumberDataInDb(oTripNumberData.getType(),oTripNumberData.getYear());
		//List<TripNumberData> oTripNumberDataList=tripNumberDataDAO.getLatestTripNumberDataInDb(oTripNumberData);
		TripNumberData returnTripNumberData=new TripNumberData();
		if(!CollectionUtils.isEmpty(oTripNumberDataList))
		{
			returnTripNumberData = oTripNumberDataList.get(0);
			if(type.equals("TRIP")) // For Type TRIP
			{			
				returnTripNumberData.setType(NON_SALES_TYPE);
				
			}else { // For Type SALES
				returnTripNumberData.setType(SALES_TYPE);
			}
		    getTripNumberExistingData(returnTripNumberData,year);
		}
		else
		{
			getTripNumberForNewData(oTripNumberData);
			returnTripNumberData=oTripNumberData;
			
		}
		tripNumberDataDAO.save(returnTripNumberData);
		System.out.println("Trip Number Generated --> "+sTripNumber);
		sTripNumber=returnTripNumberData.getsTripNumber();
		logger.info("Inside TripCreationServiceImpl getTripNumber method exit-->");
		return sTripNumber;		
		
	}
     private void getTripNumberExistingData(TripNumberData returnTripNumberData,String year) 
     
     {
    	 //returnTripNumberData.setId( returnTripNumberData.getId()+1);
    	 returnTripNumberData.setNumber(Long.toString(Long.valueOf(returnTripNumberData.getNumber())+1));
    	 returnTripNumberData.setYear(year);
    	 returnTripNumberData.setType(returnTripNumberData.getType());
    	 String sTripNumber="";
    	 sTripNumber = returnTripNumberData.getType()+SEPERATOR+returnTripNumberData.getYear()+SEPERATOR+returnTripNumberData.getNumber();
    	 returnTripNumberData.setsTripNumber(sTripNumber);
    }

	private void getTripNumberForNewData(TripNumberData oTripNumberData) 
	
	{
		//oTripNumberData.setId( oTripNumberData.getId());
		 oTripNumberData.setNumber(oTripNumberData.getNumber());
    	 String sTripNumber="";
    	 sTripNumber = oTripNumberData.getType()+SEPERATOR+oTripNumberData.getYear()+SEPERATOR+oTripNumberData.getNumber();
    	 oTripNumberData.setsTripNumber(sTripNumber);
	
    }


	@Override
	public TripCreation update(TripCreation trip) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TripCreationDAO tripMasterDAO = context.getBean(TripCreationDAO.class);*/


		/*for(int i =0;i<trip.getFlightOrTrainBooking().size();i++) {
			trip.getFlightOrTrainBooking().get(i).setTripCreation(trip);;

			for(int j =0;j<trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().size();j++) {
				trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().get(j).setFlightTrainBooking(trip.getFlightOrTrainBooking().get(i));
			}
		}*/
		logger.info("Inside TripCreationServiceImpl update method entry-->");
		TripCreation tripCreation=tripCreationDAO.save(trip);
		logger.info("Inside TripCreationServiceImpl update method exit-->");
		return tripCreation ;

	}

	@Override
	public List<TripCreation> list() {
		

		List<TripCreation> list = tripCreationDAO.findAll();

		return list;
	}

	@Override
	public String delete(TripCreation trip) {
		/*
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		TripCreationDAO tripMasterDAO = context.getBean(TripCreationDAO.class);*/

/*
		for(int i =0;i<trip.getFlightOrTrainBooking().size();i++) {
			trip.getFlightOrTrainBooking().get(i).setTripCreation(trip);;

			for(int j =0;j<trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().size();j++) {
				trip.getFlightOrTrainBooking().get(i).getFlightUserMapping().get(j).setFlightTrainBooking(trip.getFlightOrTrainBooking().get(i));
			}
		}*/
		tripCreationDAO.delete(trip);	
		return "200";
		// TODO Auto-generated method stub

	}
	@Override
	public List<TripCreation> tripListByEmailId(String emailId) {
		List<TripCreation> list = tripCreationDAO.tripListByEmailId(emailId);
		
		return list;
	}

	@Override
	public TripCreation getTripDetailsByTripNumber(String tripNumber) {
		
		return tripCreationDAO.getTripDetailsByTripNumber(tripNumber);
	}
	
	/*public String getById(int id)
	
	{
		tripCreationDAO.find(id);
		return null;
	}*/

}
