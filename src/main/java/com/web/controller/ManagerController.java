package com.web.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.web.model.Manager;
import com.web.service.ManagerService;

public class ManagerController {

	private ManagerService ms;
	
	public ManagerController(ManagerService ms) {
		super();
		this.ms = ms;
	}
	
	public ManagerController() {
		this(new ManagerService());
	}
	
	public List<Manager> findAll(){
		return ms.findAll();
	}
	
	public Manager findById(Integer i) {
		return ms.findById(i);
	}
	
	public int update(Manager t) {
		return ms.update(t);
	}
	
	public int create(Manager t) {
		return ms.create(t);
	}
	
	public int delete(Integer i) {
		return ms.delete(i);
	}
	
	public String login(HttpServletRequest req) {
		String userName = req.getParameter("name");
		Manager m = ms.findByName(userName);
		if(Optional.of(m).isPresent()) {
			return "html/landing.html";
		} else {
			return "html/landing.html";
		}
	}
}
