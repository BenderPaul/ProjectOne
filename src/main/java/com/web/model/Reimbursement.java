package com.web.model;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {

	private int reimbursementId;
	private BigDecimal reimbursementAmount;
	private Date submittedDate;
	private Date resolvedDate;
	private String description;
//	private InputStream reciept;
	private int reimbursementAuthor;
	private int reimbursementResolver;
	private int reimbursementStatusId;
	private int reimbursementTypeId;





	public Reimbursement(int reimbursementId, BigDecimal reimbursementAmount, Date submittedDate, Date resolvedDate,
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

	public Reimbursement(int int1, BigDecimal bigDecimal, String string, String string2, String string3, String string4,
			int int2, int int3, int int4, int int5) {
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

	

	public Date getSubmittedDate() {
		return submittedDate;
	}


	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}


	public Date getResolvedDate() {
		return resolvedDate;
	}


	public void setResolvedDate(Date resolvedDate) {
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
