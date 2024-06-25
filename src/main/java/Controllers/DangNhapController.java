package Controllers;

import javax.swing.JOptionPane;
import DAO.DangNhapDAO;
import Models.DangNhap;
import View.DangKiView;
import View.DangNhapView;
import View.TrangChuSanBongChuSan;
import View.TrangChuSanBongKhachHang;

public class DangNhapController {
    private DangNhapView view;

    public DangNhapController(DangNhapView view) {
        this.view = view;

        view.getBtnDangNhap().addActionListener(e -> {
            String username = view.getTFUserName().getText();
            String password = new String(view.getPwFPassWord().getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            DangNhap dangNhap = new DangNhap(username, password);
            boolean isValid = DangNhapDAO.checkLogin(dangNhap);

            if (isValid) {
                if (username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(view, "Đăng nhập thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    TrangChuSanBongChuSan trangChu = new TrangChuSanBongChuSan();
                    TrangChuSanBongChuSanController controller = new TrangChuSanBongChuSanController(trangChu);
                    trangChu.setVisible(true);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Đăng nhập thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    TrangChuSanBongKhachHang trangChu = new TrangChuSanBongKhachHang();
                    TrangChuSanBongKhachHangController controller = new TrangChuSanBongKhachHangController(trangChu);
                    trangChu.setVisible(true);
                    view.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Tên người dùng hoặc mật khẩu không đúng.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        });

        view.getBtnDangKi().addActionListener(e -> {
            DangKiView dangKiView = new DangKiView();
            dangKiView.setVisible(true);
            DangKiController controller = new DangKiController(dangKiView);
        });
    }
}
