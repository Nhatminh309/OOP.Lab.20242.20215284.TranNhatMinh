package Bai6;

import java.util.Scanner;

public class Bai63TriangleStar {
    public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = keyboard.nextInt();
        keyboard.close();

        System.out.println("Hình vẽ:");
        for (int i = 0; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = n - i; j < n; j++) {
                System.out.print("* ");  // In ra dấu '*' để tạo hình tam giác
            }
            System.out.print("\n");
        }
    }
}
