import javax.swing.*;
public class Bai225Calculate {
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
        String strNum1, strNum2;
        double num1, num2;
        String strNotification = "You've just entered ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please enter your first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please enter your second number: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        if (isValidDouble(strNum1) && isValidDouble(strNum2)) {
            num1 = Double.parseDouble(strNum1);
            num2 = Double.parseDouble(strNum2);

            double sum = num1 + num2;
            double diff = num1 - num2;
            double product = num1 * num2;
            String quotient = (num2 != 0) ? String.valueOf(num1 / num2) : "Không thể chia cho 0";
            String message = "Sum: " + sum +
                    "\nDiff: " + diff +
                    "\nProduct: " + product +
                    "\nQuotient: " + quotient;

            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }else {
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
            System.exit(0);
        }

    }
}
