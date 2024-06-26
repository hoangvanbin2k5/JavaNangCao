package Until;

import java.util.Arrays;

public class TestMaHoa {

    public static void main(String[] args) {
        // Mật khẩu để mã hoá
        String password = "myPassword123";
        
        // Tạo salt mới
        String salt = MaHoa.generateSalt();

        // Mã hoá mật khẩu để lưu vào cơ sở dữ liệu
        String hashedPassword = MaHoa.maHoaMatKhau(password, salt);
        System.out.println("Mật khẩu đã mã hóa: " + hashedPassword);

        // Giả định rằng từ cơ sở dữ liệu, salt và mật khẩu đã mã hóa được lấy ra
        String retrievedHashedPassword = hashedPassword;
        String retrievedSalt = salt;

        // Giải mã mật khẩu và kiểm tra tính đúng đắn
        String decryptedPassword = MaHoa.maHoaMatKhau(password, retrievedSalt);
        System.out.println("Mật khẩu đã giải mã: " + decryptedPassword);

        // So sánh mật khẩu đã giải mã với mật khẩu ban đầu
        boolean passwordsMatch = Arrays.equals(hashedPassword.getBytes(), decryptedPassword.getBytes());
        System.out.println("Mật khẩu đã mã hóa và giải mã đúng đắn: " + passwordsMatch);
    }
}




