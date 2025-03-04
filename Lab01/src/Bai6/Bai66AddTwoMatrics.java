package Bai6;

public class Bai66AddTwoMatrics {
    // Phương thức main, bắt đầu chương trình
    public static void main(String[] arg) {
        // Khai báo và khởi tạo ma trận arr1
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}};

        // Khai báo và khởi tạo ma trận arr2
        int[][] arr2 = {{1, 2, 3}, {7, 8, 9}};

        // Khai báo ma trận arr_sum để lưu tổng của hai ma trận arr1 và arr2
        int[][] arr_sum = new int[2][3];

        System.out.println("Tổng của hai ma trận: ");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                // Tính tổng của hai phần tử tương ứng từ arr1 và arr2, và lưu vào arr_sum
                arr_sum[i][j] = arr1[i][j] + arr2[i][j];
                System.out.print(" " + arr_sum[i][j]);
            }
            System.out.print("\n");
        }
    }
}