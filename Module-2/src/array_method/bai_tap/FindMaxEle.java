package array_method.bai_tap;

import java.util.Scanner;

public class FindMaxEle {
    public static void main(String[] args) {
        int soDong, soCot;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số dòng: ");
        soDong = scanner.nextInt();
        System.out.print("Nhập vào số cột: ");
        soCot = scanner.nextInt();

        int [][] Arr = new int[soDong][soCot];
        int max = Arr[0][0];
        for (int i = 0; i < soDong; i++){
            for (int j = 0; j < soCot; j++){
                System.out.print("Nhập phần tử thứ ["+ i +","+ j +"]: ");
                Arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print(Arr[i][j] + "\t");
                if (max < Arr[i][j]){
                    max = Arr[i][j];
                }

            }
            System.out.println("\n");
        }
        System.out.println("Phần tử lớn nhất trong mảng là: "+max);
    }
}
