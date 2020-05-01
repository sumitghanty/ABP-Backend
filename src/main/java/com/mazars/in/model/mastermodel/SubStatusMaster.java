/*
 * 
 * @author samit tiwary
 * date 12032020
 * The table will be used to maintain the Travel Type Master
 * 
 * 
 */

package  com.mazars.in.model.mastermodel;

import java.util.Date;

public class SubStatusMaster {
	private int instanceId;
	private int companyId;
	private int subStatusId;
	private String subStatusText;
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
	
	public int getSubStatusId() {
		return subStatusId;
	}
	public void setSubStatusId(int subStatusId) {
		this.subStatusId = subStatusId;
	}
	public String getSubStatusText() {
		return subStatusText;
	}
	public void setSubStatusText(String subStatusText) {
		this.subStatusText = subStatusText;
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
