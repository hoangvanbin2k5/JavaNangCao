package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFMaSP;
	private JTextField tFTenSP;
	private JTextField tFGiaCa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSanPham frame = new ThemSanPham();
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
	public ThemSanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbMaSP = new JLabel("Mã sản phẩm:");
		lbMaSP.setBounds(64, 39, 96, 16);
		contentPane.add(lbMaSP);
		
		JLabel lbTenSP = new JLabel("Tên sản phẩm:");
		lbTenSP.setBounds(64, 87, 96, 16);
		contentPane.add(lbTenSP);
		
		JLabel lbGiaTien = new JLabel("Giá tiền:");
		lbGiaTien.setBounds(64, 132, 61, 16);
		contentPane.add(lbGiaTien);
		
		tFMaSP = new JTextField();
		tFMaSP.setBounds(197, 34, 160, 26);
		contentPane.add(tFMaSP);
		tFMaSP.setColumns(10);
		
		tFTenSP = new JTextField();
		tFTenSP.setColumns(10);
		tFTenSP.setBounds(197, 82, 160, 26);
		contentPane.add(tFTenSP);
		
		tFGiaCa = new JTextField();
		tFGiaCa.setColumns(10);
		tFGiaCa.setBounds(197, 127, 160, 26);
		contentPane.add(tFGiaCa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(76, 178, 117, 42);
		contentPane.add(btnThem);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBounds(240, 178, 117, 42);
		contentPane.add(btnThoat);
	}

}
