package com.mazars.in.model.transactionmodel;

import java.util.List;

import com.mazars.in.model.intermediatemodel.CustomHotelModel;
import com.mazars.in.model.intermediatemodel.FlightResponseModel;
import com.mazars.in.model.intermediatemodel.HotelResponseModel;
import com.mazars.in.model.mastermodel.AccomodationType;
import com.mazars.in.model.mastermodel.ActiveHotels;
import com.mazars.in.model.mastermodel.CostCenterMaster;
import com.mazars.in.model.mastermodel.DomesticIataMapping;
import com.mazars.in.model.mastermodel.EventMaster;
import com.mazars.in.model.mastermodel.LocationMaster;
import com.mazars.in.model.mastermodel.PurposeMaster;
import com.mazars.in.model.mastermodel.Retainer;
import com.mazars.in.model.mastermodel.RoleToTilemapping;
import com.mazars.in.model.mastermodel.TravelTypeMaster;
import com.mazars.in.model.mastermodel.TripForMaster;
import com.mazars.in.model.mastermodel.User;
import com.mazars.in.model.mmt.hotelmodel.CityMaster;

public class MasterResponseModel {
	private int responseCode;
	private String responseMessage;
	private List<LocationMaster> locationList;
	private List<PurposeMaster> purposeMaster;
	private List<CostCenterMaster> costCenter;
	private List<EventMaster> eventMaster;
	private List<FlightResponseModel> flightResponseModel;
	private List<CustomHotelModel> customHotelModel;
	private List<HotelResponseModel> hotelResponseModel;
	private HotelResponseModel hotelResponse;
	private List<RoleToTilemapping> roleToTilemapping;
	private FlightResponseModel flightResponse;
	private List<TravelTypeMaster> travelTypeMaster;
	private List<TripForMaster> tripForMaster;
	private List<Retainer> retainerMaster;
	private List<CityMaster> cityMaster;
	private List<User> userList;
	private List<ActiveHotels> activeHotels;
	private List<DomesticIataMapping> domesticIataMapping;
	private List<AccomodationType> accomodationTypeList;
	
	private TripCreation tripcreation;
	private List<TripCreation> tripCreationList;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public List<LocationMaster> getLocationList() {
		return locationList;
	}
	public void setLocationList(List<LocationMaster> locationList) {
		this.locationList = locationList;
	}
	public List<PurposeMaster> getPurposeMaster() {
		return purposeMaster;
	}
	public void setPurposeMaster(List<PurposeMaster> purposeMaster) {
		this.purposeMaster = purposeMaster;
	}
	public List<CostCenterMaster> getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(List<CostCenterMaster> costCenter) {
		this.costCenter = costCenter;
	}
	public List<EventMaster> getEventMaster() {
		return eventMaster;
	}
	public void setEventMaster(List<EventMaster> eventMaster) {
		this.eventMaster = eventMaster;
	}
	public List<FlightResponseModel> getFlightResponseModel() {
		return flightResponseModel;
	}
	public void setFlightResponseModel(List<FlightResponseModel> flightResponseModel) {
		this.flightResponseModel = flightResponseModel;
	}
	public List<CustomHotelModel> getCustomHotelModel() {
		return customHotelModel;
	}
	public void setCustomHotelModel(List<CustomHotelModel> customHotelModel) {
		this.customHotelModel = customHotelModel;
	}
	public List<HotelResponseModel> getHotelResponseModel() {
		return hotelResponseModel;
	}
	public void setHotelResponseModel(List<HotelResponseModel> hotelResponseModel) {
		this.hotelResponseModel = hotelResponseModel;
	}
	public HotelResponseModel getHotelResponse() {
		return hotelResponse;
	}
	public void setHotelResponse(HotelResponseModel hotelResponse) {
		this.hotelResponse = hotelResponse;
	}
	public List<RoleToTilemapping> getRoleToTilemapping() {
		return roleToTilemapping;
	}
	public void setRoleToTilemapping(List<RoleToTilemapping> roleToTilemapping) {
		this.roleToTilemapping = roleToTilemapping;
	}
	public FlightResponseModel getFlightResponse() {
		return flightResponse;
	}
	public void setFlightResponse(FlightResponseModel flightResponse) {
		this.flightResponse = flightResponse;
	}
	public List<TravelTypeMaster> getTravelTypeMaster() {
		return travelTypeMaster;
	}
	public void setTravelTypeMaster(List<TravelTypeMaster> travelTypeMaster) {
		this.travelTypeMaster = travelTypeMaster;
	}
	public List<TripForMaster> getTripForMaster() {
		return tripForMaster;
	}
	public void setTripForMaster(List<TripForMaster> tripForMaster) {
		this.tripForMaster = tripForMaster;
	}
	public List<Retainer> getRetainerMaster() {
		return retainerMaster;
	}
	public void setRetainerMaster(List<Retainer> retainerMaster) {
		this.retainerMaster = retainerMaster;
	}
	public List<CityMaster> getCityMaster() {
		return cityMaster;
	}
	public void setCityMaster(List<CityMaster> cityMaster) {
		this.cityMaster = cityMaster;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public List<ActiveHotels> getActiveHotels() {
		return activeHotels;
	}
	public void setActiveHotels(List<ActiveHotels> activeHotels) {
		this.activeHotels = activeHotels;
	}
	public List<DomesticIataMapping> getDomesticIataMapping() {
		return domesticIataMapping;
	}
	public void setDomesticIataMapping(List<DomesticIataMapping> domesticIataMapping) {
		this.domesticIataMapping = domesticIataMapping;
	}
	public List<AccomodationType> getAccomodationTypeList() {
		return accomodationTypeList;
	}
	public void setAccomodationTypeList(List<AccomodationType> accomodationTypeList) {
		this.accomodationTypeList = accomodationTypeList;
	}
	public TripCreation getTripcreation() {
		return tripcreation;
	}
	public void setTripcreation(TripCreation tripcreation) {
		this.tripcreation = tripcreation;
	}
	public List<TripCreation> getTripCreationList() {
		return tripCreationList;
	}
	public void setTripCreationList(List<TripCreation> tripCreationList) {
		this.tripCreationList = tripCreationList;
	}
	
	
	
	//here ita code and hotel list  ...trip createtrip
	
	
}
