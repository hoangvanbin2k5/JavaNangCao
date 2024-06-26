package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKi;

public class ThongTinTaiKhoanDAO {
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

    public static List<DangKi> getAllAccounts() {
        openConnection();

        String sql = "SELECT * FROM TaiKhoanDangKi";
        List<DangKi> accountList = new ArrayList<>();

        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("USERNAME");
                String gmail = resultSet.getString("GMAIL");
                String password = resultSet.getString("PASSWORD");
                String salt = resultSet.getString("Salt");

                DangKi account = new DangKi(username, gmail, password, salt);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return accountList;
    }
    
	public static void deleteDangKi(String user) {
        openConnection();

        String sql = "DELETE FROM TaiKhoanDangKi WHERE USERNAME = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}
