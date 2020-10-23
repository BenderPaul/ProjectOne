package com.web.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.web.model.User;
import com.web.service.UserService;

public class UserController {
	
	private UserService us;

	public UserController(UserService us) {
		super();
		this.us = us;
	}

	public UserController() {
		this(new UserService());
	}
	
	public List<User> findAll(){
		return us.findAll();
	}
	
	public User findById(Integer i) {
		return us.findById(i);
	}
	
	public int update(User t) {
		return us.update(t);
	}
	
	public int create(User t) {
		return us.create(t);
	}
	
	public int delete(Integer i) {
		return us.delete(i);
	}
	
	public String login(HttpServletRequest req) {
		String userName = req.getParameter("name");
		User m = us.findByName(userName);
		if(Optional.of(m).isPresent()) {
			return "html/landing.html";
		} else {
			return "html/landing.html";
		}
	}
}