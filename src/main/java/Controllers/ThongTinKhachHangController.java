package Controllers;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ThongTinKhachHangDAO;
import DAO.ThongTinTaiKhoanDAO;
import Models.KhachHang;
import View.ThongTinKhachHang;
import View.TrangChuSanBongChuSan;
import java.util.List;

public class ThongTinKhachHangController {
    private ThongTinKhachHang view;

    public ThongTinKhachHangController(ThongTinKhachHang view) {
        this.view = view;

        loadDataToTable();

//        view.getBtnKH().addActionListener(e -> {
//            String maKH = JOptionPane.showInputDialog(view, "Nhập mã khách hàng:");
//            String tenKH = JOptionPane.showInputDialog(view, "Nhập tên khách hàng:");
//            String diaChi = JOptionPane.showInputDialog(view, "Nhập địa chỉ:");
//
//            if (maKH == null || tenKH == null || diaChi == null || maKH.isEmpty() || tenKH.isEmpty() || diaChi.isEmpty()) {
//                JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            KhachHang khachHang = new KhachHang(maKH, tenKH, diaChi);
//            KhachHangDAO.insertKhachHang(khachHang);
//            loadDataToTable();
//            JOptionPane.showMessageDialog(view, "Thêm khách hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        });

//        view.getBtnChinhSua().addActionListener(e -> {
//            int selectedRow = view.getTable().getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(view, "Vui lòng chọn một khách hàng để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            String maKH = (String) view.getTable().getValueAt(selectedRow, 0);
//            String tenKH = JOptionPane.showInputDialog(view, "Nhập tên khách hàng mới:", view.getTable().getValueAt(selectedRow, 1));
//            String diaChi = JOptionPane.showInputDialog(view, "Nhập địa chỉ mới:", view.getTable().getValueAt(selectedRow, 2));
//
//            if (tenKH == null || diaChi == null || tenKH.isEmpty() || diaChi.isEmpty()) {
//                JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            KhachHang khachHang = new KhachHang(maKH, tenKH, diaChi);
//            KhachHangDAO.updateKhachHang(khachHang);
//            loadDataToTable();
//            JOptionPane.showMessageDialog(view, "Sửa thông tin khách hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//        });

//        view.getBtnXoaKH().addActionListener(e -> {
//            int selectedRow = view.getTable().getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(view, "Vui lòng chọn một khách hàng để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            String maKH = (String) view.getTable().getValueAt(selectedRow, 0);
//            int confirm = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xoá khách hàng này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
//            if (confirm == JOptionPane.YES_OPTION) {
//                KhachHangDAO.deleteKhachHang(maKH);
//                loadDataToTable();
//                JOptionPane.showMessageDialog(view, "Xoá khách hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            }
//        });

        view.getBtnThoat().addActionListener(e -> {
            TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
            TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
            trangChu.setVisible(true);
            view.dispose();
        });
    }

    private void loadDataToTable() {
        List<KhachHang> khachHangList = ThongTinKhachHangDAO.getAllKhachHang();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã khách hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Địa chỉ");

        for (KhachHang khachHang : khachHangList) {
            Object[] row = new Object[3];
            row[0] = khachHang.getMaKh();
            row[1] = khachHang.getTenKh();
            row[2] = khachHang.getDiaChi();
            model.addRow(row);
        }

        view.getTable().setModel(model);
    }
}
