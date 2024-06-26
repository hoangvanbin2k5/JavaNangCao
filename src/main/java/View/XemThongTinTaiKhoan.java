package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ThongTinTaiKhoanDAO;
import Models.DangKi;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

public class XemThongTinTaiKhoan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableThongTin;
    private JButton btnThemTK;
    private JButton btnChinhSua;
    private JButton btnXoa;
    private JButton btnThoat;

    public XemThongTinTaiKhoan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 560, 475);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbThongTinTK = new JLabel("Thông Tin Tài Khoản");
        lbThongTinTK.setBounds(206, 16, 147, 16);
        contentPane.add(lbThongTinTK);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(34, 52, 490, 140);
        contentPane.add(panel);
        panel.setLayout(null);

        btnThemTK = new JButton("Thêm Tài Khoản");
        btnThemTK.setBounds(69, 30, 117, 35);
        panel.add(btnThemTK);

        btnChinhSua = new JButton("Sửa Thông Tin");
        btnChinhSua.setBounds(298, 30, 117, 35);
        panel.add(btnChinhSua);

        btnXoa = new JButton("Xoá Tài Khoản");
        btnXoa.setBounds(69, 77, 117, 35);
        panel.add(btnXoa);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(298, 77, 117, 35);
        panel.add(btnThoat);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 195, 548, 232);
        contentPane.add(scrollPane);

        tableThongTin = new JTable();
        scrollPane.setViewportView(tableThongTin);
    }

    public JButton getBtnThemTK() {
        return btnThemTK;
    }

    public JButton getBtnChinhSua() {
        return btnChinhSua;
    }

    public JButton getBtnXoa() {
        return btnXoa;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public JTable getTableThongTin() {
        return tableThongTin;
    }
    
    public void loadDataToTable() {
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

        tableThongTin.setModel(model);
    }
}
