package searching_algorithms.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int[] list = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};
    static int binarySearch(int list[], int left, int right, int value){
            int mid = (left + right) / 2;
            if (right <= left){
                return -1;
            }else {
                if (list[mid] < value){
                    return binarySearch(list, left+1, right, value);
                }if (list[mid] < value){
                    return binarySearch(list, left, right-1, value);
                }if (list[mid] == value){
                    return mid;
                }
            }return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(list));
        System.out.println("Input number want to find index: ");
        int value = scanner.nextInt();
        BinarySearch search = new BinarySearch();
        System.out.println("Index of "+ value +" is "+search.binarySearch(BinarySearch.list,0, BinarySearch.list.length, value));
    }
}
