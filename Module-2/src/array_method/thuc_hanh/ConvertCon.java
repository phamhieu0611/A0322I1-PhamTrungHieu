package array_method.thuc_hanh;

import java.util.Scanner;

public class ConvertCon {
    public static  double celToFah(double cel){
        double fah = (9.0 / 5) * cel +32;
        return fah;
    }
    public static double fahToCel(double fah){
        double cel = (5.0 / 9) * (fah - 32);
        return cel;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fah;
        double cel;
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. Chuyển từ dộ F qua độ C");
            System.out.println("2. Chuyển từ độ C quá độ F");
            System.out.println("0. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Nhập vào độ F: ");
                    fah = scanner.nextDouble();
                    System.out.println("Độ C là: "+fahToCel(fah));
                    break;
                case 2:
                    System.out.print("Nhập vào độ C: ");
                    cel = scanner.nextDouble();
                    System.out.println("Độ F là: "+celToFah(cel));
                    break;
                case 0:
                    System.exit(0);

            }
        }while (choice != 0);
    }
}
