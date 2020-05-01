package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tbl_user_mapping")
public class UserMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usermapping_id")
	private int userMappingID;
	/*@Column(name="user_id")
	private Integer userID;*/
	@Column(name="organization_id")
	private int organizationID;
	@Column(name="vertical_id")
	private int verticalID;
	@Column(name="category_id")
	private int categoryID;
	@Column(name="user_goup_id")
	private int userGoupId;
	@Column(name="user_location_id")
	private int userLocationID;
	@Column(name="user_costcenter_id")
	private int userCostcenterID;
	@Column(name="department_id")
	private int departmentID;
	@Column(name="sub_department_id")
	private int sub_departmentID;
	@Column(name="user_id")
	private Integer userId;
	

/*	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;*/
	@Transient
	private String orgamizationName;
	@Transient
	private String verticalName;
	@Transient
	private String categoryName;
	@Transient
	private String userGroupName;
	@Transient
	private String locationName;
	@Transient
	private String costcenterName;
	@Transient
	private String departmentName;
	@Transient
	private String subdepartmentName;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getSub_departmentID() {
		return sub_departmentID;
	}
	public void setSub_departmentID(int sub_departmentID) {
		this.sub_departmentID = sub_departmentID;
	}
	public String getSubdepartmentName() {
		return subdepartmentName;
	}
	public void setSubdepartmentName(String subdepartmentName) {
		this.subdepartmentName = subdepartmentName;
	}
	public int getUserMappingID() {
		return userMappingID;
	}
	public void setUserMappingID(int userMappingID) {
		this.userMappingID = userMappingID;
	}
	/*public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}*/
	public int getOrganizationID() {
		return organizationID;
	}
	public void setOrganizationID(int organizationID) {
		this.organizationID = organizationID;
	}
	public int getVerticalID() {
		return verticalID;
	}
	public void setVerticalID(int verticalID) {
		this.verticalID = verticalID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getUserGoupId() {
		return userGoupId;
	}
	public void setUserGoupId(int userGoupId) {
		this.userGoupId = userGoupId;
	}
	public int getUserLocationID() {
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
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getOrgamizationName() {
		return orgamizationName;
	}
	public void setOrgamizationName(String orgamizationName) {
		this.orgamizationName = orgamizationName;
	}
	public String getVerticalName() {
		return verticalName;
	}
	public void setVerticalName(String verticalName) {
		this.verticalName = verticalName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getUserGroupName() {
		return userGroupName;
	}
	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getCostcenterName() {
		return costcenterName;
	}
	public void setCostcenterName(String costcenterName) {
		this.costcenterName = costcenterName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	

}
