package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LichSanDAO;
import Models.LichSan;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.util.List;

public class XemLichSan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableThongTinSan;
    private JButton btnThoat;
    private JButton btnDangXuat;
    
    public XemLichSan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 347);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbThongTinSan = new JLabel("  Thông Tin Về Lịch Sân");
        lbThongTinSan.setBounds(168, 6, 188, 16);
        contentPane.add(lbThongTinSan);
        
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(77, 254, 117, 40);
        contentPane.add(btnThoat);
        
        btnDangXuat = new JButton("Đăng Xuất");
        btnDangXuat.setBounds(310, 254, 117, 40);
        contentPane.add(btnDangXuat);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 34, 503, 208);
        contentPane.add(scrollPane);
        
        tableThongTinSan = new JTable();
        scrollPane.setViewportView(tableThongTinSan);
        
        loadDataToTable();
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

        tableThongTinSan.setModel(model);
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }

    public JButton getBtnDangXuat() {
        return btnDangXuat;
    }
}
