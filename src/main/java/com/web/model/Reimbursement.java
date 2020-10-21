package com.web.model;

import java.math.BigDecimal;

public class Reimbursement {

	private int reimbursementId;
	private BigDecimal reimbursementAmount;
	private String submittedDate;
	private String resolvedDate;
	private String description;
	//private ByteStream reciept;
	private int reimbursementAuthor; 
	private int reimbursementResolver;
	private int reimbursementStatusId;
	private int reimbursementTypeId;
	
	
	public Reimbursement(int reimbursementId, BigDecimal reimbursementAmount, String submittedDate, String resolvedDate,
			String description, int reimbursementAuthor, int reimbursementResolver, int reimbursementStatusId,
			int reimbursementTypeId) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbursementAmount = reimbursementAmount;
		this.submittedDate = submittedDate;
		this.resolvedDate = resolvedDate;
		this.description = description;
		this.reimbursementAuthor = reimbursementAuthor;
		this.reimbursementResolver = reimbursementResolver;
		this.reimbursementStatusId = reimbursementStatusId;
		this.reimbursementTypeId = reimbursementTypeId;
	}


	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbursementAmount=" + reimbursementAmount
				+ ", submittedDate=" + submittedDate + ", resolvedDate=" + resolvedDate + ", description=" + description
				+ ", reimbursementAuthor=" + reimbursementAuthor + ", reimbursementResolver=" + reimbursementResolver
				+ ", reimbursementStatusId=" + reimbursementStatusId + ", reimbursementTypeId=" + reimbursementTypeId
				+ "]";
	}


	public int getReimbursementId() {
		return reimbursementId;
	}


	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}


	public BigDecimal getReimbursementAmount() {
		return reimbursementAmount;
	}


	public void setReimbursementAmount(BigDecimal reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}


	public String getSubmittedDate() {
		return submittedDate;
	}


	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}


	public String getResolvedDate() {
		return resolvedDate;
	}


	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getReimbursementAuthor() {
		return reimbursementAuthor;
	}


	public void setReimbursementAuthor(int reimbursementAuthor) {
		this.reimbursementAuthor = reimbursementAuthor;
	}


	public int getReimbursementResolver() {
		return reimbursementResolver;
	}


	public void setReimbursementResolver(int reimbursementResolver) {
		this.reimbursementResolver = reimbursementResolver;
	}


	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}


	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}


	public int getReimbursementTypeId() {
		return reimbursementTypeId;
	}


	public void setReimbursementTypeId(int reimbursementTypeId) {
		this.reimbursementTypeId = reimbursementTypeId;
	}
	
	
}
