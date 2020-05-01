package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_sub_department_master")
public class SubDepartmentMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="sub_department_master_id")
	private int subdepartmentMasterID;
	@Column(name ="sub_department_code")
	private String subdepartmentCode;
	@Column(name ="sub_department_name")
	private String subdepartmentName;
	@Column(name ="sub_department_description")
	private String subdepartmentDescription;
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
	public int getSubdepartmentMasterID() {
		return subdepartmentMasterID;
	}
	public void setSubdepartmentMasterID(int subdepartmentMasterID) {
		this.subdepartmentMasterID = subdepartmentMasterID;
	}
	public String getSubdepartmentCode() {
		return subdepartmentCode;
	}
	public void setSubdepartmentCode(String subdepartmentCode) {
		this.subdepartmentCode = subdepartmentCode;
	}
	public String getSubdepartmentName() {
		return subdepartmentName;
	}
	public void setSubdepartmentName(String subdepartmentName) {
		this.subdepartmentName = subdepartmentName;
	}
	public String getSubdepartmentDescription() {
		return subdepartmentDescription;
	}
	public void setSubdepartmentDescription(String subdepartmentDescription) {
		this.subdepartmentDescription = subdepartmentDescription;
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
