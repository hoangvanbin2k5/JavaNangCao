package Controllers;

import DAO.LichSanDAO;
import Models.LichSan;
import View.SuaSan;
import View.ThemSan;
import View.TrangChuSanBongChuSan;
import View.XemLichSanChuSan;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class XemLichSanChuSanController {
    private XemLichSanChuSan view;

    public XemLichSanChuSanController(XemLichSanChuSan view) {
        this.view = view;
        
        loadDataToTable();

        view.getBtnXoaSan().addActionListener(e -> {
            int selectedRow = view.getTableLichSan().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng để xoá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) view.getTableLichSan().getModel();
            String hoVaTen = (String) model.getValueAt(selectedRow, 0); 

            LichSanDAO.deleteLichSan(hoVaTen);

            model.removeRow(selectedRow);
        });
        
        view.getBtnThem().addActionListener(e -> {
            ThemSan themSan = new ThemSan();
            ThemSanController controller = new ThemSanController(themSan, view);
            themSan.setVisible(true);
            loadDataToTable();
        });
        
        view.getBtnChinhSua().addActionListener(e -> {
            int selectedRow = view.getTableLichSan().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng để chỉnh sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            DefaultTableModel model = (DefaultTableModel) view.getTableLichSan().getModel();
            String hoVaTen = (String) model.getValueAt(selectedRow, 0); 
            String ngay = (String) model.getValueAt(selectedRow, 1);
            String tgBatDau = (String) model.getValueAt(selectedRow, 2);
            String tgKetThuc = (String) model.getValueAt(selectedRow, 3);

            LichSan lichSan = new LichSan(hoVaTen, ngay, tgBatDau, tgKetThuc);
            SuaSan suaSanView = new SuaSan(lichSan);
            SuaSanController suaSanController = new SuaSanController(suaSanView, view);
            suaSanView.setVisible(true);
        });

        view.getBtnThoat().addActionListener(e -> {
            TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
            TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
            trangChu.setVisible(true);
            view.dispose();
        });
        
        loadDataToTable();
    }
    
    public void loadDataToTable() {
        List<LichSan> lichSanList = LichSanDAO.getAllLichSan();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Họ Và Tên");
        model.addColumn("Ngày");
        model.addColumn("Thời gian bắt đầu");
        model.addColumn("Thời gian kết thúc");

        for (LichSan i : lichSanList) {
            Object[] row = new Object[4];
            row[0] = i.getHoVaTen();
            row[1] = i.getNgay();
            row[2] = i.getThoiGianDa();
            row[3] = i.getThoiGianKetThuc();
            model.addRow(row);
        }
        
        view.getTableLichSan().setModel(model);
    }
}
