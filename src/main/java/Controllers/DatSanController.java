package Controllers;

import javax.swing.JOptionPane;
import DAO.LichSanDAO;
import Models.LichSan;
import View.DatSan;
import View.TrangChuSanBongKhachHang;

public class DatSanController {
    private DatSan view;

    public DatSanController(DatSan view) {
        this.view = view;

        view.getBtnDatSan().addActionListener(e -> {
            int thongBao = JOptionPane.showConfirmDialog(view, "Bạn có muốn đặt sân?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (thongBao != JOptionPane.YES_OPTION) {
                return;
            }

            String hoVaTen = view.getTFHoVaTen().getText();
            String ngayMuonDat = view.getTFNgayDat().getText();
            String thoiGianDa = view.getTFThoiGianDa().getText();
            String thoiGianKetThuc = view.getTFThoiGianKetThuc().getText();

            if (hoVaTen.isEmpty() || ngayMuonDat.isEmpty() || thoiGianDa.isEmpty() || thoiGianKetThuc.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            LichSan lichSan = new LichSan(hoVaTen, ngayMuonDat, thoiGianDa, thoiGianKetThuc);
            LichSanDAO.insertLichSan(lichSan);

            JOptionPane.showMessageDialog(view, "Đặt sân thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        });

        view.getBtnThoat().addActionListener(e -> {
            TrangChuSanBongKhachHang trangChuKH = new TrangChuSanBongKhachHang();
            TrangChuSanBongKhachHangController controller = new TrangChuSanBongKhachHangController(trangChuKH);
            trangChuKH.setVisible(true);
            view.dispose();
        });
    }
}
