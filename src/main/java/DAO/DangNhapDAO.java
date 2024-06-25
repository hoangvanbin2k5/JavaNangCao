package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.DangNhap;

public class DangNhapDAO {
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
	
	public static boolean checkLogin(DangNhap dangNhap) {
        openConnection();

        String sql = "SELECT * FROM TaiKhoanDangKi WHERE USERNAME = ? AND PASSWORD = ?";
        boolean isValid = false;

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, dangNhap.getUsername());
            statement.setString(2, dangNhap.getPassword());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return isValid;
    }
}
