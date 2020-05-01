package com.mazars.in.model.intermediatemodel.mmt;

import java.util.List;

public class RootObject {
	
	private List<FlightSearchModel> onwardflights;
	private List<FlightSearchModel> returnflights;
	public List<FlightSearchModel> getOnwardflights() {
		return onwardflights;
	}
	public void setOnwardflights(List<FlightSearchModel> onwardflights) {
		this.onwardflights = onwardflights;
	}
	public List<FlightSearchModel> getReturnflights() {
		return returnflights;
	}
	public void setReturnflights(List<FlightSearchModel> returnflights) {
		this.returnflights = returnflights;
	}
	

}
