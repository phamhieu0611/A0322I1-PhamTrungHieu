package array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class StudentPassExam {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Nhập vào kích thước mảng: ");
            size = scanner.nextInt();
            if (size>30){
                System.out.println("Mảng không được lớn hơn 30!");
            }
        }while (size >30);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập điểm học sinh " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        int count = 0;
        System.out.print("List điểm: "+ Arrays.toString(array));
        for (int j = 0; j < array.length; j++) {
            if (array[j] >= 5 && array[j] <= 10) {
                System.out.println("Học sinh " + j + " pass bài kiểm tra!");
                count++;
            }
        }
        System.out.print("\n Số học sinh Pass bài kiểm tra " + count);
    }
}
