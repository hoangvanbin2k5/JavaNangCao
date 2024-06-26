package Controllers;

import javax.swing.JOptionPane;

import DAO.DangKiDAO;
import Models.DangKi;
import View.ThemThongTinTK;
import View.XemThongTinTaiKhoan;

public class ThemThongTinTKController {
	private ThemThongTinTK view;
	private XemThongTinTaiKhoan parentView;
	
	public ThemThongTinTKController(ThemThongTinTK view, XemThongTinTaiKhoan parentView) {
		this.view = view;
		this.parentView = parentView;
		
		this.view.getBtnThem().addActionListener(e -> {
			String user = view.gettFUsername().getText();
			String gmail = view.gettFGmail().getText();
			String pass = view.gettFPassword().getText();
			String confirm = view.gettFPassword().getText();
			
			if (user.isEmpty() || gmail.isEmpty() || pass.isEmpty()) {
				JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
			}
			
			DangKi dangKi = new DangKi(user, gmail, pass, confirm);
			DangKiDAO.insert(dangKi);
			JOptionPane.showMessageDialog(view, "Đặt sân thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        view.dispose();
	        parentView.loadDataToTable();
		});
	}
	
	
}
