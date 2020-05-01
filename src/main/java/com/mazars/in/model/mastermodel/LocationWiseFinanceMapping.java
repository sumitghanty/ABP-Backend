package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_locationwise_finance_mapping")
public class LocationWiseFinanceMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationwisefinancemapping_id")
	private int locationwisefinancemappingId;
	@Column(name="organization_id")
	private int organizationId;
	@Column(name="vertical_id")
	private int verticalId;
	@Column(name="location_id")
	private int locationId;
	@Column(name="function_id")
	private int functionId;
	@Column(name="locationwisefinancemaster_id")
	private int locationwisefinancemasterid;
	public int getLocationwisefinancemappingId() {
		return locationwisefinancemappingId;
	}
	public void setLocationwisefinancemappingId(int locationwisefinancemappingId) {
		this.locationwisefinancemappingId = locationwisefinancemappingId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getVerticalId() {
		return verticalId;
	}
	public void setVerticalId(int verticalId) {
		this.verticalId = verticalId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public int getLocationwisefinanceId() {
		return locationwisefinancemasterid;
	}
	public void setLocationwisefinanceId(int locationwisefinanceId) {
		this.locationwisefinancemasterid = locationwisefinanceId;
	}

}
