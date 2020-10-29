package com.web.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.config.EnvironmentConnectionUtil;
import com.web.model.Reimbursement;

public class ReimbursementDao implements DaoContract<Reimbursement,Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new LinkedList<>();
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

			Statement s = conn.createStatement();
			String sql = "select * from ers_reimbursement";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	public List<Reimbursement> findAllNotPending() {
		List<Reimbursement> reimb = new LinkedList<>();
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

			Statement s = conn.createStatement();
			String sql = "select * from ers_reimbursement where reimb_status_id != 1";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}
	
	public List<Reimbursement> findOpenReimbs() {
		List<Reimbursement> reimb = new LinkedList<>();
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

			Statement s = conn.createStatement();
			String sql = "select * from ers_reimbursement where reimb_status_id < 3";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Reimbursement findById(Integer i) { 
		Reimbursement findReimb = null;
		String sqlQuery = "select * from ers_reimbursement where reimb_id = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
 
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				findReimb = new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return findReimb;
	}

	@Override
	public int update(Reimbursement t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createNewReimb(HttpServletRequest req, HttpServletResponse resp, int EmployeeId) {
		String sqlQuery = "call user_submitted_claim(?,?,?,?,?)";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			
			ps.setInt(1, Integer.parseInt(req.getParameter("reimb_amount")));
			ps.setDate(2, (Date.valueOf(LocalDate.parse(req.getParameter("reimb_submitted")))));
			ps.setString(3, req.getParameter("reimb_description"));
			ps.setInt(4, Integer.parseInt(req.getParameter("reimb_type_id")));
			ps.setInt(5, EmployeeId);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	public int create(Reimbursement t) {
		String sqlQuery = "insert into ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (default,?,?,?,?,?,?,?,?)";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
 
				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setBigDecimal(1, t.getReimbursementAmount());
			ps.setDate(2, t.getSubmittedDate());
			ps.setDate(3, t.getResolvedDate());
			ps.setString(4, t.getDescription());
			ps.setInt(5, t.getReimbursementAuthor());
			ps.setInt(6, t.getReimbursementResolver());
			ps.setInt(7, t.getReimbursementStatusId());
			ps.setInt(8, t.getReimbursementTypeId());
			ps.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursement findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getReimbStatus(Reimbursement t) {
		String status = null;
		String sqlQuery = "select reimb_status from ers_reimbursement_status where reimb_status_id = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, t.getReimbursementStatusId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = rs.getString(1);
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return status;	
	}
	public String getReimbType(Reimbursement t) {
		String type = null;
		String sqlQuery = "select reimb_type from ers_reimbursement_type where reimb_type_id = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, t.getReimbursementTypeId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				type = rs.getString(1);
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return type;	
	}
	
	
}
