package com.web.repo;

import java.util.List;

import org.apache.catalina.Manager;

public class ManagerDao  implements DaoContract<Manager, Integer>{

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manager findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Manager t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create(Manager t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Manager findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getJobTitle(Manager t) {
		// TODO Auto-generated method stub
		return null;
	}
}
