package loop_java.bai_tap;

import java.util.Scanner;

public class SonguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers, n = 2;
        System.out.println("Nhập vào số lượng số nguyên tố muốn hiển thị: ");
        numbers= scanner.nextInt();
        boolean check = true;
        for (int count = 0; count < numbers; ){
            for (int i = 2; i <= Math.sqrt(n); i++){
                    if (n % i == 0){
                        check = false;
                        break;
                    }
            }if (check){
                System.out.println(n+" là số nguyên tố!");
                count++;
            }n++;
            check = true;
        }
    }
}
