package com.iteyedl.alipapa.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iteyedl.alipapa.util.DB;

public class User {
	
	private int id;
	private String username;
	private String password;
	private String password2;
	private String phone;
	private String addr;
	private Date rdate;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	
//	public void save() {
//		Connection conn = DB.getConn();
//		String sql = "insert into user values (null, ?, ?, ?, ?, ?)";
//		PreparedStatement pstmt = DB.getPStmt(conn, sql);
//		try {
//			pstmt.setString(1, username);
//			pstmt.setString(2, password);
//			pstmt.setString(3, phone);
//			pstmt.setString(4, addr);
//			pstmt.setTimestamp(5, new Timestamp(rdate.getTime()));
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DB.closeStmt(pstmt);
//		}
//	}
	
	
	
}
