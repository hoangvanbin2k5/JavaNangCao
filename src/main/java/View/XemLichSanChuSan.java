package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LichSanDAO;
import Models.LichSan;

import javax.swing.JLabel;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

public class XemLichSanChuSan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableLichSan;
    private JButton btnXoaSan;
    private JButton btnThoat;
    private JButton btnChinhSua;
    private JButton btnThemSan;

    public XemLichSanChuSan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 564, 466);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbLichSan = new JLabel("Lịch Sân Bóng");
        lbLichSan.setBounds(208, 10, 130, 16);
        contentPane.add(lbLichSan);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null, "Chức Năng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 38, 490, 140);
        contentPane.add(panel);

        btnThemSan = new JButton("Thêm Sân");
        btnThemSan.setBounds(69, 30, 117, 35);
        panel.add(btnThemSan);

        btnChinhSua = new JButton("Sửa Thông Tin");
        btnChinhSua.setBounds(298, 30, 117, 35);
        panel.add(btnChinhSua);

        btnXoaSan = new JButton("Xoá Sân");
        btnXoaSan.setBounds(69, 77, 117, 35);
        panel.add(btnXoaSan);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(298, 77, 117, 35);
        panel.add(btnThoat);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 190, 490, 220);
        contentPane.add(scrollPane);

        tableLichSan = new JTable();
        scrollPane.setViewportView(tableLichSan);
    }

    public JButton getBtnXoaSan() {
        return btnXoaSan;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public JButton getBtnChinhSua() {
        return btnChinhSua;
    }
    
    public JButton getBtnThem() {
    	return btnThemSan;
    }

    public JTable getTableLichSan() {
        return tableLichSan;
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
        
        tableLichSan.setModel(model);
    }
}
