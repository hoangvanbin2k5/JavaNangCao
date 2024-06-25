package Controllers;

import View.DangNhapView;
import View.TrangChuSanBongKhachHang;
import View.XemLichSan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XemLichSanController {
    private XemLichSan view;

    public XemLichSanController(XemLichSan view) {
        this.view = view;

        view.getBtnThoat().addActionListener(e -> {
                TrangChuSanBongKhachHang trangChu = new TrangChuSanBongKhachHang();
                TrangChuSanBongKhachHangController controller = new TrangChuSanBongKhachHangController(trangChu);
                trangChu.setVisible(true);
                view.dispose();
        });

        view.getBtnDangXuat().addActionListener(e -> {
                DangNhapView dangNhap = new DangNhapView();
                DangNhapController controller = new DangNhapController(dangNhap);
                dangNhap.setVisible(true);
                view.dispose();
        });
    }
}
