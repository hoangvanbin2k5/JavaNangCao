package Controllers;

import DAO.LichSanDAO;
import Models.LichSan;
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

        view.getBtnThoat().addActionListener(e -> {
                TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
                TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
                trangChu.setVisible(true);
                view.dispose();
        });
    }
    
    private void loadDataToTable() {
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
