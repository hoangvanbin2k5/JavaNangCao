package Controllers;

import View.SuaThongTinTK;
import View.ThemThongTinTK;
import View.TrangChuSanBongChuSan;
import View.XemThongTinTaiKhoan;
import DAO.ThongTinTaiKhoanDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Models.DangKi;
import java.util.List;

public class XemThongTinTaiKhoanController {
    private XemThongTinTaiKhoan view;

    public XemThongTinTaiKhoanController(XemThongTinTaiKhoan view) {
        this.view = view;
        
        loadDataToTable();

        view.getBtnThemTK().addActionListener(e -> {
        	ThemThongTinTK themThongTin = new ThemThongTinTK();
        	ThemThongTinTKController controller = new ThemThongTinTKController(themThongTin, view);
        	themThongTin.setVisible(true);
        	loadDataToTable();
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
                String confirmPassword = (String) model.getValueAt(selectedRow, 3);
                
                DangKi dangKi = new DangKi(username, gmail, password, confirmPassword);
                SuaThongTinTK suaThongTin = new SuaThongTinTK(dangKi);
                SuaThongTinTKController controller = new SuaThongTinTKController(suaThongTin, view);
                suaThongTin.setVisible(true);
        });

        view.getBtnXoa().addActionListener(e -> {
                int selectedRow = view.getTableThongTin().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(view, "Vui lòng chọn một hàng để xoá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DefaultTableModel model = (DefaultTableModel) view.getTableThongTin().getModel();
                String username = (String) model.getValueAt(selectedRow, 0);

                ThongTinTaiKhoanDAO.deleteDangKi(username);

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
        List<DangKi> accountList = ThongTinTaiKhoanDAO.getAllAccounts();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Username");
        model.addColumn("Gmail");
        model.addColumn("Password");

        for (DangKi account : accountList) {
            Object[] row = new Object[3];
            row[0] = account.getUserName();
            row[1] = account.getEmail();
            row[2] = account.getPassWord();
            model.addRow(row);
        }

        view.getTableThongTin().setModel(model);
    }
}
