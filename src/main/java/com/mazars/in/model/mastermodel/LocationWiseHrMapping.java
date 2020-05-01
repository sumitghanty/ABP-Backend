package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_locationwise_hr_mapping")
public class LocationWiseHrMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationwisehrmapping_id")
	private int locationwisehrmappingId;
	@Column(name="organization_id")
	private int organizationId;
	@Column(name="vertical_id")
	private int verticalId;
	@Column(name="location_id")
	private int locationId;
	@Column(name="function_id")
	private int functionId;
	@Column(name="locationwisehrmaster_id")
	private int locationwisehrmasterid;
	public int getLocationwisehrmappingId() {
		return locationwisehrmappingId;
	}
	public void setLocationwisehrmappingId(int locationwisehrmappingId) {
		this.locationwisehrmappingId = locationwisehrmappingId;
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
	public int getLocationwisehrmasterid() {
		return locationwisehrmasterid;
	}
	public void setLocationwisehrmasterid(int locationwisehrmasterid) {
		this.locationwisehrmasterid = locationwisehrmasterid;
	}
}
