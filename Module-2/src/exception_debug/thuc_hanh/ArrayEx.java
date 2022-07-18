package exception_debug.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayEx {
    public Integer[] createRandom(){
        Random random = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List element of array: ");
        for (int i = 0; i < 100; i++){
            arr[i] = random.nextInt(100);
            System.out.println(arr[i]+" ");
        }return arr;
    }

    public static void main(String[] args) {
        ArrayEx arrayEx = new ArrayEx();
        Integer[] arr = arrayEx.createRandom();

        Scanner scanner =  new Scanner(System.in);
        System.out.println("Input index of random element: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Value of index number 5  "+x+" is "+arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index Out of limited of array!");
        }
    }
}
