package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class TrangChuSanBongChuSan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThongTinSan;
	private JButton btnXemThongTinTaiKhoan;
	private JButton btnXemDichVu;
	private JButton btnDangXuat;
	private JButton btnXemThongTinKhachHang;
	
	public TrangChuSanBongChuSan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbHoangTra = new JLabel("Sân Bóng Hoàng Trà");
		lbHoangTra.setBounds(195, 16, 143, 16);
		contentPane.add(lbHoangTra);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Nh\u1EA5n \u0111\u1EC3 xem th\u00F4ng tin", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(54, 57, 413, 210);
		contentPane.add(panel);
		
		btnThongTinSan = new JButton("Xem Lịch Sân");
		btnThongTinSan.setBounds(61, 42, 117, 34);
		panel.add(btnThongTinSan);
		
		btnXemThongTinTaiKhoan = new JButton("Thông Tin Tài Khoản");
		btnXemThongTinTaiKhoan.setBounds(43, 88, 154, 34);
		panel.add(btnXemThongTinTaiKhoan);
		
		btnXemDichVu = new JButton("Giá Cả Sản Phẩm");
		btnXemDichVu.setBounds(248, 42, 117, 34);
		panel.add(btnXemDichVu);
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBounds(248, 88, 117, 34);
		panel.add(btnDangXuat);
		
		btnXemThongTinKhachHang = new JButton("Thông Tin Khách Hàng");
		btnXemThongTinKhachHang.setBounds(43, 137, 154, 34);
		panel.add(btnXemThongTinKhachHang);
	}

	public JButton getBtnThongTinSan() {
		return btnThongTinSan;
	}

	public JButton getBtnXemThongTinTaiKhoan() {
		return btnXemThongTinTaiKhoan;
	}

	public JButton getBtnXemDichVu() {
		return btnXemDichVu;
	}

	public JButton getBtnDangXuat() {
		return btnDangXuat;
	}

	public JButton getBtnXemThongTinKhachHang() {
		return btnXemThongTinKhachHang;
	}
}
