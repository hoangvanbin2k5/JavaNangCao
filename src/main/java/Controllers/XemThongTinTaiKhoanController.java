package Controllers;

import View.TrangChuSanBongChuSan;
import View.XemThongTinTaiKhoan;
import DAO.ThongTinTaiKhoanDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.DangKi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class XemThongTinTaiKhoanController {
    private XemThongTinTaiKhoan view;

    public XemThongTinTaiKhoanController(XemThongTinTaiKhoan view) {
        this.view = view;
        
        loadDataToTable();

        view.getBtnThemTK().addActionListener(e -> {
   
        });

        view.getBtnChinhSua().addActionListener(e -> {
                int selectedRow = view.getTableThongTin().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng để sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DefaultTableModel model = (DefaultTableModel) view.getTableThongTin().getModel();
                String username = (String) model.getValueAt(selectedRow, 1);
                String gmail = (String) model.getValueAt(selectedRow, 2);
                String password = (String) model.getValueAt(selectedRow, 3);
                String confirmPassword = (String) model.getValueAt(selectedRow, 4);
        });

//        view.getBtnXoa().addActionListener(e -> {
//                int selectedRow = view.getTableThongTin().getSelectedRow();
//                if (selectedRow == -1) {
//                    JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng để xoá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//
//                DefaultTableModel model = (DefaultTableModel) view.getTableThongTin().getModel();
//                String username = (String) model.getValueAt(selectedRow, 1);
//
//                ThongTinTaiKhoanDAO.deleteAccount(username);
//
//                model.removeRow(selectedRow);
//        });

        view.getBtnThoat().addActionListener(e -> {
                TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
                TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
                trangChu.setVisible(true);
                view.dispose();
        });
    }
    
    private void loadDataToTable() {
        List<DangKi> accountList = ThongTinTaiKhoanDAO.getAllAccounts();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("STT");
        model.addColumn("Username");
        model.addColumn("Gmail");
        model.addColumn("Password");
        model.addColumn("Confirm Password");

        int stt = 1;
        for (DangKi account : accountList) {
            Object[] row = new Object[5];
            row[0] = stt++;
            row[1] = account.getUserName();
            row[2] = account.getEmail();
            row[3] = account.getPassWord();
            row[4] = account.getConfirmPW();
            model.addRow(row);
        }

        view.getTableThongTin().setModel(model);
    }
}
