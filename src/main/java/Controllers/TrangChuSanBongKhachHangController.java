package Controllers;

import View.DangNhapView;
import View.GiaCaView;
import View.XemLichSan;
import View.DatSan;
import View.TrangChuSanBongKhachHang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangChuSanBongKhachHangController {
    private TrangChuSanBongKhachHang view;

    public TrangChuSanBongKhachHangController(TrangChuSanBongKhachHang view) {
        this.view = view;

        view.getBtnThongTinSan().addActionListener(e -> {
                XemLichSan xemLichSan = new XemLichSan();
                XemLichSanController controller = new XemLichSanController(xemLichSan);
                xemLichSan.setVisible(true);
                view.dispose();
        });

        view.getBtnDatSan().addActionListener(e -> {
                DatSan datSan = new DatSan();
                DatSanController controller = new DatSanController(datSan);
                datSan.setVisible(true);
                view.dispose();
        });

        view.getBtnXemDichVu().addActionListener(e -> {
                GiaCaView giaCa = new GiaCaView();
                GiaCaViewController controller = new GiaCaViewController(giaCa);
                giaCa.setVisible(true);
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
