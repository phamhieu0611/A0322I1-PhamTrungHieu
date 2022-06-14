package array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int [] arr = {10, 4, 6, 7, 8, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        int x;
        int index = 0;
        System.out.println("Nhập vào giá trị muốn thêm vào mảng: ");
        x = scanner.nextInt();
        do {
            System.out.println("Nhập vào vị trí mà giá trị sẽ thêm vào mảng: ");
            index = scanner.nextInt();
        }while (index <= 1 || index >= arr.length-1);

        for (int i = arr.length-1; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = x;
        System.out.println(Arrays.toString(arr));
    }
}
