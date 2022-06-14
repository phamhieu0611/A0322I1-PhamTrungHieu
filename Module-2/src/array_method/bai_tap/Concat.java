package array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class Concat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài mảng 1: ");
        int in1 = scanner.nextInt();
        int [] arr1 = new int[in1];
        for (int i = 0; i <arr1.length; i++){
            System.out.print("Nhập vào giá trị thứ "+ (i+1)+" của mảng 1: ");
            arr1[i] = scanner.nextInt();
        }System.out.println("Mảng 1 có giá trị là: "+Arrays.toString(arr1));

        System.out.print("Nhập độ dài mảng 2: ");
        int in2 = scanner.nextInt();
        int [] arr2 = new int[in2];
        for (int j = 0; j <arr2.length; j++){
            System.out.print("Nhập vào giá trị thứ "+(j+1)+" của mảnh 2: ");
            arr2[j] = scanner.nextInt();
        }System.out.println("Mảng 2 có giá trị là: "+Arrays.toString(arr2));

        int [] arr3 = new int[in1+in2];
        for (int k = 0; k < arr3.length; k++){
            arr3[k] = arr1[k];
            if (k == in1-1){
                for (int l = 0; l < in2; l++){
                    arr3[l+in1] = arr2[l];
                }
                break;
            }
        }
        System.out.println("Gộp mảng 1 và mảng 2 ta có mảng 3: \n"+Arrays.toString(arr3));
    }
}
