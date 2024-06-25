package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DangKiView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tFUser;
    private JTextField tFGmail;
    private JPasswordField pwFPassWord;
    private JPasswordField pwFConfirmPW;
    private JButton btnDangKy;
    private JButton btnDangNhap;

    public DangKiView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 549, 394);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(237, 236, 226));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbDKTK = new JLabel("Đăng kí tài khoản");
        lbDKTK.setFont(new Font("Gurmukhi Sangam MN", Font.BOLD, 17));
        lbDKTK.setBounds(212, 22, 152, 32);
        contentPane.add(lbDKTK);
        
        JLabel lbUser = new JLabel("Username:");
        lbUser.setBounds(70, 86, 104, 16);
        contentPane.add(lbUser);
        
        JLabel lbGmail = new JLabel("Gmail:");
        lbGmail.setBounds(70, 129, 61, 16);
        contentPane.add(lbGmail);
        
        JLabel lbPassWord = new JLabel("PassWord:");
        lbPassWord.setBounds(70, 172, 77, 16);
        contentPane.add(lbPassWord);
        
        JLabel lbConfirmPW = new JLabel("Cofirm Password:");
        lbConfirmPW.setBounds(70, 219, 129, 16);
        contentPane.add(lbConfirmPW);
        
        tFUser = new JTextField();
        tFUser.setBounds(227, 78, 205, 32);
        contentPane.add(tFUser);
        tFUser.setColumns(10);
        
        tFGmail = new JTextField();
        tFGmail.setColumns(10);
        tFGmail.setBounds(227, 121, 205, 32);
        contentPane.add(tFGmail);
        
        pwFPassWord = new JPasswordField();
        pwFPassWord.setBounds(227, 164, 203, 32);
        contentPane.add(pwFPassWord);
        
        pwFConfirmPW = new JPasswordField();
        pwFConfirmPW.setBounds(227, 211, 203, 32);
        contentPane.add(pwFConfirmPW);
        
        btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setBounds(96, 285, 117, 39);
        contentPane.add(btnDangNhap);
        
        btnDangKy = new JButton("Đăng Kí");
        btnDangKy.setBounds(281, 285, 117, 39);
        contentPane.add(btnDangKy);
    }

    // Getter cho tFUser
    public JTextField getTFUser() {
        return tFUser;
    }

    // Getter cho tFGmail
    public JTextField getTFGmail() {
        return tFGmail;
    }

    // Getter cho pwFPassWord
    public JPasswordField getPwFPassWord() {
        return pwFPassWord;
    }

    // Getter cho pwFConfirmPW
    public JPasswordField getPwFConfirmPW() {
        return pwFConfirmPW;
    }

    // Getter cho btnDangKy
    public JButton getBtnDangKy() {
        return btnDangKy;
    }

    // Getter cho btnDangNhap
    public JButton getBtnDangNhap() {
        return btnDangNhap;
    }
}
