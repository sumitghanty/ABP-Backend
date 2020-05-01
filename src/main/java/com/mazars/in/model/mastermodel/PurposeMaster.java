package  com.mazars.in.model.mastermodel;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_purpose_master")
public class PurposeMaster {

	
	@Column(name ="company_id")
	private int companyId;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="purpose_id")
	private int purposeId;
	@Column(name ="purpose_description")
	private String purposeDescription;
	@Column(name ="created_by")
	private String createdBy;
	@Column(name ="created_date")
	private Date createdDate;
	@Column(name ="updated_by")
	private String updatedBy;
	@Column(name ="updated_date")
	private Date updatedDate;
	@Column(name ="is_Active")
	private boolean isActive;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public int getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(int purposeId) {
		this.purposeId = purposeId;
	}
	public String getPurposeDescription() {
		return purposeDescription;
	}
	public void setPurposeDescription(String purposeDescription) {
		this.purposeDescription = purposeDescription;
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
