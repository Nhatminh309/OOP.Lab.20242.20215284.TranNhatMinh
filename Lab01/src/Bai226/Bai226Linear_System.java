package Bai226;

import javax.swing.JOptionPane;
public class Bai226Linear_System {
    // Check valid double
    public static boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
            return true; // Hợp lệ
        } catch (NumberFormatException e) {
            return false; // Không hợp lệ
        }
    }

    public static String calculate(double a11, double a12, double b1, double a21, double a22, double b2){
        String result = "";
        double D = a11*a22 - a12*a21;
        double D_x1 = b1*a22 - b2*a12;
        double D_x2 = a11*b2 - a21*b1;

        if (D == 0 && (a11/a21 == a12/a22) && (a12/a22 == b1/b2)){
            result = "Hệ có vô số nghiệm";
        } else if (D == 0 && (a11/a21 == a12/a22) && (a12/a22 != b1/b2)){
            result = "Hệ vô nghiệm";
        }

        if (D != 0){
            double x1 = D_x1 / D;
            double x2 = D_x2 / D;
            result = "Hệ có nghiệm" + Double.toString(x1) + Double.toString(x2);
        }
        return result;
    }


    public static void main(String[] args) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        double a11, a12, b1, a21, a22, b2;

        strNum1 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a11: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a21: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum3 = JOptionPane.showInputDialog(null,
                "Nhập hệ số b1: ", "Input the third number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum4 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a21: ", "Input the fourth number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum5 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a22: ", "Input the fifth number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum6 = JOptionPane.showInputDialog(null,
                "Nhập hệ số b2: ", "Input the sixth number",
                JOptionPane.INFORMATION_MESSAGE);

        if (isValidDouble(strNum1) && isValidDouble(strNum2) && isValidDouble(strNum3) && isValidDouble(strNum4) && isValidDouble(strNum5) && isValidDouble(strNum6)) {
            a11 = Double.parseDouble(strNum1);
            a12 = Double.parseDouble(strNum2);
            b1 = Double.parseDouble(strNum3);
            a21 = Double.parseDouble(strNum4);
            a22 = Double.parseDouble(strNum5);
            b2 = Double.parseDouble(strNum6);

            String result = calculate(a11, a12, b1, a21, a22, b2);
            JOptionPane.showMessageDialog( null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog( null, "Vui lòng nhập số");
            System.exit(0);
        }
    }
}
