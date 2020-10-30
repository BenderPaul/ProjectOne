package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	public void sendDataHistory(HttpServletResponse resp) {
		resp.setContentType("text/json");
		List<Reimbursement> reimb = rs.findHistory();
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(reimb));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public void sendOpenReimbs(HttpServletResponse resp) {
		resp.setContentType("text/json");
		List<Reimbursement> reimb = rs.findOpenReimbs();
		try {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(reimb));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void sendAllData(HttpServletResponse res) {
		res.setContentType("text/json");
		List<Reimbursement> reimb = rs.findAll();
		try {
			res.getWriter().println(new ObjectMapper().writeValueAsString(reimb));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void approve(HttpServletRequest req, HttpServletResponse resp) {
		//resp.setContentType("text/json");
		rs.approve(req, resp);
	}
	
	public void deny(HttpServletRequest req, HttpServletResponse resp) {
		//resp.setContentType("text/json");
		rs.deny(req, resp);
	}
}
