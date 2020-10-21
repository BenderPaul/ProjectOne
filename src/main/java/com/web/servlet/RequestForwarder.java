package com.web.servlet;

import javax.servlet.http.HttpServletRequest;

import com.web.controller.UserController;

public class RequestForwarder {

	
	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()){
		case "/ProjectOne/login.page":
			return new UserController().login(req);
		default: 
			return "html/landing.html";
		}
	}
}
