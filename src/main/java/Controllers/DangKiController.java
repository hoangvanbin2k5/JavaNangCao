package Controllers;

import javax.swing.JOptionPane;

import DAO.DangKiDAO;
import Models.DangKi;
import View.DangKiView;
import View.DangNhapView;

public class DangKiController {
    private DangKiView view;

    public DangKiController(DangKiView view) {
        this.view = view;

        view.getBtnDangKy().addActionListener(e -> {
            int dk = JOptionPane.showConfirmDialog(view, "Bạn có muốn đăng kí?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (dk != JOptionPane.YES_OPTION) {
                return;
            }

            String username = view.getTFUser().getText();
            String gmail = view.getTFGmail().getText();
            String password = new String(view.getPwFPassWord().getPassword());
            String confirmPassword = new String(view.getPwFConfirmPW().getPassword());

            if (username.isEmpty() || gmail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Vui lòng điền đầy đủ thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(view, "Mật khẩu xác nhận không khớp.", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            DangKi dangKi = new DangKi(username, gmail, password, confirmPassword);

            DangKiDAO.insert(dangKi);
            JOptionPane.showMessageDialog(view, "Đăng kí thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
           
        });

        view.getBtnDangNhap().addActionListener(e -> {
            DangNhapView dangNhapView = new DangNhapView();
            DangNhapController controller = new DangNhapController(dangNhapView);
            dangNhapView.setVisible(true);
            view.dispose(); 
        });
    }
}
