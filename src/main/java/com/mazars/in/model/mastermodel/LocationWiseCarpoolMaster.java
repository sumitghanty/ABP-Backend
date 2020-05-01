package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_locationwise_carpool_master")
public class LocationWiseCarpoolMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationwisecarpoolmaster_id")
	private int locationwisecarpoolmasterId;
	@Column(name="user1")
	private String User1;
	@Column(name="user2")
	private String User2;	
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="locationwisecarpoolmaster_id")
	private LocationWiseCarpoolMapping carpoolmapping;
	public int getLocationwisecarpoolmasterId() {
		return locationwisecarpoolmasterId;
	}
	public void setLocationwisecarpoolmasterId(int locationwisecarpoolmasterId) {
		this.locationwisecarpoolmasterId = locationwisecarpoolmasterId;
	}
	public String getUser1() {
		return User1;
	}
	public void setUser1(String user1) {
		User1 = user1;
	}
	public String getUser2() {
		return User2;
	}
	public void setUser2(String user2) {
		User2 = user2;
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
	public LocationWiseCarpoolMapping getCarpoolmapping() {
		return carpoolmapping;
	}
	public void setCarpoolmapping(LocationWiseCarpoolMapping carpoolmapping) {
		this.carpoolmapping = carpoolmapping;
	}
}
