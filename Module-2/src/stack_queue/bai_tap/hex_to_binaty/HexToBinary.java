package stack_queue.bai_tap.hex_to_binaty;

public class HexToBinary {
    private int[] arr = new int[40];
    private int index = 0;

    public void convertBinary(int num){
        while (num > 0){
            arr[index++] = num%2;
            num = num/2;
        }
        for (int i = index-1; i >= 0; i--){
            System.out.printf("%s", arr[i]);
        }
        System.out.println();
    }
}
