package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTable;

public class ThongTinKhachHang extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnKH;
    private JButton btnChinhSua;
    private JButton btnXoaKH;
    private JButton btnThoat;

    public ThongTinKhachHang() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 567, 474);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbThongTinKH = new JLabel("Thông Tin Khách Hàng");
        lbThongTinKH.setBounds(216, 18, 147, 16);
        contentPane.add(lbThongTinKH);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(28, 56, 490, 140);
        contentPane.add(panel);

        btnKH = new JButton("Thêm Khách Hàng");
        btnKH.setBounds(69, 30, 129, 35);
        panel.add(btnKH);

        btnChinhSua = new JButton("Sửa Thông Tin");
        btnChinhSua.setBounds(298, 30, 117, 35);
        panel.add(btnChinhSua);

        btnXoaKH = new JButton("Xoá Khách Hàng");
        btnXoaKH.setBounds(69, 77, 117, 35);
        panel.add(btnXoaKH);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(298, 77, 117, 35);
        panel.add(btnThoat);

        table = new JTable();
        table.setBounds(6, 197, 548, 232);
        contentPane.add(table);
    }

    public JButton getBtnKH() {
        return btnKH;
    }

    public JButton getBtnChinhSua() {
        return btnChinhSua;
    }

    public JButton getBtnXoaKH() {
        return btnXoaKH;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public JTable getTable() {
        return table;
    }
}
