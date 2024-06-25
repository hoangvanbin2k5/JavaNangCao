package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import Models.DangKi;
import View.*;

public class DangKiDAO {
	static Connection conn = null;
	static PreparedStatement statement = null;
	
	static void openConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLiSanBong", "root", "mixigaming24");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void closeConnection() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insert(DangKi dangKi) {
		openConnection();
		
		String sql = "insert into TaiKhoanDangKi(USERNAME, GMAIL, PASSWORD, CONFIRM) value (?, ?, ?, ?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, dangKi.getUserName());
			statement.setString(2, dangKi.getEmail());
			statement.setString(3, dangKi.getPassWord());
			statement.setString(4, dangKi.getConfirmPW());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}
}
