package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.GiaCa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SuaSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFMaSP;
	private JTextField tFTenSP;
	private JTextField tFGiaCa;
	private JButton btnSua, btnThoat;

	public SuaSanPham() {
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
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(76, 178, 117, 42);
		contentPane.add(btnSua);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(240, 178, 117, 42);
		contentPane.add(btnThoat);
	}

	public SuaSanPham(GiaCa giaCa) {
		this();
		tFMaSP.setText(giaCa.getMaSP());
		tFTenSP.setText(giaCa.getTenSP());
		tFGiaCa.setText(String.valueOf(giaCa.getGiaTien()));
	}

	public JTextField gettFMaSP() {
		return tFMaSP;
	}

	public JTextField gettFTenSP() {
		return tFTenSP;
	}

	public JTextField gettFGiaCa() {
		return tFGiaCa;
	}

	public JButton getBtnSua() {
		return btnSua;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}
}

