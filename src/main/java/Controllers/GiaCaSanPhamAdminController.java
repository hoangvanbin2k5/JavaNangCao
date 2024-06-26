package Controllers;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.GiaCaDAO;
import Models.GiaCa;
import View.GiaCaSanPhamAdmin;
import View.SuaSanPham;
import View.ThemSan;
import View.ThemSanPham;
import View.TrangChuSanBongChuSan;
import java.util.List;

public class GiaCaSanPhamAdminController {
    private GiaCaSanPhamAdmin view;

    public GiaCaSanPhamAdminController(GiaCaSanPhamAdmin view) {
        this.view = view;

        loadDataToTable();

        view.getBtnThemSanPham().addActionListener(e -> {
           ThemSanPham themSanPham = new ThemSanPham();
           ThemSanPhamController controller = new ThemSanPhamController(themSanPham, view);
           themSanPham.setVisible(true);
           loadDataToTable();
        });

        view.getBtnChinhSua().addActionListener(e -> {
            int selectedRow = view.getTableSanPham().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn một sản phẩm để sửa.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            DefaultTableModel model = (DefaultTableModel) view.getTableSanPham().getModel();
            String maSP = (String) model.getValueAt(selectedRow, 0);
            String tenSP = (String) model.getValueAt(selectedRow, 1);
            float giaTien = (float) model.getValueAt(selectedRow, 2);
            
            GiaCa giaCa = new GiaCa(maSP, tenSP, giaTien);
            SuaSanPham suaSPView = new SuaSanPham(giaCa);
            SuaSanPhamController controller = new SuaSanPhamController(suaSPView, view);
            suaSPView.setVisible(true);
        });

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
