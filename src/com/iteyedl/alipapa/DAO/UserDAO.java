package com.iteyedl.alipapa.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.*;

import com.iteyedl.alipapa.model.User;
import com.iteyedl.alipapa.util.DB;

public class UserDAO {
	
	public static void saveUser(User u) {
		Connection conn = DB.getConn();
		String sql = "insert into user values (null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		String username = u.getUsername();
		String password = u.getPassword();
		String phone = u.getPhone();
		String addr = u.getAddr();
		Date rdate = u.getRdate();
		try {
			pstmt.setString(1, username);
  			pstmt.setString(2, password);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);
			pstmt.setTimestamp(5, new Timestamp(rdate.getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public static void updateUser(User u) {
		Connection conn = DB.getConn();
		int id = u.getId();
		String username = u.getUsername();
		String phone = u.getPhone();
		String addr = u.getAddr();
		String sql = "update user set username=?, phone=?, addr=? where id=" + id;
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, phone);
			pstmt.setString(3, addr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}
	
	public static User getUser(String username) {
		User u = new User();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			String sql = "select * from user where username = '" + username +"'";
			rs = DB.executeQuery(conn, sql);
			rs.next();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setPassword(rs.getString("password"));
			u.setPhone(rs.getString("phone"));
			u.setAddr(rs.getString("addr"));
			u.setRdate(rs.getTimestamp("rdate"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return u;
	}
	
	public static List<User> getUsers() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			String sql = "select * from user";
			rs = DB.executeQuery(conn, sql);
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return list;
	}
	
	public static void deleteUser(int id) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DB.getConn();
			stmt = DB.getStmt(conn);
			stmt.executeUpdate("delete from user where id = " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(stmt);
			DB.closeConn(conn);
		}
	}
	
	public static boolean isUserExist(String username) {
		Boolean userExist = false;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			String sql = "select * from user where username = '" + username +"'";
			rs = DB.executeQuery(conn, sql);
			if(rs.next()) {
				userExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return userExist;
	}
	
	public static boolean isPasswordCorrect(String username, String password) {
		Boolean pwdCorrect = false;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DB.getConn();
			String sql = "select * from user where username = '" + username +"'";
			rs = DB.executeQuery(conn, sql);
			rs.next();
			if(rs.getString("password").equals(password)) {
				pwdCorrect = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return pwdCorrect;
	}
}
