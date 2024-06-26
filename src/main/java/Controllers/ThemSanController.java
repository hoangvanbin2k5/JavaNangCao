package Controllers;

import javax.swing.JOptionPane;

import DAO.LichSanDAO;
import Models.LichSan;
import View.ThemSan;
import View.XemLichSanChuSan;

public class ThemSanController {
	private ThemSan view;
	private XemLichSanChuSan parentView;
	
	public ThemSanController(ThemSan view, XemLichSanChuSan parentView) {
		this.view = view;
		this.parentView = parentView;
		
		this.view.getBtnThem().addActionListener(e -> {
			String hoVaTen = view.gettFHoVaTen().getText();
			String ngay = view.gettFNgay().getText();
			String thoiGianDa = view.gettFThoiGianBatDau().getText();
			String thoiGianKetThuc = view.gettFThoiGianKetThuc().getText();
			
			if (hoVaTen.isEmpty() || ngay.isEmpty() || thoiGianDa.isEmpty() || thoiGianKetThuc.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
			LichSan lichSan = new LichSan(hoVaTen, ngay, thoiGianDa, thoiGianKetThuc);
	        LichSanDAO.insertLichSan(lichSan);
	        JOptionPane.showMessageDialog(view, "Đặt sân thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        view.dispose();
	        parentView.loadDataToTable();
		});
		
		view.getBtnThoat().addActionListener(e -> {
			view.dispose();
		});
	}
}
