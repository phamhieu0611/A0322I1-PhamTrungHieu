package stack_queue.bai_tap.check_ngoac_stack;

import java.util.Scanner;
import java.util.Stack;

public class CheckStack {
    public static void main(String[] args) {
        char leftBracket = '(', rightBracket = ')';
        Stack<Character> wStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter something with bracket ( or ): ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == leftBracket){
                wStack.push(leftBracket);
            }else if (str.charAt(i) == rightBracket){
                wStack.pop();
            }
        }
        if (wStack.isEmpty()){
            System.out.println("True");
        }else if (!wStack.isEmpty()){
            System.out.println("Have some bracket (: False");
        }
    }
}
