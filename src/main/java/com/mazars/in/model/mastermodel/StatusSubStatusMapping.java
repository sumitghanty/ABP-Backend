/*
 * 
 * author samit tiwary
 * 
 * All the Status and Sub Status Mapping
 */

package  com.mazars.in.model.mastermodel;

import java.util.Date;

public class StatusSubStatusMapping {

	private int instanceId;
	private int companyId;
	private int statusId;
	private int substatusId;
	private int statusSubStatusMapping;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private boolean isActive;
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
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getSubstatusId() {
		return substatusId;
	}
	public void setSubstatusId(int substatusId) {
		this.substatusId = substatusId;
	}
	public int getStatusSubStatusMapping() {
		return statusSubStatusMapping;
	}
	public void setStatusSubStatusMapping(int statusSubStatusMapping) {
		this.statusSubStatusMapping = statusSubStatusMapping;
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
