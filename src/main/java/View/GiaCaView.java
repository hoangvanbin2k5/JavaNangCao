package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;

public class GiaCaView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableGiaSanPham;
    private JButton btnThoat;

    public GiaCaView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 502, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Thông Tin Giá Sản Phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(25, 46, 455, 264);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(6, 27, 443, 157);
        panel.add(scrollPane);
        
        tableGiaSanPham = new JTable();
        scrollPane.setViewportView(tableGiaSanPham);
        
        btnThoat = new JButton("Thoát");
        btnThoat.setBounds(165, 196, 117, 43);
        panel.add(btnThoat);
        
        JLabel lbGiaCa = new JLabel("Giá Sản Phẩm");
        lbGiaCa.setBounds(206, 18, 108, 16);
        contentPane.add(lbGiaCa);
    }

    public JTable getTableGiaSanPham() {
        return tableGiaSanPham;
    }

    public JButton getBtnThoat() {
        return btnThoat;
    }
}
