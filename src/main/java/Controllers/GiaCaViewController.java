package Controllers;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.GiaCaDAO;
import Models.GiaCa;
import View.GiaCaView;
import View.TrangChuSanBongKhachHang;
import java.util.List;

public class GiaCaViewController {
    private GiaCaView view;

    public GiaCaViewController(GiaCaView view) {
        this.view = view;

        loadDataToTable();

        view.getBtnThoat().addActionListener(e -> {
            TrangChuSanBongKhachHang trangChuKH = new TrangChuSanBongKhachHang();
            TrangChuSanBongKhachHangController controller = new TrangChuSanBongKhachHangController(trangChuKH);
            trangChuKH.setVisible(true);
            view.dispose();
        });
    }

    private void loadDataToTable() {
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

        view.getTableGiaSanPham().setModel(model);
    }
}
