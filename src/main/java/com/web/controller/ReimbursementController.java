package com.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;
import com.web.service.UserService;

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
	private UserService us;
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
			//System.out.println("Input stream= " + req.getParameter("reimbursementId"));
			
			Reimbursement r = new Reimbursement(1, BigDecimal.valueOf(Integer.parseInt(req.getParameter("reimbursementAmount"))), req.getParameter("submittedDate"), "2000=10-10", req.getParameter("description"),us.getEmployeeId(req.getParameter("user_first_name"), req.getParameter("user_last_name")), 1, 1, Integer.parseInt(req.getParameter("reimb_type_id")));

			//Reimbursement r = new ObjectMapper().readValue(req.getInputStream(), Reimbursement.class);
			
			int reimbResult = rs.create(r);
			System.out.println("If this is one then it might have worked: " + reimbResult);
			res.getWriter().println("Reimbursement successfully added");
		}catch (IOException e){
			e.printStackTrace();
			res.getWriter().println("Something went wrong");
		}
	}
}
