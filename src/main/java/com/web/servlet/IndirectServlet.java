package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Hierarchy:
 * 
 * 		Servlet (Interface)
 * 			GenericServlet (AC)
 * 				HttpServlet (AC)
 * 					CustomServlet (Our class)
 * 
 * 	Direct response:
 * 	
 * 	Forward response:
 * 		We candle the request in-house within our own web-app
 * 
 * 	Redirect response:
 * 		sends the user to a completely different server / web application
 * 		Url will change
 */

public class IndirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("WebCode/html/landing.html");
		
		req.getRequestDispatcher("WebCode/html/login.html").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("john")) {
			if(password.equals("pass")) {
				req.getRequestDispatcher("WebCode/html/success.html").forward(req, resp);
			}else req.getRequestDispatcher("WebCode/html/landing.html").forward(req, resp);		
		}else req.getRequestDispatcher("WebCode/html/landing.html").forward(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
