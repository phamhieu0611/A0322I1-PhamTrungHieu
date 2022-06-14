package array_method.bai_tap;

import java.util.Scanner;

public class TongDuongCheo {
    public static void main(String[] args) {
        int soDong, soCot, sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào số dòng: ");
        soDong = scanner.nextInt();

        do {
            System.out.print("Nhập vào số cột: ");
            soCot = scanner.nextInt();
            if (soCot != soDong){
                System.out.println("Số cột khác số dòng, đây không phải là 1 ma trận vuông.\nVui lòng nhập lại!");
            }
        }while (soDong != soCot);

        int [][] Arr = new int[soDong][soCot];
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
            }
            System.out.println("\n");
        }
        for (int k = 0; k < Arr.length; k++){
            for (int l = 0; l < Arr[k].length; l++){
                if (k == l){
                    sum += Arr[k][l];
                }
            }
        }
        System.out.println("Tổng các số ở đường chéo ma trận là: "+sum);
    }
}
