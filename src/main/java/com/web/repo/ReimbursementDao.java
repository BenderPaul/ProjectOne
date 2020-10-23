package com.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.web.config.EnvironmentConnectionUtil;
import com.web.model.Reimbursement;
import com.web.model.User;

public class ReimbursementDao implements DaoContract<Reimbursement,Integer> {

	@Override
	public List<Reimbursement> findAll() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int create(Reimbursement t) {
		// TODO Auto-generated method stub
		return 0;
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
