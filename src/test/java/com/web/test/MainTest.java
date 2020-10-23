package com.web.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.web.model.User;
import com.web.service.ReimbursementService;
import com.web.service.UserService;

public class MainTest {
	
	ReimbursementService testReimbService = new ReimbursementService();
	UserService testUserService = new UserService();
	User testUser = new User(100, "Jerry123", "theseinfield", "Jerry", "Seinfield", "Jerry9001@gmail.com", 2);
	
	@Test
	public void testUserCreation(){
		assertEquals("Jerry123", testUser.getUsername());
	}
	
	@Test
	public void testUserDatabaseGetUsername(){
		assertEquals("stinky", testUserService.findById(1).getUsername());
	}
	
	@Test
	public void testUserDatabaseGetPassword(){
		assertEquals("stinky123", testUserService.findById(1).getPassword());
	}
	
	@Test
	public void testUserDatabaseGetLastName(){
		assertEquals("Stinkman", testUserService.findById(1).getLastName());
	}
	
	@Test
	public void testUserDatabaseGetFirstName(){
		assertEquals("Stank", testUserService.findById(1).getFirstName());
	}
	
	@Test
	public void testUserDatabaseGetEmail(){
		assertEquals("stinkyboi@gmail.com", testUserService.findById(1).getUserEmail());
	}
	
	@Test
	public void testUserDatabaseGetJobTitle(){
		assertEquals("Employee", testUserService.getJobTitle(testUserService.findById(1)));
	}
	
	@Test
	public void testGetReimbursementType() {
		assertEquals("purchase", testReimbService.getReimbursementType(testReimbService.findById(2)));
	}
	
	@Test
	public void testGetReimbursementStatus() {
		assertEquals("pending", testReimbService.getReimbStatus(testReimbService.findById(2)));
	}
}
