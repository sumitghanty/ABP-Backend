package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_travel_city_entitlement")
public class TravelCityEntitlement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="travel_city_entitlement_id")
	private int travelCityEntitlementId;
	@Column(name="city_category_id")
	private int cityCategoryId;
	@Column(name="amount")
	private double amount;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="entitlement_id")
	private Integer entitlementid;
	
	public Integer getEntitlementid() {
		return entitlementid;
	}
	public void setEntitlementid(Integer entitlementid) {
		this.entitlementid = entitlementid;
	}
	public int getTravelCityEntitlementId() {
		return travelCityEntitlementId;
	}
	public void setTravelCityEntitlementId(int travelCityEntitlementId) {
		this.travelCityEntitlementId = travelCityEntitlementId;
	}
	public int getCityCategoryId() {
		return cityCategoryId;
	}
	public void setCityCategoryId(int cityCategoryId) {
		this.cityCategoryId = cityCategoryId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
