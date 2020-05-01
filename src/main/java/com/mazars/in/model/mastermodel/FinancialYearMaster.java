package com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_financial_year_master")
public class FinancialYearMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="financial_year_id")
	private int financialYearId;
	@Column(name="financial_year_label")
	private String financialYearLabel;
	@Column(name="financial_year_start_date")
	private Date financialYearStartDate;
	@Column(name="financial_year_end_date")
	private Date financialYearEndDate;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_Active")
	private boolean isActive;
	/*@Column(name="organization_id")
	private int organizationId;*/
	public int getFinancialYearId() {
		return financialYearId;
	}
	public void setFinancialYearId(int financialYearId) {
		this.financialYearId = financialYearId;
	}
	public String getFinancialYearLabel() {
		return financialYearLabel;
	}
	public void setFinancialYearLabel(String financialYearLabel) {
		this.financialYearLabel = financialYearLabel;
	}
	public Date getFinancialYearStartDate() {
		return financialYearStartDate;
	}
	public void setFinancialYearStartDate(Date financialYearStartDate) {
		this.financialYearStartDate = financialYearStartDate;
	}
	public Date getFinancialYearEndDate() {
		return financialYearEndDate;
	}
	public void setFinancialYearEndDate(Date financialYearEndDate) {
		this.financialYearEndDate = financialYearEndDate;
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
	/*public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}*/
	
	
}
