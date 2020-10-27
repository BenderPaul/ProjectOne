package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.model.Reimbursement;
import com.web.service.ReimbursementService;

public class ReimbDataController {
	
	private ReimbursementService rs;

	public ReimbDataController() {
		this(new ReimbursementService());
	}

	public ReimbDataController(ReimbursementService rs) {
		super();
		this.rs = rs;
	}
	
	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reimb = rs.findAll();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reimb));
		} catch (IOException e) {e.printStackTrace();}
	}
	
}
