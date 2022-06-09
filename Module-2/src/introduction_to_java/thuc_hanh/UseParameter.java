package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class UseParameter {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập chiểu rộng: ");
        width = scanner.nextFloat();
        System.out.printf("Nhập chiểu cao: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Diện tích hình chữ nhật là: "+area);
    }
}
