package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.GiaCaDAO;
import Models.GiaCa;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

public class GiaCaSanPhamAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableSanPham;
    private JButton btnThemSanPham;
    private JButton btnChinhSua;
    private JButton btnXoaSanPham;
    private JButton btnThoat;

    public GiaCaSanPhamAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 578, 470);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbGiaCaSanPham = new JLabel("Giá Cả Sản Phẩm");
        lbGiaCaSanPham.setBounds(192, 18, 147, 16);
        contentPane.add(lbGiaCaSanPham);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(38, 46, 490, 140);
        contentPane.add(panel);

        btnThemSanPham = new JButton("Thêm Sản Phẩm");
        btnThemSanPham.setBounds(69, 30, 117, 35);
        panel.add(btnThemSanPham);

        btnChinhSua = new JButton("Sửa Thông Tin");
        btnChinhSua.setBounds(298, 30, 117, 35);
        panel.add(btnChinhSua);

        btnXoaSanPham = new JButton("Xoá Sản Phẩm");
        btnXoaSanPham.setBounds(69, 77, 117, 35);
        panel.add(btnXoaSanPham);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(298, 77, 117, 35);
        panel.add(btnThoat);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(17, 192, 548, 232);
        contentPane.add(scrollPane);

        tableSanPham = new JTable();
        scrollPane.setViewportView(tableSanPham);
    }

    public JButton getBtnThemSanPham() {
        return btnThemSanPham;
    }

    public JButton getBtnChinhSua() {
        return btnChinhSua;
    }

    public JButton getBtnXoaSanPham() {
        return btnXoaSanPham;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public JTable getTableSanPham() {
        return tableSanPham;
    }
    
    public void loadDataToTable() {
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

        tableSanPham.setModel(model);
    }
}
