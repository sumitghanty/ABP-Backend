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
@Table(name="tbl_budget_master")
public class BudgetMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="budget_id")
	private int budgetId;
	@Column(name="financial_year")
	private String financialyear;
	@Column(name="budget_amount")
	private String budget_amount;
	@Column(name="Budget_allowed_to_see")
	private String budget_allowed_to_see;
	@Column(name="user_email_id")
	private String user_email_id;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="budget_id")
	private BudgetMasterMapping budgetmastermapping;
	public BudgetMasterMapping getBudgetmastermapping() {
		return budgetmastermapping;
	}
	public void setBudgetmastermapping(BudgetMasterMapping budgetmastermapping) {
		this.budgetmastermapping = budgetmastermapping;
	}
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}
	public String getFinancialyear() {
		return financialyear;
	}
	public void setFinancialyear(String financialyear) {
		this.financialyear = financialyear;
	}
	public String getBudget_amount() {
		return budget_amount;
	}
	public void setBudget_amount(String budget_amount) {
		this.budget_amount = budget_amount;
	}
	public String getBudget_allowed_to_see() {
		return budget_allowed_to_see;
	}
	public void setBudget_allowed_to_see(String budget_allowed_to_see) {
		this.budget_allowed_to_see = budget_allowed_to_see;
	}
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
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
