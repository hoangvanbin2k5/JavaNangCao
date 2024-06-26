package Controllers;

import javax.swing.JOptionPane;

import DAO.GiaCaDAO;
import DAO.LichSanDAO;
import Models.GiaCa;
import Models.LichSan;
import View.GiaCaSanPhamAdmin;
import View.ThemSanPham;

public class ThemSanPhamController {
	private ThemSanPham view;
	private GiaCaSanPhamAdmin parentView;
	
	public ThemSanPhamController(ThemSanPham view, GiaCaSanPhamAdmin parentView) {
		this.view = view;
		this.parentView = parentView;
		
		this.view.getBtnThem().addActionListener(e -> {
			String MaSP = view.gettFMaSP().getText();
			String TenSp = view.gettFTenSP().getText();
			String GiaTien = view.gettFGiaCa().getText();
			float giaTienFloat = Float.parseFloat(GiaTien);
			
			if (MaSP.isEmpty() || TenSp.isEmpty() || GiaTien.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
			GiaCa giaCa = new GiaCa(MaSP, TenSp, giaTienFloat);
	        GiaCaDAO.insertGiaCa(giaCa);
	        JOptionPane.showMessageDialog(view, "Thêm sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        view.dispose();
	        parentView.loadDataToTable();
		});
		
		view.getBtnThoat().addActionListener(e -> {
			view.dispose();
		});
	}
}
