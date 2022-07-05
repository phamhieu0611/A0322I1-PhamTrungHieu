package stack_queue.bai_tap.hex_to_binaty;

import java.util.Scanner;

public class SwapTest {
    public static void main(String[] args) {
        HexToBinary convert = new HexToBinary();
        Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Hex want to swap to Binary: ");
            int binary = scanner.nextInt();
            convert.convertBinary(binary);
    }
}
