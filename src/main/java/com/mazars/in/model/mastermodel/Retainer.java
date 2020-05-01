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
@Table(name="tbl_retainer")
public class Retainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="retainer_id")
	private int retainerId;	
	/*@Column(name="user_location_id")
	private int userLocationID;
	@Column(name="user_costcenter_id")
	private int userCostcenterID;*/
	@Column(name="retainer_employeecode")
	private int retaineremployeecode;
	@Column(name="user_title")
	private String userTitle;
	@Column(name="user_first_name")
	private String userFirstName;
	@Column(name="user_middle_name")
	private String userMiddleName;
	@Column(name="user_last_name")
	private String userLastName;
	@Column(name="user_email_id")
	private String userEmailId;
	@Column(name="user_address")
	private String userAddress;
	@Column(name="user_pin")
	private String userPin;
	@Column(name="user_phone_number")
	private String userPhoneNumber;
	@Column(name="user_dob")
	private Date userDOB;
	@Column(name="gender")
	private String gender;	
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
	public int getRetaineremployeecode() {
		return retaineremployeecode;
	}
	public void setRetaineremployeecode(int retaineremployeecode) {
		this.retaineremployeecode = retaineremployeecode;
	}
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="retainer_id")
	private RetainerMapping retainermapping;
	
	public RetainerMapping getRetainermapping() {
		return retainermapping;
	}
	public void setRetainermapping(RetainerMapping retainermapping) {
		this.retainermapping = retainermapping;
	}
	public int getRetainerId() {
		return retainerId;
	}
	public void setRetainerId(int retainerId) {
		this.retainerId = retainerId;
	}
	/*public int getUserLocationID() {
		return userLocationID;
	}
	public void setUserLocationID(int userLocationID) {
		this.userLocationID = userLocationID;
	}
	public int getUserCostcenterID() {
		return userCostcenterID;
	}
	public void setUserCostcenterID(int userCostcenterID) {
		this.userCostcenterID = userCostcenterID;
	}*/
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPin() {
		return userPin;
	}
	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public Date getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
