package loop_java.bai_tap;

import java.util.Scanner;

public class SonguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố muốn hiển thị: ");
        int numbers = scanner.nextInt();
        int n = 2;
        boolean check = true;
        for (int count = 0; count < numbers; ){
            for (int i = 2; i < n; i++){
                while (n <= Math.sqrt(i)){
                    if (i % n == 0){
                        check = false;
                        break;
                    }n++;
                }if (check){
                    System.out.println(n+" là số nguyên tố!");
                    count++;
                }
            }
        }
    }
}
