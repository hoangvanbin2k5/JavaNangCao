package Controllers;

import DAO.GiaCaDAO;
import Models.GiaCa;
import View.GiaCaSanPhamAdmin;
import View.SuaSanPham;

public class SuaSanPhamController {
	private SuaSanPham view;
	private GiaCaSanPhamAdmin parentView;
	
	public SuaSanPhamController(SuaSanPham view, GiaCaSanPhamAdmin parentView) {
		this.view = view;
		this.parentView = parentView;
		
		this.view.getBtnSua().addActionListener(e -> {
			String maSP = view.gettFMaSP().getText();
			String tenSP = view.gettFTenSP().getText();
			String giaTien = view.gettFGiaCa().getText();
			float giaTienFloat = Float.parseFloat(giaTien);
			
			GiaCa giaCa = new GiaCa(maSP, tenSP, giaTienFloat);
			GiaCaDAO.updateGiaCa(giaCa);
			
			parentView.loadDataToTable();
			view.dispose();
		});
		
		this.view.getBtnThoat().addActionListener(e -> 
    		view.dispose()
		);
	}
	
	
}
