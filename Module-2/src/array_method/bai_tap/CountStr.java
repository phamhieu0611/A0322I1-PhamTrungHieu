package array_method.bai_tap;

import java.util.Scanner;

public class CountStr {
    public static void main(String[] args) {
        int count = 0;
        String str = "aabbccabca";
        char s;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chuỗi cho trước là: "+str);
        System.out.print("nhập vào ký tự muốn đếm số lần xuất hiện: ");
        s = scanner.next().charAt(0);

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == s){
                count++;
            }
        }
        System.out.println("Ký tự "+s+" xuất hiện "+count+" lần trong chuỗi.");
    }
}
