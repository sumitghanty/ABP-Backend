package  com.mazars.in.model.mastermodel;

import java.util.Date;

public class Secretary {

	private int instanceId;
	private int companyId;
	private int organizationId;
	private int secretaryUserId;
	private int bossUserId;
	private int secretaryBossUserId;
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
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public int getSecretaryUserId() {
		return secretaryUserId;
	}
	public void setSecretaryUserId(int secretaryUserId) {
		this.secretaryUserId = secretaryUserId;
	}
	public int getBossUserId() {
		return bossUserId;
	}
	public void setBossUserId(int bossUserId) {
		this.bossUserId = bossUserId;
	}
	public int getSecretaryBossUserId() {
		return secretaryBossUserId;
	}
	public void setSecretaryBossUserId(int secretaryBossUserId) {
		this.secretaryBossUserId = secretaryBossUserId;
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



