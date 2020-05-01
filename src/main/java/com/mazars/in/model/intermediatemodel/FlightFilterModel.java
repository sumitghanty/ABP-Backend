package com.mazars.in.model.intermediatemodel;

import com.mazars.in.model.intermediatemodel.mmt.MmtQueryData;

public class FlightFilterModel {
	
	private MmtQueryData queryData;
	private CustomFilterData customFilters;
	public MmtQueryData getQueryData() {
		return queryData;
	}
	public void setQueryData(MmtQueryData queryData) {
		this.queryData = queryData;
	}
	public CustomFilterData getCustomFilters() {
		return customFilters;
	}
	public void setCustomFilters(CustomFilterData customFilters) {
		this.customFilters = customFilters;
	}
	

}
