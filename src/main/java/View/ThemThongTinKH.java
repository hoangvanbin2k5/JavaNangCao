package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemThongTinKH extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFMaKH;
	private JTextField tFHoVaTen;
	private JTextField tFDiaChi;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemThongTinKH frame = new ThemThongTinKH();
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
	public ThemThongTinKH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMaKH = new JLabel("Mã Khách Hàng:");
		lbMaKH.setBounds(68, 41, 108, 16);
		contentPane.add(lbMaKH);
		
		JLabel lbHoVaTen = new JLabel("Họ Và Tên: ");
		lbHoVaTen.setBounds(68, 84, 108, 16);
		contentPane.add(lbHoVaTen);
		
		JLabel lbDiaChi = new JLabel("Địa Chỉ:");
		lbDiaChi.setBounds(68, 128, 61, 16);
		contentPane.add(lbDiaChi);
		
		tFMaKH = new JTextField();
		tFMaKH.setBounds(210, 36, 152, 26);
		contentPane.add(tFMaKH);
		tFMaKH.setColumns(10);
		
		tFHoVaTen = new JTextField();
		tFHoVaTen.setColumns(10);
		tFHoVaTen.setBounds(210, 79, 152, 26);
		contentPane.add(tFHoVaTen);
		
		tFDiaChi = new JTextField();
		tFDiaChi.setColumns(10);
		tFDiaChi.setBounds(210, 123, 152, 26);
		contentPane.add(tFDiaChi);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(83, 174, 117, 40);
		contentPane.add(btnThem);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(245, 174, 117, 40);
		contentPane.add(btnThoat);
	}

}
