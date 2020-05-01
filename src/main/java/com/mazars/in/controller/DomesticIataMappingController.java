package com.mazars.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mazars.in.model.mastermodel.DomesticIataMapping;
import com.mazars.in.service.DomesticIataMappingService;


@RestController
public class DomesticIataMappingController {
@Autowired
private DomesticIataMappingService domesticIataMappingService;
	/**
	  * 
	  * 
	  * This method is for create the DomesticIataMapping
	  * @return 
	  */
	
	
	@RequestMapping(value = "/createDomesticIataMapping", method = RequestMethod.POST)
	public String createDomesticIataMapping(@RequestBody DomesticIataMapping domesticIataMapping) {
		String toFrontEnd=domesticIataMappingService.save(domesticIataMapping);
		return toFrontEnd ;

	}
	
	/**
	  * 
	  * 
	  * This method is for update the DomesticIataMapping
	  * @param domesticIataMapping
	  * @return 
	  */

	@RequestMapping(value = "/updateDomesticIataMapping", method = RequestMethod.POST)
	public String updateDomesticIataMapping(@RequestBody DomesticIataMapping domesticIataMapping) {
		String toFrontEnd=domesticIataMappingService.update(domesticIataMapping);
		return toFrontEnd ;

	}



 /**
  * 
  * 
  * This method is for delete the 
  * DomesticIataMapping
  * @param domesticIataMapping
  * @return
  */
	@RequestMapping(value = "/deleteDomesticIataMapping", method = RequestMethod.POST)
	public String deleteDomesticIataMapping(@RequestBody DomesticIataMapping domesticIataMapping) {
		String toFrontEnd=domesticIataMappingService.delete(domesticIataMapping);
		return toFrontEnd ;

	}
	/**
	  * 
	  * 
	  * This method is for getting the DomesticIataMapping
	  * @param domesticIataMapping
	  * @return
	  */

	@RequestMapping(value = "/getDomesticIataMappingList", method = RequestMethod.GET)
	public List<DomesticIataMapping> getDomesticIataMappingList() {
		List <DomesticIataMapping> domesticIataMappingList=domesticIataMappingService.list();
        return domesticIataMappingList;
	}


}
