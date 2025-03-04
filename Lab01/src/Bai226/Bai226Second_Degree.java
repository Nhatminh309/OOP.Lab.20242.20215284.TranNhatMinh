package Bai226;

import javax.swing.JOptionPane;
public class Bai226Second_Degree {
    // Check valid double
    public static boolean isValidDouble(String str) {
        try {
            Double.parseDouble(str);
            return true; // Hợp lệ
        } catch (NumberFormatException e) {
            return false; // Không hợp lệ
        }
    }

    public static String calculate(double a, double b, double c){
        double delta = b*b - 4*a*c;
        String result;
        if (delta < 0){
            result = "Phuơng trình vô nghiệm";
        } else if (delta == 0){
            result = "Phương trình có nghiệm kép x = " + Double.toString(-b/(2*a));
        } else {
            double sqrt = Math.sqrt(delta);
            double x1 = (-b + sqrt)/(2*a);
            double x2 = (-b - sqrt)/(2*a);
            result = "Phương trình có 2 nghiệm x1 = " + Double.toString(x1) + ", x2 = " + Double.toString(x2);
        }

        return result;
    }

    public static void main(String[] args) {
        String str1, str2, str3;
        double a, b, c;
        String result = "";

        str1 = JOptionPane.showInputDialog(null,
                "Nhập hệ số a: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        str2 = JOptionPane.showInputDialog(null,
                "Nhập hệ số b: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        str3 = JOptionPane.showInputDialog(null,
                "Nhập hệ số c: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        if (isValidDouble(str1) && isValidDouble(str2) && isValidDouble(str3)){
            a = Double.parseDouble(str1);
            b = Double.parseDouble(str2);
            c = Double.parseDouble(str3);
            if (a == 0){
                JOptionPane.showMessageDialog(null,"Vui lòng nhập a khác 0");
                System.exit(0);
            }
            result = calculate(a, b, c);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng số");
            System.exit(0);
        }
        JOptionPane.showMessageDialog( null, result, "Kết quả", JOptionPane.INFORMATION_MESSAGE);
    }
}
