package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKi;
import Models.KhachHang;

public class ThongTinKhachHangDAO {
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
    
    public static List<KhachHang> getAllKhachHang() {
        openConnection();

        String sql = "SELECT * FROM ThongTinKhachHang";
        List<KhachHang> KHList = new ArrayList<>();

        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maKH = resultSet.getString("maKH");
                String tenKH = resultSet.getString("tenKh");
                String diaChi = resultSet.getString("daiChi");

                KhachHang khachHang = new KhachHang(maKH, tenKH, diaChi);
                
                KHList.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return KHList;
    }
}
