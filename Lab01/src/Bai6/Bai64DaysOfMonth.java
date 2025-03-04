package Bai6;
import java.util.Scanner;

public class Bai64DaysOfMonth {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        int year;
        String month;

        // Nhập năm hợp lệ
        while (true) {
            System.out.print("Nhập năm: ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year > 0) break;
            } else {
                input.next(); // Xóa dữ liệu không hợp lệ
            }
            System.out.println("Năm không hợp lệ. Vui lòng nhập lại!");
        }

        // Nhập tháng hợp lệ
        input.nextLine(); // Xóa bộ nhớ đệm
        while (true) {
            System.out.print("Nhập tháng: ");
            month = input.nextLine().trim();
            if (month.matches("^(1[0-2]|[1-9]|January|February|March|April|June|July|August|September|October|November|December|" +
                    "Jan.|Feb.|Mar.|Apr.|May.|Aug.|Sept.|Oct.|Nov.|Dec.|" +
                    "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)$")) {
                break;
            }
            System.out.println("Tháng không hợp lệ. Vui lòng nhập lại!");
        }

        input.close();

        System.out.print("Số ngày trong tháng " + month + " " + year + " là: ");

        switch (month) {
            case "1": case "3": case "5": case "7": case "8": case "10": case "12":
            case "January": case "March": case "May": case "July": case "August": case "October": case "December":
            case "Jan.": case "Mar." : case "Aug.": case "Oct.": case "Dec.":
            case "Jan": case "Mar" : case "Aug": case "Oct": case "Dec":
                System.out.println("31");
                break;
            case "4": case "6": case "9": case "11":
            case "April": case "June": case "September": case "November":
            case "Apr.": case "Sept.": case "Nov.":
            case "Apr": case "Jun": case "Sep": case "Nov":

                System.out.println("30");
                break;
            case "2": case "February": case "Feb.": case "Feb":
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    System.out.println("29");
                } else {
                    System.out.println("28");
                }
                break;
        }
    }
}
