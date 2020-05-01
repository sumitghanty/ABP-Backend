/*****
 * @author User samit Tiwary
 * @Date 12 march 2020 
 * @The table will be used to maintain the instance or account.
 *  Here ABP Group company is an instance for this application
 * 
 * 
 * 
 */

package  com.mazars.in.model.mastermodel;

import java.util.Date;
import java.util.List;
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


@Entity
@Table(name="tbl_instance")
public class Instance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@OneToMany(mappedBy="instanceId", cascade = CascadeType.ALL)
	@Column(name="instance_id")
	private int instanceId;
	@Column(name="instance_name")
	private String instanceName;
	@Column(name="from_date")
	private Date fromDate;
	@Column(name="to_date")
	private Date toDate;
	@Column(name="is_active")
	private boolean isActive;
	@Column(name="instance_description")
	private String instanceDescription;
	@Column(name="instance_address_line1")
	private String instanceAddressLine1;
	@Column(name="instance_address_line2")
	private String instanceAddressLine2;
	@Column(name="instance_address_line3")
	private String instanceAddressLine3;
	@Column(name="instance_pin")
	private String instancePin;
	@Column(name="instance_phone_number")
	private String instancePhoneNumber;
	@Column(name="instance_email_id")
	private String instanceEmailId;
	@Column(name="instance_contact_person1")
	private String instanceContactPerson1;
	@Column(name="instance_contact_person2")
	private String instanceContactPerson2;
	@Column(name="instance_contact_person1_email_id")
	private String instanceContactPerson1EmailId;
	@Column(name="instance_contact_person2_email_id")
	private String instanceContactPerson2EmailId;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="instance_id")
	private Set<Company> company;


	public int getInstanceId() {
		return instanceId;
	}


	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}


	public String getInstanceName() {
		return instanceName;
	}


	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
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


	public String getInstanceDescription() {
		return instanceDescription;
	}


	public void setInstanceDescription(String instanceDescription) {
		this.instanceDescription = instanceDescription;
	}


	public String getInstanceAddressLine1() {
		return instanceAddressLine1;
	}


	public void setInstanceAddressLine1(String instanceAddressLine1) {
		this.instanceAddressLine1 = instanceAddressLine1;
	}


	public String getInstanceAddressLine2() {
		return instanceAddressLine2;
	}


	public void setInstanceAddressLine2(String instanceAddressLine2) {
		this.instanceAddressLine2 = instanceAddressLine2;
	}


	public String getInstanceAddressLine3() {
		return instanceAddressLine3;
	}


	public void setInstanceAddressLine3(String instanceAddressLine3) {
		this.instanceAddressLine3 = instanceAddressLine3;
	}


	public String getInstancePin() {
		return instancePin;
	}


	public void setInstancePin(String instancePin) {
		this.instancePin = instancePin;
	}


	public String getInstancePhoneNumber() {
		return instancePhoneNumber;
	}


	public void setInstancePhoneNumber(String instancePhoneNumber) {
		this.instancePhoneNumber = instancePhoneNumber;
	}


	public String getInstanceEmailId() {
		return instanceEmailId;
	}


	public void setInstanceEmailId(String instanceEmailId) {
		this.instanceEmailId = instanceEmailId;
	}


	public String getInstanceContactPerson1() {
		return instanceContactPerson1;
	}


	public void setInstanceContactPerson1(String instanceContactPerson1) {
		this.instanceContactPerson1 = instanceContactPerson1;
	}


	public String getInstanceContactPerson2() {
		return instanceContactPerson2;
	}


	public void setInstanceContactPerson2(String instanceContactPerson2) {
		this.instanceContactPerson2 = instanceContactPerson2;
	}


	public String getInstanceContactPerson1EmailId() {
		return instanceContactPerson1EmailId;
	}


	public void setInstanceContactPerson1EmailId(String instanceContactPerson1EmailId) {
		this.instanceContactPerson1EmailId = instanceContactPerson1EmailId;
	}


	public String getInstanceContactPerson2EmailId() {
		return instanceContactPerson2EmailId;
	}


	public void setInstanceContactPerson2EmailId(String instanceContactPerson2EmailId) {
		this.instanceContactPerson2EmailId = instanceContactPerson2EmailId;
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


	public Set<Company> getCompany() {
		return company;
	}


	public void setCompany(Set<Company> company) {
		this.company = company;
	}


	
	
}
