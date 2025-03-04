package Bai6;

import javax.swing.JOptionPane;  // Import thư viện để sử dụng JOptionPane

public class Bai61ChoosingOption {
    public static void main(String[] args) {
        // Hiển thị hộp thoại xác nhận và lưu lựa chọn của người dùng
        int option = JOptionPane.showConfirmDialog(null,
                "Do you want to change to the first class ticket ?");

        // Dựa vào lựa chọn của người dùng, hiển thị thông báo tương ứng
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION ? "YES" : "NO"));

        System.exit(0);  // Kết thúc chương trình
    }
}
