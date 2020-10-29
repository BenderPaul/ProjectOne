
  package com.web.test; import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.web.controller.ManagerController;
import com.web.controller.ReimbDataController;
import com.web.controller.ReimbursementController;
import com.web.controller.UserController;
import com.web.model.Manager;
import com.web.model.Reimbursement;
import com.web.model.User;
import com.web.repo.ReimbursementDao;
import com.web.repo.UserDao;
import com.web.service.ReimbursementService;
import com.web.service.UserService;
import com.web.servlet.IndirectServlet;
  
  public class MainTest {
	  
  HttpServletRequest request;
  HttpServletResponse response;
  public void setUp() throws Exception{
	  MockitoAnnotations.initMocks(this);
  }
  
  
  ReimbursementService testReimbService = new ReimbursementService();
  UserService testUserService = new UserService(); 
  User testUser = new User(100, "Jerry123", "theseinfield", "Jerry", "Seinfield", "Jerry9001@gmail.com", 2);
  Reimbursement testReimb = new Reimbursement(10, BigDecimal.valueOf(100), Date.valueOf(LocalDate.parse("2020-10-20")), Date.valueOf(LocalDate.parse("2020-10-20")), "twinkies", 1,1,1,1);
  ReimbursementController testReimbCont = new ReimbursementController();
  ReimbursementDao testDao = new ReimbursementDao();
  UserDao testUserDao = new UserDao();
  ManagerController mc = new ManagerController();
  UserController uc = new UserController();
  Manager testManager = new Manager(100, "Jerry123", "theseinfield", "Jerry", "Seinfield", "Jerry9001@gmail.com", 2);
  
  @Test public void testUserCreation(){ 
	  assertEquals("Jerry123",testUser.getUsername()); 
  }
  
  @Test public void testUserDatabaseGetUsername(){ 
	  assertEquals("Mr", uc.findById(1).getUsername()); 
  }
  
  @Test public void testUserDatabaseGetPassword(){ 
	  assertEquals("Manager", uc.findById(1).getPassword()); 
  }
  
  @Test public void testUserDatabaseGetLastName(){ 
	  assertEquals("Dad", uc.findById(1).getLastName()); 
  }
  
  @Test public void testUserDatabaseGetFirstName(){ 
	  assertEquals("Tom", uc.findById(1).getFirstName()); 
  }
  
  @Test public void testUserDatabaseGetEmail(){
	  assertEquals("TheDad@gmail.com", uc.findById(1).getUserEmail()); 
  }
  
  @Test public void testUserDatabaseGetJobTitle(){ 
	  assertEquals("Employee",testUserService.getJobTitle(testUserService.findById(1))); 
  }
  
  @Test public void testUserDatabaseFindAll(){
	  assertEquals("Mr", uc.findAll().get(0).getUsername()); 
  }
  
  @Test public void testUserDatabaseGetEmployeeId(){ 
	  assertEquals(1, testUserService.getEmployeeId("Tom", "Dad"));
  } 
  
  @Test public void testGetReimbursementType(){ 
	  assertEquals("Payment",testReimbService.getReimbursementType(testReimbService.findById(2))); 
  }
  
  @Test public void testGetReimbursementStatus(){ 
	  assertEquals("Approved",testReimbService.getReimbStatus(testReimbService.findById(2))); 
  }
  
  @Test public void testGetAllReimbursements() {
	  assertEquals(BigDecimal.valueOf(10000), testReimbService.findAll().get(3).getReimbursementAmount()); 
  }
  
  @Test public void testGetSubmitDate() {
	  assertEquals(Date.valueOf("2020-10-20"), testReimb.getSubmittedDate());
  }
  
  @Test public void testGetResolveDate() {
	  assertEquals(Date.valueOf("2020-10-20"), testReimb.getResolvedDate());
  }
  
  @Test public void testGetDeescription() {
	  assertEquals("twinkies", testReimb.getDescription());
  }
  
  @Test public void testReimbControllerToDao() {
	  assertEquals(BigDecimal.valueOf(10000), testReimbCont.findAll().get(3).getReimbursementAmount()); 
  }
  
  @Test public void testReimbControllerFindById() {
	  assertEquals("I'm testing the create method", testReimbCont.findById(1).getDescription()); 
  }
  
  @Test public void testReimbDaoGetStatus() {
	  assertEquals("Submitted", testDao.getReimbStatus(testDao.findById(1)));
  }
  
  @Test public void testReimbDaoFindOpenReimbs() {
	  assertEquals(BigDecimal.valueOf(25), testDao.findOpenReimbs().get(1).getReimbursementAmount());
  }
  
  @Test public void testReimbDaoFindClosedReimbs() {
	  assertEquals(BigDecimal.valueOf(100), testDao.findAllNotPending().get(0).getReimbursementAmount());
  }
  
  @Test public void testReimbDaoDelete() {
	  assertEquals(0, testDao.delete(0));
  }
  
  @Test public void testReimbDaoFindByName() {
	  assertEquals(null, testDao.findByName("John"));
  }
  
  @Test public void testReimbDaoUpdate() {
	  assertEquals(0, testDao.update(testReimb));
  }
  
  @Test public void testUserDaoUpdate() {
	  assertEquals(0, testUserDao.update(testUser));
  }
  
  @Test public void testUserDaoCreate() {
	  assertEquals(0, testUserDao.create(testUser));
  }
  
  @Test public void testUserDaoDelete() {
	  assertEquals(0, testUserDao.delete(0));
  }
  
  @Test public void testUserDaoFindByName() {
	  assertEquals(null, testUserDao.findByName("John"));
  }
  
  @Test public void testReimbDaoCreate() {
	  assertEquals(1, testDao.create(testReimb));
  }
  
  @Test public void testManagerControllerfindAll() {
	  assertEquals(null, mc.findAll());
  }
  
  @Test public void testManagerControllerfindById() {
	  assertEquals(null, mc.findById(1));
  }
  
  @Test public void testManagerControllerUpdate() {
	  assertEquals(0, mc.update(new Manager()));
  }
  
  @Test public void testManagerControllerCreate() {
	  assertEquals(0, mc.create(new Manager()));
  }
  
  @Test public void testManagerControllerDelete() {
	  assertEquals(0, mc.delete(0));
  }
  
  @Test public void testManagerConstructor() {
	  Manager newMan = new Manager(1,"b","a","c","d","e",1);
	  assertEquals(1, newMan.getUserId());
  }
  
  @Test public void testUserConstructor() {
	  User newUser = new User(1,"b","a","c","d","e",1);
	  assertEquals(1, newUser.getUserId());
  }
  
  @Test public void testReimbConstructor() {
	  Reimbursement testReimb = new Reimbursement(10, BigDecimal.valueOf(100), Date.valueOf(LocalDate.parse("2020-10-20")), Date.valueOf(LocalDate.parse("2020-10-20")), "twinkies", 1,1,1,1);
	  assertEquals(10, testReimb.getReimbursementId());
  }
  
  @Test public void testReimbToString() {
	  assertEquals('u' , testReimb.toString().charAt(5));
  }
  
  @Test public void testUserToString() {
	  assertEquals(true , testUser.toString().contains("the"));
  }
  
  @Test public void testReimbursementSetDesc() {
	  testReimb.setDescription("LOL");
	  assertEquals("LOL", testReimb.getDescription());
  }
  
  @Test public void testReimbursementSetReimbursementId() {
	  testReimb.setReimbursementId(1);;
	  assertEquals(1, testReimb.getReimbursementId());
  }
  
  @Test public void testReimbursementSetReimbursementResolver() {
	  testReimb.setReimbursementResolver(2);;
	  assertEquals(2, testReimb.getReimbursementResolver());
  }
  
  @Test public void testReimbursementSetReimbursementTypeId() {
	  testReimb.setReimbursementTypeId(1);
	  assertEquals(1, testReimb.getReimbursementTypeId());
  }
  
  @Test public void testReimbursementSetReimbursementStatusId() {
	  testReimb.setReimbursementStatusId(1);
	  assertEquals(1, testReimb.getReimbursementStatusId());
  }
  
  @Test public void testReimbDataControllerConstructor() {
	  ReimbDataController newreimbdata = new ReimbDataController();
	  assertTrue(true);
  }
  
  @Test public void testManagerControllerConstructor() {
	  Manager newMan = new Manager();
	  assertTrue(true);
  }
  
  @Test public void testReimbursementControllerConstructor() {
	  ReimbursementController newReim = new ReimbursementController();
	  assertTrue(true);
  }
  
  @Test public void testUserControllerConstructor() {
	  UserController userCont = new UserController();
	  assertTrue(true);
  }
  
  @Test public void testManagerSetFirstName() {
	  testManager.setFirstName("dave");
	  assertEquals("dave", testManager.getFirstName());
  }
  
  @Test public void testManagerSetLastName() {
	  testManager.setLastName("dave");
	  assertEquals("dave", testManager.getLastName());
  }
  
  @Test public void testManagerSetUsername() {
	  testManager.setUsername("dave");
	  assertEquals("dave", testManager.getUsername());
  }
  
  @Test public void testManagerSetPassword() {
	  testManager.setPassword("dave");
	  assertEquals("dave", testManager.getPassword());
  }
  
  @Test public void testManagerSetUserId() {
	  testManager.setUserId(8);
	  assertEquals(8, testManager.getUserId());
  }
  
  @Test public void testManagerSetEmail() {
	  testManager.setUserEmail("Dave@");
	  assertEquals("Dave@", testManager.getUserEmail());
  }
  
  @Test public void testManagerSetUserRoleId() {
	  testManager.setUserRoleId(2);
	  assertEquals(2, testManager.getUserRoleId());
  }
  
  @Test public void testDataServlet() throws IOException {
	  IndirectServlet testServ = new IndirectServlet();
	  testServ.init();
	  testServ.destroy();
	  assertTrue(true);
  }
  
  @Test public void testUserSetFirstName() {
	  testUser.setFirstName("dave");
	  assertEquals("dave", testUser.getFirstName());
  }
  
  @Test public void testUserSetLastName() {
	  testUser.setLastName("dave");
	  assertEquals("dave", testUser.getLastName());
  }
  
  @Test public void testUserSetUsername() {
	  testUser.setUsername("dave");
	  assertEquals("dave", testUser.getUsername());
  }
  
  @Test public void testUserSetPassword() {
	  testUser.setPassword("dave");
	  assertEquals("dave", testUser.getPassword());
  }
  
  @Test public void testUserSetUserId() {
	  testUser.setUserId(8);
	  assertEquals(8, testUser.getUserId());
  }
  
  @Test public void testUserSetEmail() {
	  testUser.setUserEmail("Dave@");
	  assertEquals("Dave@", testUser.getUserEmail());
  }
  
  @Test public void testUserSetUserRoleId() {
	  testUser.setUserRoleId(2);
	  assertEquals(2, testUser.getUserRoleId());
  }

  
}
 
  
  
  
  