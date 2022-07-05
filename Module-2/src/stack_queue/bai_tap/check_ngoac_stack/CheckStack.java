package stack_queue.bai_tap.check_ngoac_stack;

import java.util.Scanner;
import java.util.Stack;

public class CheckStack {
    public static void main(String[] args) {
        char leftBracket = '(', rightBracket = ')';
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter something with bracket ( or ): ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == leftBracket){
                leftStack.push(leftBracket);
            }else if (str.charAt(i) == rightBracket){
                rightStack.push(rightBracket);
            }
        }
        if (leftStack.isEmpty()){
            System.out.println("Have no bracket (: False");
        }else if (rightStack.isEmpty()){
            System.out.println("Have no bracket ): False");
        }else {
            if (leftStack.size() == rightStack.size()){
                System.out.println("Number bracket ( and ) match: True");
            }else {
                System.out.println("Number bracket ( and ) don't match: False");
            }
        }
    }
}
