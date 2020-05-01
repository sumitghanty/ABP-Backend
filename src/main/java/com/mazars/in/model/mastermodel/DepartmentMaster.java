package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_department_master")
public class DepartmentMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="department_master_id")
	private int departmentMasterID;
	@Column(name ="department_code")
	private String departmentCode;
	@Column(name ="department_name")
	private String departmentName;
	@Column(name ="department_description")
	private String departmentDescription;
	@Column(name ="created_by")
	private String createdBy;
	@Column(name ="created_date")
	private Date createdDate;
	@Column(name ="updated_by")
	private String updatedBy;
	@Column(name ="updated_date")
	private Date updatedDate;
	@Column(name ="is_Active")
	private boolean isActive;
	public int getDepartmentMasterID() {
		return departmentMasterID;
	}
	public void setDepartmentMasterID(int departmentMasterID) {
		this.departmentMasterID = departmentMasterID;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
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
