package stack_queue.bai_tap.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Nhập vào chuỗi muốn kiểm tra đối xứng: ");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        Queue queue = new LinkedList();
        for (int i = inputString.length()-1; i >= 0; i--){
            queue.add(inputString.charAt(i));
        }
        String reverseString = "";
        while (!queue.isEmpty()){
            reverseString = reverseString+queue.remove();
        }if (inputString.toLowerCase().equals(reverseString.toLowerCase()))
            System.out.println("Chuỗi đối xứng.");
        else
            System.out.println("Chuỗi không đối xứng.");
    }
}
