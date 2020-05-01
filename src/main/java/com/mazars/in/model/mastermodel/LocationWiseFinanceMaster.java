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
@Table(name="tbl_locationwise_finance_master")
public class LocationWiseFinanceMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="locationwisefinancemaster_id")
	private int locationwisefinancemasterId;
	@Column(name="user")
	private String approverUser1;
	/*@Column(name="approver_user2")
	private String approverUser2;*/	
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="locationwisefinancemaster_id")
	private LocationWiseFinanceMapping financemapping;
	
	public int getLocationwisefinancemasterId() {
		return locationwisefinancemasterId;
	}
	public void setLocationwisefinancemasterId(int locationwisefinancemasterId) {
		this.locationwisefinancemasterId = locationwisefinancemasterId;
	}
	public LocationWiseFinanceMapping getFinancemapping() {
		return financemapping;
	}
	public void setFinancemapping(LocationWiseFinanceMapping financemapping) {
		this.financemapping = financemapping;
	}
	public int getLocationwisemasterId() {
		return locationwisefinancemasterId;
	}
	public void setLocationwisemasterId(int locationwisemasterId) {
		this.locationwisefinancemasterId = locationwisemasterId;
	}
	public String getApproverUser1() {
		return approverUser1;
	}
	public void setApproverUser1(String approverUser1) {
		this.approverUser1 = approverUser1;
	}
	/*public String getApproverUser2() {
		return approverUser2;
	}
	public void setApproverUser2(String approverUser2) {
		this.approverUser2 = approverUser2;
	}*/
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
