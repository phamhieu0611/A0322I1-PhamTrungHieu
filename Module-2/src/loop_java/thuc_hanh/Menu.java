package loop_java.thuc_hanh;

import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice = -1;
        int size;
        int width;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Menu");
        System.out.println("1. Vẽ hình tam giác");
        System.out.println("2. Vẽ hình vuông");
        System.out.println("3. Vẽ hình chữ nhật");
        System.out.println("0. Exit");
        System.out.println("Nhập vào lựa chọn của bạn: ");
        choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("Nhập vào chiều cao tam giác");
                size = scanner.nextInt();
                System.out.println("Vẽ hình tam giác: ");
                for (int i = size; i > 0; i--){
                    for (int j = 0; j < i; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 2:
                System.out.println("Nhập vào chiều dài cạnh hình vuông: ");
                size = scanner.nextInt();
                System.out.println("Vẽ hình vuông: ");
                for (int i = 0; i < size; i++){
                    for (int j = 0; j < size; j++){
                        System.out.print("*  ");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                System.out.println("Nhập vào chiều cao: ");
                size = scanner.nextInt();
                System.out.println("Nhập vào chiều rộng: ");
                width = scanner.nextInt();
                System.out.println("Vẽ hình chữ nhật: ");
                for (int i = 0; i <size; i++){
                    for (int j = 0; j < width; j++){
                        System.out.print("*  ");
                    }
                    System.out.println("");
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Lựa chọn sai!");

        }
    }
}
