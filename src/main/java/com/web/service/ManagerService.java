package com.web.service;

import java.util.List;

import org.apache.catalina.Manager;

import com.web.repo.ManagerDao;

public class ManagerService {

	private ManagerDao md;
	
	public ManagerService() {
		this(new ManagerDao());
	}
	
	public ManagerService(ManagerDao md) {
		super();
		this.md = md;
	}
	
	public List<Manager> findAll(){
		return md.findAll();
	}
	
	public Manager findById(Integer i) {
		return md.findById(i);
	}
	
	public int update(Manager t) {
		return md.update(t);
	}
	
	public int create(Manager t) {
		return md.create(t);
	}
	
	public int delete(Integer i) {
		return md.delete(i);
	}
	
	public Manager findByName(String name) {
		return md.findByName(name);
	}
	
	public String getJobTitle(Manager t) {
		return md.getJobTitle(t);
	}
}