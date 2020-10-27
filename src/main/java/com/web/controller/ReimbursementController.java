package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;

public class ReimbursementController {

	/*
	 * 
	 * The controller package acts a communication medium between the UI and the service package. 
	 * 
	 * There is a controller class for each table that exists in the database.
	 * 
	 * The Implementation for each method is described in the Corresponding DAO class.
	 */
	
	private ReimbursementService rs;
	
	public ReimbursementController() {
		this(new ReimbursementService());
	}
	
	public ReimbursementController(ReimbursementService rs) {
		super();
		this.rs = rs;
	}
	
	public List<Reimbursement> findAll(){
		return rs.findAll();
	}
	
	public Reimbursement findById(Integer i) {
		return rs.findById(i);
	}
	
	public int update(Reimbursement t) {
		return rs.update(t);
	}
	
	public int create(Reimbursement t) {
		return rs.create(t);
	}
	
	public int delete(Integer i) {
		return rs.delete(i);
	}
	
	public void create(HttpServletRequest req, HttpServletResponse res) throws IOException{
		try {
			Reimbursement r = new ObjectMapper().readValue(req.getInputStream(), Reimbursement.class);
			int reimbResult = rs.create(r);
			res.getWriter().println("Reimbursement successfully added");
		}catch (IOException e){
			e.printStackTrace();
			res.getWriter().println("Something went wrong");
		}
	}
}
