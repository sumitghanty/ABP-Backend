package com.mazars.in.model.mastermodel;

import java.util.Date;
import java.util.List;

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
@Entity
@Table(name="tbl_travel_entitlement")
public class TravelEntitlement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="entitlement_id")
    private int entitlementID;
	@Column(name="organization_id")
    private int organizationID;
	@Column(name="vertical_id")
    private int verticalID;
	@Column(name="category_id")
    private int categoryID;
	@Column(name="usergroup_id")
    private int usergroupID;
	@Column(name="is_flight_allowed")
	private boolean isFlightAllowed;
	@Column(name="is_trainallowed")
	private boolean isTrainAllowed;
	@Column(name="is_carpoolallowed")
	private boolean isCarPoolAllowed;
	@Column(name="flight_Class")
	private String flightClass;
	@Column(name="entitled_flightamount")
	private double entitledFlightAmount;
	@Column(name="train_class")
	private String trainClass;
	@Column(name="entitled_trainamount")
	private double entitledTrainAmount;
	@Column(name="localconvenyance_amount")
	private double localConvenyanceAmount;
	@Column(name="selfaccomodation_amount")
	private double selfAccomodationAmount;
	@Column(name="night_tripamount")
	private double nightTripAmount;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="from_date")
	private Date fromDate;	
	@Column(name="to_date")
	private Date toDate;
	@Column(name="is_active")
	private boolean isActive;	
	@Column(name="tripsubmission_duedate")
	private int tripSubmissionDueDate;
	@Column(name="advance_settlementAmount_percentage")
	private String advanceSettlementAmountPercentage;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="entitlement_id")
	private List<TravelCityEntitlement> cityentitlement;
	
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
	public int getUsergroupID() {
		return usergroupID;
	}
	public void setUsergroupID(int usergroupID) {
		this.usergroupID = usergroupID;
	}
	public List<TravelCityEntitlement> getCityentitlement() {
		return cityentitlement;
	}
	public void setCityentitlement(List<TravelCityEntitlement> cityentitlement) {
		this.cityentitlement = cityentitlement;
	}
	public int getEntitlementID() {
		return entitlementID;
	}
	public void setEntitlementID(int entitlementID) {
		this.entitlementID = entitlementID;
	}
	public boolean isFlightAllowed() {
		return isFlightAllowed;
	}
	public void setFlightAllowed(boolean isFlightAllowed) {
		this.isFlightAllowed = isFlightAllowed;
	}
	public boolean isTrainAllowed() {
		return isTrainAllowed;
	}
	public void setTrainAllowed(boolean isTrainAllowed) {
		this.isTrainAllowed = isTrainAllowed;
	}
	public boolean isCarPoolAllowed() {
		return isCarPoolAllowed;
	}
	public void setCarPoolAllowed(boolean isCarPoolAllowed) {
		this.isCarPoolAllowed = isCarPoolAllowed;
	}
	public String getFlightClass() {
		return flightClass;
	}
	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
	public double getEntitledFlightAmount() {
		return entitledFlightAmount;
	}
	public void setEntitledFlightAmount(double entitledFlightAmount) {
		this.entitledFlightAmount = entitledFlightAmount;
	}
	public String getTrainClass() {
		return trainClass;
	}
	public void setTrainClass(String trainClass) {
		this.trainClass = trainClass;
	}
	public double getEntitledTrainAmount() {
		return entitledTrainAmount;
	}
	public void setEntitledTrainAmount(double entitledTrainAmount) {
		this.entitledTrainAmount = entitledTrainAmount;
	}
	public double getLocalConvenyanceAmount() {
		return localConvenyanceAmount;
	}
	public void setLocalConvenyanceAmount(double localConvenyanceAmount) {
		this.localConvenyanceAmount = localConvenyanceAmount;
	}
	public double getSelfAccomodationAmount() {
		return selfAccomodationAmount;
	}
	public void setSelfAccomodationAmount(double selfAccomodationAmount) {
		this.selfAccomodationAmount = selfAccomodationAmount;
	}
	public double getNightTripAmount() {
		return nightTripAmount;
	}
	public void setNightTripAmount(double nightTripAmount) {
		this.nightTripAmount = nightTripAmount;
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
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getTripSubmissionDueDate() {
		return tripSubmissionDueDate;
	}
	public void setTripSubmissionDueDate(int tripSubmissionDueDate) {
		this.tripSubmissionDueDate = tripSubmissionDueDate;
	}
	public String getAdvanceSettlementAmountPercentage() {
		return advanceSettlementAmountPercentage;
	}
	public void setAdvanceSettlementAmountPercentage(String advanceSettlementAmountPercentage) {
		this.advanceSettlementAmountPercentage = advanceSettlementAmountPercentage;
	}

}
