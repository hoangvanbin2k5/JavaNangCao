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
                String maSP = resultSet.getString("Mã sản phẩm");
                String tenSP = resultSet.getString("Tên sản phẩm");
                float giaSP = resultSet.getFloat("Giá tiền");

                GiaCa giaCa = new GiaCa(maSP, tenSP, giaSP);
                giaCaList.add(giaCa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return giaCaList;
    }
}
