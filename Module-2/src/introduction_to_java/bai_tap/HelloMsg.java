package introduction_to_java.bai_tap;

import java.util.Scanner;

public class HelloMsg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào ên của bạn: ");
        String value = scanner.next();
        System.out.println("Hello " + value);
    }
}
