package com.mazars.in.model.transactionmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EnableJpaAuditing
@OptimisticLocking(type = OptimisticLockType.NONE)
@Table(name="tbl_tripcreation")
public class TripCreation implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="trip_id")
	private int tripId;
	@Column(name="trip_number")
	private String tripNumber;	
	
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="employee_email")
	private String employeeEmail;
	@Column(name="company_id")
	private int companyId;
	@Column(name="start_date")
	private String startDate;
	@Column(name="end_date")
	private String endDate;
	@Column(name="purpose")
	private String purpose;
	@Column(name="from_location")
	private String fromLocation;
	@Column(name="to_location")
	private String toLocation;
	@Column(name="trip_for")
	private String tripFor;
	@Column(name="trip_description")
	private String tripDescription;
	@Column(name="age")
	private String age;
	@Column(name="trip_cost_center")
	private String tripCostCentre;
	@Column(name="master_cost_center")
	private String MasterCostCentre;
	@Column(name="event_code")
	private String eventCode;
	@Column(name="trip_type")
	private String tripType;
	@Column(name="status")
	private String status;
	@Column(name="sub_status")
	private String subStatus;
	@Column(name="pending_with_email")
	private String pendingWithEmail;
	@Column(name="pending_with_user")
	private String pendingWithUser;
	@Column(name="travel_type")
	private String travelType;
	@Column(name="final_submit_for_trip_approver")
	private Integer finalSubmitForTripApprover;
	@Column(name="approver_by_approver")
	private String approveByApprover;
	@Column(name="reject_by_approver")
	private String rejectByApprover;
	
	@Column(name="final_expense_submit")
	private Integer finalexpensesubmit;

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
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="trip_id")
	private Set<LineItemMaster> lineItemMaster;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="trip_id")
	private Set<TripUserMapping> tripUserMapping;
	
	/*@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="trip_id")
	private Set<TaskApprovalWorkflow> taskApprovalWorkflow;*/
	
	
	
	
	
	public Set<LineItemMaster> getLineItemMaster() {
		return lineItemMaster;
	}
	public void setLineItemMaster(Set<LineItemMaster> lineItemMaster) {
		this.lineItemMaster = lineItemMaster;
	}
	public Set<TripUserMapping> getTripUserMapping() {
		return tripUserMapping;
	}
	public void setTripUserMapping(Set<TripUserMapping> tripUserMapping) {
		this.tripUserMapping = tripUserMapping;
	}
	
	
	
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTripNumber() {
		return tripNumber;
	}
	public void setTripNumber(String tripNumber) {
		this.tripNumber = tripNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getTripFor() {
		return tripFor;
	}
	public void setTripFor(String tripFor) {
		this.tripFor = tripFor;
	}
	public String getTripDescription() {
		return tripDescription;
	}
	public void setTripDescription(String tripDescription) {
		this.tripDescription = tripDescription;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTripCostCentre() {
		return tripCostCentre;
	}
	public void setTripCostCentre(String tripCostCentre) {
		this.tripCostCentre = tripCostCentre;
	}
	public String getMasterCostCentre() {
		return MasterCostCentre;
	}
	public void setMasterCostCentre(String masterCostCentre) {
		MasterCostCentre = masterCostCentre;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubStatus() {
		return subStatus;
	}
	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}
	public String getPendingWithEmail() {
		return pendingWithEmail;
	}
	public void setPendingWithEmail(String pendingWithEmail) {
		this.pendingWithEmail = pendingWithEmail;
	}
	public String getPendingWithUser() {
		return pendingWithUser;
	}
	public void setPendingWithUser(String pendingWithUser) {
		this.pendingWithUser = pendingWithUser;
	}
	public String getTravelType() {
		return travelType;
	}
	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}
	
	
	public Integer getFinalSubmitForTripApprover() {
		return finalSubmitForTripApprover;
	}
	public void setFinalSubmitForTripApprover(Integer finalSubmitForTripApprover) {
		this.finalSubmitForTripApprover = finalSubmitForTripApprover;
	}
	public String getApproveByApprover() {
		return approveByApprover;
	}
	public void setApproveByApprover(String approveByApprover) {
		this.approveByApprover = approveByApprover;
	}
	public String getRejectByApprover() {
		return rejectByApprover;
	}
	public void setRejectByApprover(String rejectByApprover) {
		this.rejectByApprover = rejectByApprover;
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
	
	
	public Integer getFinalexpensesubmit() {
		return finalexpensesubmit;
	}
	public void setFinalexpensesubmit(Integer finalexpensesubmit) {
		this.finalexpensesubmit = finalexpensesubmit;
	}
	
}
