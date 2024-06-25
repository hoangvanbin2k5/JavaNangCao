package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;

public class TrangChuSanBongKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThongTinSan;
	private JButton btnDatSan;
	private JButton btnXemDichVu;
	private JButton btnDangXuat;

	public TrangChuSanBongKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Nh\u1EA5n \u0111\u1EC3 xem th\u00F4ng tin", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 45, 413, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnThongTinSan = new JButton("Xem Lịch Sân");
		btnThongTinSan.setBounds(61, 42, 117, 34);
		panel.add(btnThongTinSan);
		
		btnDatSan = new JButton("Đặt Sân");
		btnDatSan.setBounds(61, 88, 117, 34);
		panel.add(btnDatSan);
		
		btnXemDichVu = new JButton("Giá Cả Sản Phẩm");
		btnXemDichVu.setBounds(261, 42, 117, 34);
		panel.add(btnXemDichVu);
		
		btnDangXuat = new JButton("Đăng Xuất");
		btnDangXuat.setBounds(261, 88, 117, 34);
		panel.add(btnDangXuat);
		
		JLabel lbHoangTra = new JLabel("Sân Bóng Hoàng Trà");
		lbHoangTra.setBounds(170, 6, 143, 16);
		contentPane.add(lbHoangTra);
	}

	public JButton getBtnThongTinSan() {
		return btnThongTinSan;
	}

	public JButton getBtnDatSan() {
		return btnDatSan;
	}

	public JButton getBtnXemDichVu() {
		return btnXemDichVu;
	}

	public JButton getBtnDangXuat() {
		return btnDangXuat;
	}
}
