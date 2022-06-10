package loop_java.bai_tap;

import java.util.Locale;
import java.util.Scanner;

public class PrintShape {
    public static void main(String[] args) {
        int choice = -1;
        int size;
        int width;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Menu");
        System.out.println("1. Vẽ hình chữ nhật");
        System.out.println("2. Vẽ hình tam giác vuông (4 hình 4 góc vuông)");
        System.out.println("3. Vẽ hình tam giác vuông cân");
        System.out.println("0. Exit");
        System.out.println("Nhập vào lựa chọn của bạn: ");
        choice = scanner.nextInt();

        switch (choice){
            case 2:
                System.out.println("Nhập vào chiều cao tam giác");
                size = scanner.nextInt();
                System.out.println("Vẽ hình tam giác vuông góc trái-trên: ");
                for (int i = size; i > 0; i--){
                    for (int j = 0; j < i; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }

                System.out.println("Vẽ hình tam giác vuông ở góc trái-dưới: ");
                for (int i = 0; i < size; i++){
                    for (int j = 0; j <= i; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }

                System.out.println("Vẽ hình tam giác vuông ở gód phải-dưới: ");
                for (int i = 0; i < size; i++){
                    for (int j = size; j > i; j-- ){
                        System.out.print("  ");
                    }for (int k = 0; k < i; k++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }

                System.out.println("Vẽ hình tam giác vuông ở góc phải-trên: ");
                for (int i = 0; i < size; i++){
                    for (int j = 0; j <= i; j++){
                        System.out.print("  ");
                    }for (int k = size; k > i; k--){
                        System.out.print(" *");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                System.out.println("Nhập vào chiều cao hình tam giác vuông cân: ");
                size = scanner.nextInt();
                System.out.println("Vẽ hình tam giác vuông cân: ");
                for (int i = 0; i < size; i++){
                    for (int j = size; j > i; j-- ){
                        System.out.print("  ");
                    }for (int k = 0; k < i*2-1; k++){
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case 1:
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
