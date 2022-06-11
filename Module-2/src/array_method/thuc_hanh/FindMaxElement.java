package array_method.thuc_hanh;

import java.util.Scanner;

public class FindMaxElement {
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
        System.out.print("Danh sách các giá trị: ");
        for (int j = 0; j <array.length; j++){
            System.out.print(array[j]+"\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++){
            if (array[j] > max){
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("\nSố lớn nhất trong danh sách có giá trị là " + max + ", tại vị trí "+index);
    }
}
