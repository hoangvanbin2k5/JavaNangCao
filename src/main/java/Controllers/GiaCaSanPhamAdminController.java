package Controllers;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.GiaCaDAO;
import Models.GiaCa;
import View.GiaCaSanPhamAdmin;
import View.TrangChuSanBongChuSan;
import java.util.List;

public class GiaCaSanPhamAdminController {
    private GiaCaSanPhamAdmin view;

    public GiaCaSanPhamAdminController(GiaCaSanPhamAdmin view) {
        this.view = view;

        loadDataToTable();

//        view.getBtnThemSanPham().addActionListener(e -> {
//            String maSP = JOptionPane.showInputDialog(view, "Nhập mã sản phẩm:");
//            String tenSP = JOptionPane.showInputDialog(view, "Nhập tên sản phẩm:");
//            String giaTienStr = JOptionPane.showInputDialog(view, "Nhập giá tiền:");
//
//            if (maSP == null || tenSP == null || giaTienStr == null || maSP.isEmpty() || tenSP.isEmpty() || giaTienStr.isEmpty()) {
//                JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            try {
//                double giaTien = Double.parseDouble(giaTienStr);
//                GiaCa giaCa = new GiaCa(maSP, tenSP, giaTien);
//                GiaCaDAO.insertGiaCa(giaCa);
//                loadDataToTable();
//                JOptionPane.showMessageDialog(view, "Thêm sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(view, "Giá tiền không hợp lệ.", "Thông báo", JOptionPane.ERROR_MESSAGE);
//            }
//        });

//        view.getBtnChinhSua().addActionListener(e -> {
//            int selectedRow = view.getTableSanPham().getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(view, "Vui lòng chọn một sản phẩm để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            String maSP = (String) view.getTableSanPham().getValueAt(selectedRow, 0);
//            String tenSP = JOptionPane.showInputDialog(view, "Nhập tên sản phẩm mới:", view.getTableSanPham().getValueAt(selectedRow, 1));
//            String giaTienStr = JOptionPane.showInputDialog(view, "Nhập giá tiền mới:", view.getTableSanPham().getValueAt(selectedRow, 2));
//
//            if (tenSP == null || giaTienStr == null || tenSP.isEmpty() || giaTienStr.isEmpty()) {
//                JOptionPane.showMessageDialog(view, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            try {
//                double giaTien = Double.parseDouble(giaTienStr);
//                GiaCa giaCa = new GiaCa(maSP, tenSP, giaTien);
//                GiaCaDAO.updateGiaCa(giaCa);
//                loadDataToTable();
//                JOptionPane.showMessageDialog(view, "Sửa thông tin sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(view, "Giá tiền không hợp lệ.", "Thông báo", JOptionPane.ERROR_MESSAGE);
//            }
//        });

        view.getBtnXoaSanPham().addActionListener(e -> {
            int selectedRow = view.getTableSanPham().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn một sản phẩm để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) view.getTableSanPham().getModel();
            String maSp = (String) model.getValueAt(selectedRow, 0);
            
            GiaCaDAO.deleteGiaCa(maSp);
            
            model.removeRow(selectedRow);
        });

        view.getBtnThoat().addActionListener(e -> {
            TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
            TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
            trangChu.setVisible(true);
            view.dispose();
        });
    }

    private void loadDataToTable() {
        List<GiaCa> giaCaList = GiaCaDAO.getAllGiaCa();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên sản phẩm");
        model.addColumn("Giá tiền");

        for (GiaCa giaCa : giaCaList) {
            Object[] row = new Object[3];
            row[0] = giaCa.getMaSP();
            row[1] = giaCa.getTenSP();
            row[2] = giaCa.getGiaTien();
            model.addRow(row);
        }

        view.getTableSanPham().setModel(model);
    }
}
