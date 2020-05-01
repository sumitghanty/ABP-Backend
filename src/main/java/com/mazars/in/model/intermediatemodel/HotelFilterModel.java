package com.mazars.in.model.intermediatemodel;

import com.mazars.in.model.intermediatemodel.mmt.MmtHotelQueryData;

public class HotelFilterModel {
	
	private MmtHotelQueryData queryData;
	private CustomHotelFilterData customFilters;
	public MmtHotelQueryData getQueryData() {
		return queryData;
	}
	public void setQueryData(MmtHotelQueryData queryData) {
		this.queryData = queryData;
	}
	public CustomHotelFilterData getCustomFilters() {
		return customFilters;
	}
	public void setCustomFilters(CustomHotelFilterData customFilters) {
		this.customFilters = customFilters;
	}
	
	

}
