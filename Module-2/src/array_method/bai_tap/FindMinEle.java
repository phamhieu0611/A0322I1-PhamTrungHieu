package array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinEle {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập vào độ dài mảng: ");
            size = scanner.nextInt();
            if (size > 20){
                System.out.println("Độ dài mảng không được lớn hơn 20!");
            }
        }while (size>20);
        array = new int[size];
        int i = 0;
        while (i < array.length){
            System.out.print("Nhập vào giá trị " + (i+1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Danh sách các giá trị trong mảng là: \n"+ Arrays.toString(array));

        int min = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++){
            if (array[j] < min){
                min = array[j];
                index = j + 1;
            }
        }
        System.out.println("\nSố bé nhất trong danh sách có giá trị là " + min + ", tại vị trí "+index);
    }
}

