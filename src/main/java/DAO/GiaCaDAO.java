package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DangKi;
import Models.GiaCa;

public class GiaCaDAO {
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

    public static List<GiaCa> getAllGiaCa() {
        openConnection();

        String sql = "SELECT * FROM GiaCaDichVu";
        List<GiaCa> giaCaList = new ArrayList<>();

        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maSP = resultSet.getString("MaSP");
                String tenSP = resultSet.getString("TenSP");
                float giaSP = resultSet.getFloat("GiaTien");

                GiaCa giaCa = new GiaCa(maSP, tenSP, giaSP);
                giaCaList.add(giaCa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return giaCaList;
    }
    
    public static void deleteGiaCa(String MaSp) {
    	openConnection();
    	
    	String sql = "DELETE FROM GiaCaDichVu WHERE MaSP = ?";
    	try {
    		statement = conn.prepareStatement(sql);
    		statement.setString(1, MaSp);
    		statement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    	closeConnection();
    }
    
    public static void insertGiaCa(GiaCa giaCa) {
    	openConnection();
    	
    	String sql = "INSERT INTO GiaCaDichVu (MaSp, TenSP, GiaTien) VALUES (?, ?, ?)";
    	
    	try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, giaCa.getMaSP());
            statement.setString(2, giaCa.getTenSP());
            statement.setFloat(3, giaCa.getGiaTien());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
    
    public static void updateGiaCa(GiaCa giaCa) {
    	openConnection();
    	
    	String sql = "UPDATE GiaCaDichVu SET TenSP = ?, GiaTien = ? WHERE MaSP = ?";
    	
    	try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, giaCa.getTenSP());
            statement.setFloat(2, giaCa.getGiaTien());
            statement.setString(3, giaCa.getMaSP());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}
