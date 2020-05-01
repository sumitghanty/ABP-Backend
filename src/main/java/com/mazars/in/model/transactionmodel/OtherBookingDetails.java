package com.mazars.in.model.transactionmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EnableJpaAuditing
@Table(name="hotel_food_other_invoice_details")
public class OtherBookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="other_invoice_details_id")
	private int otherInvoiceDetailsId;

	@Column(name="line_item_id")
	private int lineItemId;
	@Column(name="trip_id")
	private int tripId;
	@Column(name="invoice_issue_date")
	private Date invoiceIssueDate;
	@Column(name="type")
	private String type;
	@Column(name="amount")
	private int amount;	
	@Column(name="status")
	private String status;
	@Column(name="sub_status")
	private String subStatus;
	@Column(name="pending_with")
	private String pendingWith;	
	@Column(name="pending_with_email")
	private String pendingWithEmail;
	
	
	public int getOtherInvoiceDetailsId() {
		return otherInvoiceDetailsId;
	}
	public void setOtherInvoiceDetailsId(int otherInvoiceDetailsId) {
		this.otherInvoiceDetailsId = otherInvoiceDetailsId;
	}
	public int getLineItemId() {
		return lineItemId;
	}
	public void setLineItemId(int lineItemId) {
		this.lineItemId = lineItemId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public Date getInvoiceIssueDate() {
		return invoiceIssueDate;
	}
	public void setInvoiceIssueDate(Date invoiceIssueDate) {
		this.invoiceIssueDate = invoiceIssueDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
	public String getPendingWith() {
		return pendingWith;
	}
	public void setPendingWith(String pendingWith) {
		this.pendingWith = pendingWith;
	}
	public String getPendingWithEmail() {
		return pendingWithEmail;
	}
	public void setPendingWithEmail(String pendingWithEmail) {
		this.pendingWithEmail = pendingWithEmail;
	}

	
	
}
