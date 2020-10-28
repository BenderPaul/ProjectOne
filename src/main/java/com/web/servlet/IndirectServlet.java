package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.ReimbDataController;
import com.web.model.User;
import com.web.repo.UserDao;
import com.web.service.ReimbursementService;
import com.web.service.UserService;

@SuppressWarnings("serial")
public class IndirectServlet extends HttpServlet {
	
	
	  private UserDao ud = new UserDao();
	  public void init() {
	  //System.out.println("Indirect Servlet is initialized");
	  }
	 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("WebCode/html/login.html");
	}
	
	public void data(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(req.getRequestURI()) {
		case "/Project1/all.json":
			new ReimbDataController().sendAllData(resp);
			break;
		case "/Project1/reimb.json":
			new ReimbursementService().createNewReimb(req, resp, req.getParameter("user_first_name"), req.getParameter("user_last_name"));
			resp.sendRedirect("WebCode/html/employeeportal.html");
			break;
		case "/Project1/newdad.json":
			System.out.println("we're calling all dads, here");
			new UserService().create(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		for (User user : ud.findAll()) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				if (user.getPassword().equalsIgnoreCase(password)) {
					if(user.getUserRoleId() == 1) {
						resp.sendRedirect("WebCode/html/employeeportal.html");
						return;
					}if(user.getUserRoleId() == 2) {
						resp.sendRedirect("WebCode/html/managerportal.html");
						return;
					}
				}
			}
		}
		req.getRequestDispatcher("").forward(req, resp);
	}
		
//		if(username.equals("john")) {
//			if(password.equals("pass")) {
//				req.getRequestDispatcher("WebCode/html/employeeportal.html").forward(req, resp);
//			}else req.getRequestDispatcher("").forward(req, resp);		
//		}else req.getRequestDispatcher("").forward(req, resp);
//	}
	
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
	
	public void destroy() {
		System.out.println("Indirect Servlet Destroyed");
	}
}
