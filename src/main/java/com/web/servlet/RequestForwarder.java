package com.web.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.UserController;

public class RequestForwarder {


	public String routes(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/ProjectOne/login.page":
			return new UserController().login(req);
		default:
			return "html/landing.html";
		}
	}

	public void data(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch(req.getRequestURI()) {
		case "/ProjectOne/all.json":
			new UserDataController().sendAllData(res);
			break;
		case "/ProjectOne/user.json":
			new SaveController().save(req, res);
			break;
		}
	}
}
