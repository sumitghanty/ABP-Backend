package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_accomodation_type")
public class AccomodationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="accomodation_type_id")
	private int accomodationTypeId;
	@Column(name="company_id")
	private int companyId;
	@Column(name="accomodation_type_description")
	private String accomodationTypeDescription;
	
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	public int getAccomodationTypeId() {
		return accomodationTypeId;
	}
	public void setAccomodationTypeId(int accomodationTypeId) {
		this.accomodationTypeId = accomodationTypeId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getAccomodationTypeDescription() {
		return accomodationTypeDescription;
	}
	public void setAccomodationTypeDescription(String accomodationTypeDescription) {
		this.accomodationTypeDescription = accomodationTypeDescription;
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
