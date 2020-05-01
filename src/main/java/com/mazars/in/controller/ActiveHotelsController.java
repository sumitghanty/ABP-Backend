package com.mazars.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.ActiveHotels;
import com.mazars.in.service.ActiveHotelsService;


@RestController
public class ActiveHotelsController {
	@Autowired
	private ActiveHotelsService activeHotelsService;
	/**
	  * 
	  * 
	  * This method is for create the ActiveHotels 
	  * @return 
	  */
	
	
	@RequestMapping(value = "/createActiveHotels", method = RequestMethod.POST)
	public String createActiveHotels(@RequestBody ActiveHotels activeHotels) {
		String toFrontEnd=activeHotelsService.save(activeHotels);
		return toFrontEnd ;

	}
	
	/**
	  * 
	  * 
	  * This method is for update the ActiveHotels
	  * @param activeHotels
	  * @return 
	  */

	@RequestMapping(value = "/updateActiveHotels", method = RequestMethod.POST)
	public String updateActiveHotels(@RequestBody ActiveHotels activeHotels) {
		String toFrontEnd=activeHotelsService.update(activeHotels);
		return toFrontEnd ;

	}



 /**
  * 
  * 
  * This method is for delete the 
  * ActiveHotels
  * @param activeHotels
  * @return
  */
	@RequestMapping(value = "/deleteActiveHotels", method = RequestMethod.POST)
	public String deleteActiveHotels(@RequestBody ActiveHotels activeHotels) {
		
		String toFrontEnd=activeHotelsService.delete(activeHotels);
		return toFrontEnd ;

	}
	/**
	  * 
	  * 
	  * This method is for getting the ActiveHotels
	  * @param advancePayment
	  * @return
	  */

	@RequestMapping(value = "/getActiveHotelsList", method = RequestMethod.GET)
	public List<ActiveHotels> getActiveHotelsList() {
		List <ActiveHotels> activeHotelsList=activeHotelsService.list();
        return activeHotelsList;
	}


}
