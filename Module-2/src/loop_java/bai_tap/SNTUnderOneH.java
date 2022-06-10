package loop_java.bai_tap;

import java.util.Scanner;

public class SNTUnderOneH {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là!");
        for (int i = 2; i <= 100; i++){
            int num = 2;
            boolean check = true;
            while (num <= Math.sqrt(i)){
                if (i % num == 0){
                    check = false;
                    break;
                }
                num++;
            }if (check){
                System.out.println(i+" là số nguyên tố!");
            }
        }
    }
}