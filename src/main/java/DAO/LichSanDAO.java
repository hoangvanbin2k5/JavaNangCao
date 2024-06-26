package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.LichSan;

public class LichSanDAO {
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
    
    public static List<LichSan> getAllLichSan() {
        openConnection();

        String sql = "SELECT * FROM LichSan";
        List<LichSan> lichSanList = new ArrayList<>();

        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String hoVaTen = resultSet.getString("HoVaTen");
                String ngay = resultSet.getString("Ngay");
                String tgBatDau = resultSet.getString("ThoiGianDa");
                String tgKetThuc = resultSet.getString("ThoiGianKetThuc");

                LichSan lichSan = new LichSan(hoVaTen, ngay, tgBatDau, tgKetThuc);
                lichSanList.add(lichSan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return lichSanList;
    }
    
    public static void insertLichSan(LichSan lichSan) {
        openConnection();

        String sql = "INSERT INTO LichSan (HoVaTen, Ngay, ThoiGianDa, ThoiGianKetThuc) VALUES (?, ?, ?, ?)";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, lichSan.getHoVaTen());
            statement.setString(2, lichSan.getNgay());
            statement.setString(3, lichSan.getThoiGianDa());
            statement.setString(4, lichSan.getThoiGianKetThuc());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
    
    public static void deleteLichSan(String hoVaTen) {
        openConnection();

        String sql = "DELETE FROM LichSan WHERE HoVaTen = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, hoVaTen);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
    
    public static void updateLichSan(LichSan lichSan) {
        openConnection();

        String sql = "UPDATE LichSan SET Ngay = ?, ThoiGianDa = ?, ThoiGianKetThuc = ? WHERE HoVaTen = ?";

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, lichSan.getNgay());
            statement.setString(2, lichSan.getThoiGianDa());
            statement.setString(3, lichSan.getThoiGianKetThuc());
            statement.setString(4, lichSan.getHoVaTen());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}
