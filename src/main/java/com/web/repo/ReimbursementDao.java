package com.web.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.web.config.EnvironmentConnectionUtil;
import com.web.model.Reimbursement;

public class ReimbursementDao implements DaoContract<Reimbursement,Integer> {

	@Override
	public List<Reimbursement> findAll() {
		List<Reimbursement> reimb = new LinkedList<>();
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			Statement s = conn.createStatement();
			String sql = "select * from ers_reimbursement";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				reimb.add(new Reimbursement(rs.getInt(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			System.out.println(reimb.toString());
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
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
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

	public int createNewReimb(Reimbursement t, String firstname, String lastname) {
		String sqlQuery = "call user_submitted_claim(?,?,?,?,?,?)";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setBigDecimal(1, t.getReimbursementAmount());
			ps.setTimestamp(2, t.getSubmittedDate());
			ps.setString(3, t.getDescription());
			ps.setString(4, firstname);
			ps.setString(5, lastname);
			ps.setInt(6, t.getReimbursementTypeId());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	public int create(Reimbursement t) {
		String sqlQuery = "insert into ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (default,?,?,?,?,?,?,?,?)";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setBigDecimal(1, t.getReimbursementAmount());
			ps.setTimestamp(2, t.getSubmittedDate());
			ps.setTimestamp(3, t.getResolvedDate());
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
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
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
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
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
