package DAO;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import Models.DangKi;
import Until.MaHoa;
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
		
		
		String salt = MaHoa.generateSalt();
		String hashedPassword = MaHoa.maHoaMatKhau(dangKi.getPassWord(), salt);
        dangKi.setSalt(salt);
        dangKi.setPassWord(hashedPassword);
        
		String sql = "insert into TaiKhoanDangKi(USERNAME, GMAIL, PASSWORD, Salt) value (?, ?, ?, ?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, dangKi.getUserName());
			statement.setString(2, dangKi.getEmail());
			statement.setString(3, dangKi.getPassWord());
			statement.setString(4, dangKi.getSalt());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public static void updateDangKi(DangKi dangKi) {
		openConnection();
		
		String salt = MaHoa.generateSalt();
        String hashedPassword = MaHoa.maHoaMatKhau(dangKi.getPassWord(), salt);
        dangKi.setSalt(salt);
        dangKi.setPassWord(hashedPassword);
		
		String sql = "UPDATE TaiKhoanDangKi SET GMAIL = ?, PASSWORD = ?, Salt = ? WHERE USERNAME = ?";
		
		try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, dangKi.getEmail());
            statement.setString(2, dangKi.getPassWord());
            statement.setString(3, dangKi.getSalt());
            statement.setString(4, dangKi.getUserName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
	}
}
