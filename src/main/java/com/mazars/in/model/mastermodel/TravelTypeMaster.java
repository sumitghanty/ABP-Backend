/*
 * @author samit tiwary
 * date 12032020
 * 
 * The table will be used to maintain the Travel Type Master
 */

package  com.mazars.in.model.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_traveltype_master")
public class TravelTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="traveler_type_id")
	private int travelTypeId;
	@Column(name="company_id")
	private int companyId;
	@Column(name="traveler_type_description")
	private String travelTypeDescription;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private boolean isActive;
	public int getTravelTypeId() {
		return travelTypeId;
	}
	public void setTravelTypeId(int travelTypeId) {
		this.travelTypeId = travelTypeId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getTravelTypeDescription() {
		return travelTypeDescription;
	}
	public void setTravelTypeDescription(String travelTypeDescription) {
		this.travelTypeDescription = travelTypeDescription;
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
