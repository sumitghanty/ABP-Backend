/*
 * 
 * author samit tiwary
 * Carpool Admin Master
 */
package  com.mazars.in.model.mastermodel;

import java.util.Date;

public class CarPoolAdminMaster {

	private int instanceId;
	public int getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getOrgGroupd() {
		return orgGroupd;
	}
	public void setOrgGroupd(int orgGroupd) {
		this.orgGroupd = orgGroupd;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getCarpoolAdminUserId() {
		return carpoolAdminUserId;
	}
	public void setCarpoolAdminUserId(int carpoolAdminUserId) {
		this.carpoolAdminUserId = carpoolAdminUserId;
	}
	public int getCarPoolAdminId() {
		return carPoolAdminId;
	}
	public void setCarPoolAdminId(int carPoolAdminId) {
		this.carPoolAdminId = carPoolAdminId;
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
	private int companyId;
	private int organizationId;
	private int orgGroupd;
	private int locationId;
	private int carpoolAdminUserId;
	private int carPoolAdminId;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private boolean isActive;

	
	
}
