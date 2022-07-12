package bubble_sort.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter "+list.length + " values:");
        for (int i = 0; i < list.length; i++){
            list[i] = scanner.nextInt();
        }
        System.out.println("Your input list: ");
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]+"\t");
        }System.out.println("\nBegin sort processing...");
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
    public static void insertionSort(int[] list){
        int pos, x;
        for(int i = 1; i < list.length; i++){
            x = list[i];
            pos = i;
            while(pos > 0 && x < list[pos-1]){
                System.out.println("Swap "+list[i]+" with "+list[i+1]);
                list[pos] = list[pos-1];
                pos--;
            }
            list[pos] = x;
        }
    }
}
