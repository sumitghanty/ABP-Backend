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
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	/*@Column(name="user_location_id")
	private int userLocationID;
	@Column(name="user_costcenter_id")
	private int userCostcenterID;
	@Column(name="user_goup_id")
	private int userGoupId;*/
	@Column(name="employee_code")
	private int employeeCode;
	
	/*@Column(name="user_id")
	private int userid;*/
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
	@Column(name="user_is_allowed_forte")
	private boolean userIsAllowedForTE;
	@Column(name="user_dob")
	private Date userDOB;
	@Column(name="gender")
	private String gender;
	/*@Column(name="department")
	private String department;
	@Column(name="sub_department")
	private String sub_department;*/
	@Column(name="approver1")
	private String approver1;
	@Column(name="approver2")
	private String approver2;
	@Column(name="approver3")
	private String approver3;
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
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UserMapping usermapping;
	
	public UserMapping getUsermapping() {
		return usermapping;
	}
	public void setUsermapping(UserMapping usermapping) {
		this.usermapping = usermapping;
	}
	/*public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSub_department() {
		return sub_department;
	}
	public void setSub_department(String sub_department) {
		this.sub_department = sub_department;
	}*/
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="is_approver_required")
	private boolean isApprovalRequired;
	
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
	}
	public int getUserGoupId() {
		return userGoupId;
	}
	public void setUserGoupId(int userGoupId) {
		this.userGoupId = userGoupId;
	}*/
	public int getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
	}
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
	public boolean isUserIsAllowedForTE() {
		return userIsAllowedForTE;
	}
	public void setUserIsAllowedForTE(boolean userIsAllowedForTE) {
		this.userIsAllowedForTE = userIsAllowedForTE;
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
	public String getApprover1() {
		return approver1;
	}
	public void setApprover1(String approver1) {
		this.approver1 = approver1;
	}
	public String getApprover2() {
		return approver2;
	}
	public void setApprover2(String approver2) {
		this.approver2 = approver2;
	}
	public String getApprover3() {
		return approver3;
	}
	public void setApprover3(String approver3) {
		this.approver3 = approver3;
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
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isApprovalRequired() {
		return isApprovalRequired;
	}
	public void setIsApprovalRequired(boolean isApprovalRequired) {
		this.isApprovalRequired = isApprovalRequired;
	}
	

}
