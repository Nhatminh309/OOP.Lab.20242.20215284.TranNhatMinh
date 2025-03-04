package Bai6;
import java.util.Arrays;  // Import thư viện để sử dụng Arrays
import java.util.Scanner;

public class Bai65Array {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhap so phan tu: ");  // In ra thông báo yêu cầu nhập số phần tử của mảng
        int number = input.nextInt();
        int[] arr = new int[number];  // Khai báo một mảng có kích thước dựa trên số phần tử người dùng đã nhập
        int sum = 0;

        for (int i = 0; i < number; i++) {
            arr[i] = input.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);  // Sắp xếp mảng theo thứ tự tăng dần

        System.out.println("Mang sau khi sap xep: ");
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");

        System.out.println("Tong cua mang: " + sum);  // In ra tổng của mảng
        System.out.println("Gia tri trung binh: " + (1.0 * sum / number));  // In ra giá trị trung bình của các phần tử trong mảng
    }
}