package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemThongTinTK extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFUsername;
	private JTextField tFGmail;
	private JTextField tFPassword;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemThongTinTK frame = new ThemThongTinTK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThemThongTinTK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbUsername = new JLabel("Username:");
		lbUsername.setBounds(63, 36, 85, 16);
		contentPane.add(lbUsername);
		
		JLabel lblGmail = new JLabel("Gmail:");
		lblGmail.setBounds(63, 84, 61, 16);
		contentPane.add(lblGmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(63, 131, 85, 16);
		contentPane.add(lblPassword);
		
		tFUsername = new JTextField();
		tFUsername.setBounds(181, 31, 170, 26);
		contentPane.add(tFUsername);
		tFUsername.setColumns(10);
		
		tFGmail = new JTextField();
		tFGmail.setColumns(10);
		tFGmail.setBounds(181, 79, 170, 26);
		contentPane.add(tFGmail);
		
		tFPassword = new JTextField();
		tFPassword.setColumns(10);
		tFPassword.setBounds(181, 126, 170, 26);
		contentPane.add(tFPassword);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(76, 187, 117, 39);
		contentPane.add(btnThem);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(234, 187, 117, 39);
		contentPane.add(btnThoat);
	}

}

