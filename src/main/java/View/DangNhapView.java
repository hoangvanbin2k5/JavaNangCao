package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.DangNhapController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DangNhapView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tFUserName;
    private JPasswordField pwFPassWord;
    private JButton btnDangNhap;
    private JButton btnDangKi;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DangNhapView frame = new DangNhapView();
                    DangNhapController controller = new DangNhapController(frame);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DangNhapView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbDangNhap = new JLabel("Đăng Nhập");
        lbDangNhap.setBounds(202, 31, 85, 23);
        contentPane.add(lbDangNhap);

        JLabel lbUserName = new JLabel("Username:");
        lbUserName.setBounds(81, 86, 85, 16);
        contentPane.add(lbUserName);

        JLabel lbPassWord = new JLabel("Password:");
        lbPassWord.setBounds(81, 134, 71, 16);
        contentPane.add(lbPassWord);

        tFUserName = new JTextField();
        tFUserName.setBounds(192, 84, 164, 23);
        contentPane.add(tFUserName);
        tFUserName.setColumns(10);

        pwFPassWord = new JPasswordField();
        pwFPassWord.setBounds(192, 123, 164, 32);
        contentPane.add(pwFPassWord);

        btnDangKi = new JButton("Đăng Kí");
        btnDangKi.setBounds(109, 203, 117, 41);
        contentPane.add(btnDangKi);

        btnDangNhap = new JButton("Đăng Nhập");
        btnDangNhap.setBounds(273, 203, 117, 41);
        contentPane.add(btnDangNhap);
    }

    public JTextField getTFUserName() {
        return tFUserName;
    }

    public JPasswordField getPwFPassWord() {
        return pwFPassWord;
    }

    public JButton getBtnDangNhap() {
        return btnDangNhap;
    }

    public JButton getBtnDangKi() {
        return btnDangKi;
    }
}
