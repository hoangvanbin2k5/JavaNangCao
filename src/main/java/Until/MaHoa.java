package Until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class MaHoa {
    public static String maHoaMatKhau(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwordWithSalt = password + salt;
            md.update(passwordWithSalt.getBytes());
            byte[] byteData = md.digest();
            String hashedPassword = Base64.getEncoder().encodeToString(byteData);
            
            return hashedPassword;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
