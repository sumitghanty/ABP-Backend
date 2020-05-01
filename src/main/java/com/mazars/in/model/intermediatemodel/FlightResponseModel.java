package com.mazars.in.model.intermediatemodel;

import java.util.List;



public class FlightResponseModel {
	
	private List<CustomFlightModel> onwardflights;
	private List<CustomFlightModel> returnflights;
	public List<CustomFlightModel> getReturnflights() {
		return returnflights;
	}
	public List<CustomFlightModel> getOnwardflights() {
		return onwardflights;
	}
	public void setOnwardflights(List<CustomFlightModel> onwardflights) {
		this.onwardflights = onwardflights;
	}
	public void setReturnflights(List<CustomFlightModel> returnflights) {
		this.returnflights = returnflights;
	}

}
