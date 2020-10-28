package com.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.User;
import com.web.repo.UserDao;

public class UserService {

	private UserDao ud;
	
	public UserService() {
		this(new UserDao());
	}
	
	public UserService(UserDao ud) {
		super();
		this.ud = ud;
	}
	
	public List<User> findAll(){
		return ud.findAll();
	}
	
	public User findById(Integer i) {
		return ud.findById(i);
	}
	
	public int update(User t) {
		return ud.update(t);
	}
	
	public int create(User t) {
		return ud.create(t);
	}
	
	public int delete(Integer i) {
		return ud.delete(i);
	}
	
	public User findByName(String name) {
		return ud.findByName(name);
	}
	
	public String getJobTitle(User t) {
		return ud.getJobTitle(t);
	}
	public int getEmployeeId(String firstname, String lastname) {
		return ud.getEmployeeId(firstname, lastname);
	}
	public int create(HttpServletRequest req, HttpServletResponse resp) {
		return ud.create(req, resp);
	}
}
