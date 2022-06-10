package introduction_to_java.bai_tap;

import java.util.Locale;
import java.util.Scanner;

public class NumToStr {
    public static void main(String[] args) {
         int numinput;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        do {
            System.out.printf("Nhập vào số muốn đọc (tối đa có 3 chữ số): ");
            numinput = scanner.nextInt();
        }while (numinput > 999);
        System.out.printf("Đã nhâp đúng định dạng, bắt đầu đọc số: ");
        int tram = numinput / 100;
        int chuc = numinput / 10 % 10;
        int donvi = numinput % 10;
        switch (tram){
            case 1:
                System.out.print("Một trăm ");
                break;
            case 2:
                System.out.print("Hai trăm ");
                break;
            case 3:
                System.out.print("Ba trăm ");
                break;
            case 4:
                System.out.print("bốn trăm ");
                break;
            case 5:
                System.out.print("Năm trăm ");
                break;
            case 6:
                System.out.print("Sáu trăm ");
                break;
            case 7:
                System.out.print("Bảy trăm ");
                break;
            case 8:
                System.out.print("Tám trăm ");
                break;
            case 9:
                System.out.print("Chín trăm ");
        }
        switch (chuc){
            case 0:
                System.out.print("Lẻ ");
                break;
            case 1:
                System.out.print("Mười ");
                break;
            case 2:
                System.out.print("Hai mươi ");
                break;
            case 3:
                System.out.print("Ba mươi ");
                break;
            case 4:
                System.out.print("bốn mươi ");
                break;
            case 5:
                System.out.print("Năm mươi ");
                break;
            case 6:
                System.out.print("Sáu mươi ");
                break;
            case 7:
                System.out.print("Bảy mươi ");
                break;
            case 8:
                System.out.print("Tám mươi ");
                break;
            case 9:
                System.out.print("Chín mươi ");
        }
        switch (donvi){
            case 1:
                System.out.print("Một");
                break;
            case 2:
                System.out.print("Hai");
                break;
            case 3:
                System.out.print("Ba");
                break;
            case 4:
                System.out.print("bốn");
                break;
            case 5:
                System.out.print("Năm");
                break;
            case 6:
                System.out.print("Sáu");
                break;
            case 7:
                System.out.print("Bảy");
                break;
            case 8:
                System.out.print("Tám");
                break;
            case 9:
                System.out.print("Chín");
        }
    }
}
