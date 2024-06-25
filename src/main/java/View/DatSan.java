package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DatSan extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tFHoVaTen;
    private JTextField tFNgayDat;
    private JTextField tFThoiGianDa;
    private JTextField tFThoiGianKetThuc;
    private JButton btnDatSan;
    private JButton btnThoat;

    public DatSan() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 542, 387);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbDatSan = new JLabel("Đặt Sân");
        lbDatSan.setBounds(237, 17, 61, 16);
        contentPane.add(lbDatSan);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Nhập Thông Tin Để Đặt Sân", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(25, 55, 486, 263);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbHoVaTen = new JLabel("Họ Và Tên:");
        lbHoVaTen.setBounds(39, 41, 95, 16);
        panel.add(lbHoVaTen);

        tFHoVaTen = new JTextField();
        tFHoVaTen.setBounds(230, 36, 184, 26);
        panel.add(tFHoVaTen);
        tFHoVaTen.setColumns(10);

        JLabel lbNgayDat = new JLabel("Ngày Muốn Đặt (dd/mm):");
        lbNgayDat.setBounds(39, 79, 174, 16);
        panel.add(lbNgayDat);

        tFNgayDat = new JTextField();
        tFNgayDat.setBounds(230, 74, 185, 26);
        panel.add(tFNgayDat);
        tFNgayDat.setColumns(10);

        JLabel lbThoiGianDa = new JLabel("Thời Gian Đá (00h00):");
        lbThoiGianDa.setBounds(39, 122, 158, 16);
        panel.add(lbThoiGianDa);

        JLabel lbThoiGianKetThuc = new JLabel("Thời Gian Kết Thúc (00h00):");
        lbThoiGianKetThuc.setBounds(39, 159, 184, 16);
        panel.add(lbThoiGianKetThuc);

        tFThoiGianDa = new JTextField();
        tFThoiGianDa.setColumns(10);
        tFThoiGianDa.setBounds(229, 117, 185, 26);
        panel.add(tFThoiGianDa);

        tFThoiGianKetThuc = new JTextField();
        tFThoiGianKetThuc.setColumns(10);
        tFThoiGianKetThuc.setBounds(229, 154, 185, 26);
        panel.add(tFThoiGianKetThuc);

        btnDatSan = new JButton("Đặt Sân");
        btnDatSan.setBounds(83, 192, 117, 38);
        panel.add(btnDatSan);

        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(239, 192, 117, 38);
        panel.add(btnThoat);
    }

    public JTextField getTFHoVaTen() {
        return tFHoVaTen;
    }

    public JTextField getTFNgayDat() {
        return tFNgayDat;
    }

    public JTextField getTFThoiGianDa() {
        return tFThoiGianDa;
    }

    public JTextField getTFThoiGianKetThuc() {
        return tFThoiGianKetThuc;
    }

    public JButton getBtnDatSan() {
        return btnDatSan;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }
}
