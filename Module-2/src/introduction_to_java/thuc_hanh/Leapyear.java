package introduction_to_java.thuc_hanh;

import java.time.Year;
import java.util.Scanner;

public class Leapyear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.printf("Nhập vào năm để kiển tra năm nhuận: ");
        year = scanner.nextInt();

        boolean isLeapYear = false;

        boolean division4 = year % 4 == 0;
        if (division4){
            boolean division100 = year % 100 ==0;
            if (division100){
                boolean division400 = year % 400 == 0;
                if (division400){
                    isLeapYear = true;
                }
            }else {
                isLeapYear = true;
            }
        }

        if(isLeapYear){
            System.out.printf("%d là năm nhuận!", year);
        } else {
            System.out.printf("%d không phải năm nhuận!", year);
        }
    }
}
