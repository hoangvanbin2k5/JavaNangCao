package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import Models.DangNhap;
import Until.MaHoa;

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

        String sql = "SELECT PASSWORD, SALT FROM TaiKhoanDangKi WHERE USERNAME = ?";
        boolean isValid = false;

        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, dangNhap.getUsername());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("PASSWORD");
                String storedSalt = resultSet.getString("SALT");

                // Mã hóa mật khẩu người dùng với salt lấy từ cơ sở dữ liệu
                String hashedPassword = MaHoa.maHoaMatKhau(dangNhap.getPassword(), storedSalt);

                // So sánh mật khẩu đã lưu và mật khẩu đã mã hóa từ người dùng
                boolean passwordsMatch = Arrays.equals(storedPassword.getBytes(), hashedPassword.getBytes());
                
                if (passwordsMatch) {
                    isValid = true;
                }
            } else {
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return isValid;
    }

}
