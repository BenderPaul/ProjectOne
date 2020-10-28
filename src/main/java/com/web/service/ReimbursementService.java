package com.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Reimbursement;
import com.web.repo.ReimbursementDao;
import com.web.repo.UserDao;

public class ReimbursementService {

	private ReimbursementDao rd;
	
	public ReimbursementService() {
		this(new ReimbursementDao());
	}
	
	public ReimbursementService(ReimbursementDao rd) {
		super();
		this.rd = rd;
	}
	public List<Reimbursement> findHistory(){
		return rd.findAllNotPending();
	}
	public List<Reimbursement> findOpenReimbs(){
		return rd.findOpenReimbs();
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
	
	public int createNewReimb(HttpServletRequest req, HttpServletResponse resp, String firstname, String lastname) {
		UserDao ud = new UserDao();
		int empId = ud.getEmployeeId(firstname, lastname);		
		return rd.createNewReimb(req, resp, empId);
	}

}
