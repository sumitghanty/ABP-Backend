package com.mazars.in.model.transactionmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@EnableJpaAuditing
@OptimisticLocking(type = OptimisticLockType.NONE)
@Table(name="tbl_task_approval_workflow")
public class TaskApprovalWorkflow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="trip_task_id")
	private int tripTaskId;
	@Column(name="trip_id")
	private int tripId;
	@Column(name="assignee")
	private String assignee;
	@Column(name="assignee_email")
	private String assigneeEmail;
	@Column(name="success_comment")
	private String successComment;
	@Column(name="rejection_comment")
	private String rejectionComment;
	@Column(name="status")
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTripTaskId() {
		return tripTaskId;
	}
	public void setTripTaskId(int tripTaskId) {
		this.tripTaskId = tripTaskId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssigneeEmail() {
		return assigneeEmail;
	}
	public void setAssigneeEmail(String assigneeEmail) {
		this.assigneeEmail = assigneeEmail;
	}
	public String getSuccessComment() {
		return successComment;
	}
	public void setSuccessComment(String successComment) {
		this.successComment = successComment;
	}
	public String getRejectionComment() {
		return rejectionComment;
	}
	public void setRejectionComment(String rejectionComment) {
		this.rejectionComment = rejectionComment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
