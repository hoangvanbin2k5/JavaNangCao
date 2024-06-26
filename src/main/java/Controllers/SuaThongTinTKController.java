package Controllers;

import DAO.DangKiDAO;
import DAO.LichSanDAO;
import Models.DangKi;
import Models.LichSan;
import View.SuaThongTinTK;
import View.XemThongTinTaiKhoan;

public class SuaThongTinTKController {
	private SuaThongTinTK view;
	private XemThongTinTaiKhoan parentView;
	
	public SuaThongTinTKController(SuaThongTinTK view, XemThongTinTaiKhoan parentView) {
		this.view = view;
		this.parentView = parentView;
		

        this.view.getBtnSua().addActionListener(e -> {
                String user = view.gettFUsername().getText();
                String email = view.gettFGmail().getText();
                String pass = view.gettFPassword().getText();
                String confirm = view.gettFPassword().getText();

                DangKi dangKi = new DangKi(user, email, pass, confirm);
                DangKiDAO.updateDangKi(dangKi);
                
                parentView.loadDataToTable();
                view.dispose();
        });

        this.view.getBtnThoat().addActionListener(e -> 
        	view.dispose()
        );
	}
	
	
}
