package loop_java.thuc_hanh;

import java.util.Locale;
import java.util.Scanner;

public class LaiVay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Nhập vào số tiền vay: ");
        money = scanner.nextDouble();
        System.out.println("Nhập vào số tháng vay: ");
        month = scanner.nextInt();
        System.out.println("Nhập lãi suất hàng năm theo tỷ lệ phần trăm: ");
        interestRate = scanner.nextDouble();

        double totalInterest = 0;
        for (int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Tổng lãi là: "+totalInterest);
    }
}
