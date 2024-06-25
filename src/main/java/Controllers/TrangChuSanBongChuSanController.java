package Controllers;

import View.DangNhapView;
import View.GiaCaSanPhamAdmin;
import View.ThongTinKhachHang;
import View.XemLichSanChuSan;
import View.XemThongTinTaiKhoan;
import View.TrangChuSanBongChuSan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangChuSanBongChuSanController {
    private TrangChuSanBongChuSan view;

    public TrangChuSanBongChuSanController(TrangChuSanBongChuSan view) {
        this.view = view;

        view.getBtnThongTinSan().addActionListener(e -> {
                XemLichSanChuSan xemSan = new XemLichSanChuSan();
                XemLichSanChuSanController controller = new XemLichSanChuSanController(xemSan);
                xemSan.setVisible(true);
                view.dispose();
        });
        

        view.getBtnXemThongTinTaiKhoan().addActionListener(e -> {
                XemThongTinTaiKhoan xemThongTinTK = new XemThongTinTaiKhoan();
                XemThongTinTaiKhoanController controller = new XemThongTinTaiKhoanController(xemThongTinTK);
                xemThongTinTK.setVisible(true);
                view.dispose();
        });

        view.getBtnXemDichVu().addActionListener(e -> {
                GiaCaSanPhamAdmin giaCa = new GiaCaSanPhamAdmin();
                GiaCaSanPhamAdminController controller = new GiaCaSanPhamAdminController(giaCa);
                giaCa.setVisible(true);
                view.dispose();
        });

        view.getBtnDangXuat().addActionListener(e -> {
                DangNhapView dangNhap = new DangNhapView();
                DangNhapController controller = new DangNhapController(dangNhap);
                dangNhap.setVisible(true);
                view.dispose();
        });

        view.getBtnXemThongTinKhachHang().addActionListener(e -> {
                ThongTinKhachHang thongTinKH = new ThongTinKhachHang();
                ThongTinKhachHangController controller = new ThongTinKhachHangController(thongTinKH);
                thongTinKH.setVisible(true);
                view.dispose();
        });
    }
}
