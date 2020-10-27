package com.web.service;

import java.util.List;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;

public class ReimbursementService {

	private ReimbursementDao rd;
	
	public ReimbursementService() {
		this(new ReimbursementDao());
	}
	
	public ReimbursementService(ReimbursementDao rd) {
		super();
		this.rd = rd;
	}
	
	public List<Reimbursement> findAll() {
		return rd.findAll();
	}
	
	public Reimbursement findById(Integer i) {
		return rd.findById(i);
	}

	public int update(Reimbursement t) {
		return rd.update(t);
	}
	
	public int create(Reimbursement t) {
		return rd.create(t);
	}

	public int delete(Integer i) {
		return rd.delete(i);
	}
	
	public String getReimbStatus(Reimbursement t) {
		return rd.getReimbStatus(t);
	}
	
	public String getReimbursementType(Reimbursement t) {
		return rd.getReimbType(t);
	}
	
	public int createNewReimb(Reimbursement t, String firstname, String lastname) {
		return rd.createNewReimb(t, firstname, lastname);
	}

}
