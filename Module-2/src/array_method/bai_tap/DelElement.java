package array_method.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class DelElement {
    public static void main(String[] args) {
        int [] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0};
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số muốn xóa: ");
        int x = scanner.nextInt();
        int index_del = 0;
        for (int i = index_del; index_del < arr.length; index_del++){
            if (x != arr[index_del]){
                arr[i] = arr[index_del];
                arr[arr.length-1] = 0;
                i++;
            }else {
                System.out.print("Số "+x+" vị trí thứ "+index_del+" trong mảng.");
            }
        }
        System.out.print("Mảng sau khi xóa số "+x+" là: \n"+Arrays.toString(arr));
    }
}
