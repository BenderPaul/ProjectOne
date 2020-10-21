package com.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.web.model.User;

public class UserController {
	
	//private UserService us;

//	public UserController(UserService us) {
//		super();
//		this.us = us;
//	}

//	public UserController() {
//		this(new UserService());
//	}
//	
//	public String login(HttpServletRequest req) {
//		String userName = req.getParameter("name");
//		User m = us.findByName(userName);
//		if(Optional.of(m).isPresent()) {
//			return "html/landing.html";
//		} else {
//			return "html/landing.html";
//		}
//	}
}