package Bai226;

import javax.swing.JOptionPane;
public class Bai226Linear_Equation {
    // Check valid double
    public static boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
            return true; // Hợp lệ
        } catch (NumberFormatException e) {
            return false; // Không hợp lệ
        }
    }

    public static void main(String[] args) {
        String str1, str2;
        double a, b;
        String result;

        str1 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        str2 = JOptionPane.showInputDialog(null,
                "Nhập hệ số b: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        if (isValidDouble(str1) && isValidDouble(str2)){
            a = Double.parseDouble(str1);
            b = Double.parseDouble(str2);

            if (a == 0 && b == 0){
                result = "Phương trình vô số nghiệm";
            }
            else if (a == 0 && b != 0){
                result = "Phương trình vô nghiệm";
            }
            else {
                result = String.valueOf(-b / a);
            }
        } else {
            result = "Vui lòng nhập số";
        }

        JOptionPane.showMessageDialog(null, "x = " + result, "Kết quả ax + b=0 là: ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);

    }
}
