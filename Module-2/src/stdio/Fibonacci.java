package stdio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    private static long fibonancciQHD(int input, Map<Integer, Long> memory){
        if(memory.get(input) != null) {
            return memory.get(input);
        }if (input == 1|| input == 2) {
            return 1;
        }
        long fib = fibonancciQHD(input - 1, memory) + fibonancciQHD(input - 2, memory);
        memory.put(input, fib);
        return fib;
    }
    public static void main(String[] args) {
        int n;
        do {
            System.out.print("Nhập vào số thứ n của dãy Fibonancci (1 <= n <= 1000000): ");
            n = new Scanner(System.in).nextInt();
        }while (n < 1|| n > 1000000);
        Map<Integer, Long> memory = new HashMap<>();
        long findResult = fibonancciQHD(n , memory);
        System.out.println("Số thứ "+n+" của dãy fibonancci là: "+findResult);
    }
}
