package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_locationwise_carpool_mapping")
public class LocationWiseCarpoolMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationwisecarpoolmapping_id")
	private int locationwisecarpoolmappingId;
	@Column(name="organization_id")
	private int organizationId;
	@Column(name="vertical_id")
	private int verticalId;
	@Column(name="location_id")
	private int locationId;
	@Column(name="function_id")
	private int functionId;
	@Column(name="locationwisecarpoolmaster_id")
	private int locationwisecarpoolmasterid;
	public int getLocationwisecarpoolmappingId() {
		return locationwisecarpoolmappingId;
	}
	public void setLocationwisecarpoolmappingId(int locationwisecarpoolmappingId) {
		this.locationwisecarpoolmappingId = locationwisecarpoolmappingId;
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
	public int getLocationwisecarpoolmasterid() {
		return locationwisecarpoolmasterid;
	}
	public void setLocationwisecarpoolmasterid(int locationwisecarpoolmasterid) {
		this.locationwisecarpoolmasterid = locationwisecarpoolmasterid;
	}
}
