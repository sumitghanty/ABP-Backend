package com.mazars.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mazars.in.model.mastermodel.RoleMaster;
import com.mazars.in.model.transactionmodel.LoginResponseModel;
import com.mazars.in.model.transactionmodel.MasterResponseModel;
import com.mazars.in.service.ActiveHotelsService;
import com.mazars.in.service.DomesticIataMappingService;
import com.mazars.in.service.MasterListService;
import com.mazars.in.service.PurposeMasterService;
import com.mazars.in.service.RoleMasterService;
import com.mazars.in.service.UserService;

@Component
public  class CommonController {
@Autowired	
private RoleMasterService roleMasterService;
@Autowired
private UserService userService;
@Autowired
private MasterListService masterListService;
@Autowired
private ActiveHotelsService activeHotelsService;

@Autowired
private PurposeMasterService purposeMaster;

@Autowired
private DomesticIataMappingService domesticIataMappingService;

/*@PostConstruct
public void setCommonController()
{
  getMasterDataFromDB();
}*/



	public static List<RoleMaster> roleMaster;
	
	public static MasterResponseModel masterResponseModelData;
	
	MasterResponseModel masterResponseModel=new MasterResponseModel();
	
	@RequestMapping(value = "/getMasterDataFromDB", method = RequestMethod.GET)
	public LoginResponseModel getMasterDataFromDB()
	{
	LoginResponseModel res= new LoginResponseModel();
		roleMaster =roleMasterService.roleMasterList();
		//commented date 16042020
		//roleMasterService.getTilesForUser(null);
	//	RoleMasterService roleMasterService=context.getBean(RoleMasterService.class);
		//roleMaster =CommonController.roleMaster;
		masterResponseModel.setUserList(userService.list());
		masterResponseModel.setPurposeMaster(purposeMaster.purposeMasterList());
		masterResponseModel.setRetainerMaster(masterListService.getRetainerMaster());
		masterResponseModel.setTravelTypeMaster(masterListService.getTravelTypeMaster());
		masterResponseModel.setTripForMaster(masterListService.getTripForMaster());
		masterResponseModel.setCityMaster(masterListService.getCityMaster());
		masterResponseModel.setAccomodationTypeList(masterListService.getAccomodationType());
		masterResponseModel.setActiveHotels(activeHotelsService.list());
		masterResponseModel.setDomesticIataMapping(domesticIataMappingService.list());
		masterResponseModelData=masterResponseModel;
		res.setMasterResponseModel(masterResponseModel);
		return res;
	

}}
