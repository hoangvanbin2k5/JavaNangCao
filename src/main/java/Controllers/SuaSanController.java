package Controllers;

import DAO.LichSanDAO;
import Models.LichSan;
import View.SuaSan;
import View.XemLichSanChuSan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuaSanController {
    private SuaSan view;
    private XemLichSanChuSan parentView;

    public SuaSanController(SuaSan view, XemLichSanChuSan parentView) {
        this.view = view;
        this.parentView = parentView;

        this.view.getBtnSua().addActionListener(e -> {
                String hoVaTen = view.getTFHoVaTen().getText();
                String ngay = view.getTFNgay().getText();
                String tgBatDau = view.getTFThoiGianBatDau().getText();
                String tgKetThuc = view.getTFThoiGianKetThuc().getText();

                LichSan lichSan = new LichSan(hoVaTen, ngay, tgBatDau, tgKetThuc);
                LichSanDAO.updateLichSan(lichSan);

                parentView.loadDataToTable();
                view.dispose();
        });

        this.view.getBtnThoat().addActionListener(e -> 
        	view.dispose()
        );
    }
}
