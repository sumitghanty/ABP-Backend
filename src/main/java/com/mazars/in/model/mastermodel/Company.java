/*******
 * 
 * 
 * @author User samit 
 * @Date 12 march 2020
 * @The table will be used to maintain the company of the account of instance. 
 * Here legal entity of ABP Pvt Ltd Group company will be maintained
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
@Table(name="tbl_company")
public class Company {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private int companyId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="company_description")
	private String companyDescription;
	@Column(name="company_address_line1")
	private String companyAddressLine1;
	@Column(name="company_address_line2")
	private String companyAddressLine2;
	@Column(name="company_address_line3")
	private String companyAddressLine3;
	@Column(name="company_pin")
	private String companyPin;
	@Column(name="company_phone_number")
	private String companyPhoneNumber;
	@Column(name="company_email_id")
	private String companyEmailId;
	@Column(name="company_contact_person1")
	private String companyContactPerson1;
	@Column(name="company_contact_person2")
	private String companyContactPerson2;
	@Column(name="company_contact_person1_email_id")
	private String companyContactPerson1EmailId;
	@Column(name="company_contact_person2_email_id")
	private String companyContactPerson2EmailId;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="created_date")
	private Date createdDate;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="updated_date")
	private Date updatedDate;
	@Column(name="is_active")
	private Date isActive;
	@Column(name="instance_id")
	private int instanceId;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instance_id", nullable=false)
	private Instance instance;
	
	public Instance getInstance() {
		return instance;
	}
	public void setInstance(Instance instance) {
		this.instance = instance;
	}*/
	
	/*@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="company_id")
	private Set<OrganizationMaster> organization;
*/
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDescription() {
		return companyDescription;
	}

	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	public String getCompanyAddressLine1() {
		return companyAddressLine1;
	}

	public void setCompanyAddressLine1(String companyAddressLine1) {
		this.companyAddressLine1 = companyAddressLine1;
	}

	public String getCompanyAddressLine2() {
		return companyAddressLine2;
	}

	public void setCompanyAddressLine2(String companyAddressLine2) {
		this.companyAddressLine2 = companyAddressLine2;
	}

	public String getCompanyAddressLine3() {
		return companyAddressLine3;
	}

	public void setCompanyAddressLine3(String companyAddressLine3) {
		this.companyAddressLine3 = companyAddressLine3;
	}

	public String getCompanyPin() {
		return companyPin;
	}

	public void setCompanyPin(String companyPin) {
		this.companyPin = companyPin;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getCompanyEmailId() {
		return companyEmailId;
	}

	public void setCompanyEmailId(String companyEmailId) {
		this.companyEmailId = companyEmailId;
	}

	public String getCompanyContactPerson1() {
		return companyContactPerson1;
	}

	public void setCompanyContactPerson1(String companyContactPerson1) {
		this.companyContactPerson1 = companyContactPerson1;
	}

	public String getCompanyContactPerson2() {
		return companyContactPerson2;
	}

	public void setCompanyContactPerson2(String companyContactPerson2) {
		this.companyContactPerson2 = companyContactPerson2;
	}

	public String getCompanyContactPerson1EmailId() {
		return companyContactPerson1EmailId;
	}

	public void setCompanyContactPerson1EmailId(String companyContactPerson1EmailId) {
		this.companyContactPerson1EmailId = companyContactPerson1EmailId;
	}

	public String getCompanyContactPerson2EmailId() {
		return companyContactPerson2EmailId;
	}

	public void setCompanyContactPerson2EmailId(String companyContactPerson2EmailId) {
		this.companyContactPerson2EmailId = companyContactPerson2EmailId;
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

	public Date getIsActive() {
		return isActive;
	}

	public void setIsActive(Date isActive) {
		this.isActive = isActive;
	}

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	

	
	
	
}
