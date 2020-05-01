package com.mazars.in.model.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_budget_master_mapping")
public class BudgetMasterMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="budget_mapping_id")
	private int budgetmappingId;
	@Column(name="costcenter_id")
	private int costcenterId;
	@Column(name="budget_id")
	private int budgetId;
	public int getBudgetmappingId() {
		return budgetmappingId;
	}
	public void setBudgetmappingId(int budgetmappingId) {
		this.budgetmappingId = budgetmappingId;
	}
	public int getCostcenterId() {
		return costcenterId;
	}
	public void setCostcenterId(int costcenterId) {
		this.costcenterId = costcenterId;
	}
	public int getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(int budgetId) {
		this.budgetId = budgetId;
	}

}
