package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_retainer_mapping")
public class RetainerMapping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="retainermapping_id")
	private int retainerMappingID;
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
	/*@Column(name="department_id")
	private int departmentID;
	@Column(name="sub_department_id")
	private int sub_departmentID;*/
	@Column(name="retainer_id")
	private Integer retainerId;
	public int getRetainerMappingID() {
		return retainerMappingID;
	}
	public void setRetainerMappingID(int retainerMappingID) {
		this.retainerMappingID = retainerMappingID;
	}
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
	public Integer getRetainerId() {
		return retainerId;
	}
	public void setRetainerId(Integer retainerId) {
		this.retainerId = retainerId;
	}
}
