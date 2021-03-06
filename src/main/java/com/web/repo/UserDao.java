package com.web.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.config.EnvironmentConnectionUtil;
import com.web.model.User;

public class UserDao implements DaoContract<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> user = new LinkedList<>();
		String sql = "select * from ers_users";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User findById(Integer i) {
		User findUser = null;
		String sqlQuery = "select * from ers_users where ers_users_id = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				findUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return findUser;
	}

	@Override
	public int update(User t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int create(User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getJobTitle(User t) {
		String title = null;
		String sqlQuery = "select user_role from ers_user_roles where ers_user_role_id = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){

				PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, t.getUserId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				title = rs.getString(1);
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return title;	
	}
	
	public int getEmployeeId(String firstname, String lastName) {
		int employeeId = 0;
		String sql = "select ers_users_id from ers_users where user_first_name = ? and user_last_name = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
 
				PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employeeId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeId;
	}
	
	public int getEmployeeIdByLogin(String firstname, String lastName) {
		int employeeId = 0;
		String sql = "select ers_users_id from ers_users where ers_username = ? and ers_password = ?";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employeeId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeId;
	}
	
	public int create(HttpServletRequest req, HttpServletResponse resp) {
		String sqlQuery = "insert into ers_users (ers_users_id, ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values (default, ?, ?, ?, ?, ?, 1)";
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://revature-db1.cpvgxtqimmru.us-west-2.rds.amazonaws.com:5432/postgres?currentSchema=projectone","revature", "revature")){
 
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			ps.setString(1, req.getParameter("username"));
			ps.setString(2, req.getParameter("password"));
			ps.setString(3, req.getParameter("firstname"));
			ps.setString(4, req.getParameter("lastname"));
			ps.setString(5, req.getParameter("newemail"));
			ps.execute();
			System.out.println("The dad query hath been called");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
}




