package introduction_to_java.bai_tap;

import java.util.Locale;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        System.out.print("Nhập vào USD để chuyển đổi qua VNĐ: ");
        usd = scanner.nextDouble();
        double tygia = usd*vnd;
        System.out.println("Giá trị VNĐ là: "+tygia+"VNĐ");
    }
}
