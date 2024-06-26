package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemSan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFHoVaTen;
	private JTextField tFNgay;
	private JTextField tFThoiGianBatDau;
	private JTextField tFThoiGianKetThuc;
	private JButton btnThem, btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemSan frame = new ThemSan();
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
	public ThemSan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHoVaTen = new JLabel("Họ Và Tên: ");
		lbHoVaTen.setBounds(56, 30, 87, 16);
		contentPane.add(lbHoVaTen);
		
		JLabel lbNgay = new JLabel("Ngày:");
		lbNgay.setBounds(56, 71, 61, 16);
		contentPane.add(lbNgay);
		
		JLabel lbThoiGianBatDau = new JLabel("Thời gian bắt đầu:");
		lbThoiGianBatDau.setBounds(57, 114, 122, 16);
		contentPane.add(lbThoiGianBatDau);
		
		JLabel lbThoiGianKetThuc = new JLabel("Thời gian kết thúc:");
		lbThoiGianKetThuc.setBounds(56, 155, 123, 16);
		contentPane.add(lbThoiGianKetThuc);
		
		tFHoVaTen = new JTextField();
		tFHoVaTen.setBounds(222, 25, 159, 26);
		contentPane.add(tFHoVaTen);
		tFHoVaTen.setColumns(10);
		
		tFNgay = new JTextField();
		tFNgay.setColumns(10);
		tFNgay.setBounds(222, 66, 159, 26);
		contentPane.add(tFNgay);
		
		tFThoiGianBatDau = new JTextField();
		tFThoiGianBatDau.setColumns(10);
		tFThoiGianBatDau.setBounds(222, 109, 159, 26);
		contentPane.add(tFThoiGianBatDau);
		
		tFThoiGianKetThuc = new JTextField();
		tFThoiGianKetThuc.setColumns(10);
		tFThoiGianKetThuc.setBounds(222, 150, 159, 26);
		contentPane.add(tFThoiGianKetThuc);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(84, 207, 117, 40);
		contentPane.add(btnThem);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(255, 207, 117, 40);
		contentPane.add(btnThoat);
		
		
	}

	public JButton getBtnThem() {
		return btnThem;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public JTextField gettFHoVaTen() {
		return tFHoVaTen;
	}

	public JTextField gettFNgay() {
		return tFNgay;
	}

	public JTextField gettFThoiGianBatDau() {
		return tFThoiGianBatDau;
	}

	public JTextField gettFThoiGianKetThuc() {
		return tFThoiGianKetThuc;
	}
}
