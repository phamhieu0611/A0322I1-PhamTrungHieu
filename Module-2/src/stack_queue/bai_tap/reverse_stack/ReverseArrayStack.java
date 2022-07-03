package stack_queue.bai_tap.reverse_stack;

import java.util.Stack;

public class ReverseArrayStack {
    public static void main(String[] args) {
        Stack<Integer> wStack = new Stack();
        Stack<Integer> wReverseArrayStack = new Stack();
        int temp;

        wStack.push(1);
        wStack.push(2);
        wStack.push(3);
        wStack.push(4);
        wStack.push(5);
        System.out.println("Array stack before reverse: "+wStack);
        int lengh = wStack.size();

        for (int i = 0; i < lengh; i++){
            temp = wStack.pop();
            wReverseArrayStack.push(temp);
        }
        System.out.println("Array stack after reverse: "+wReverseArrayStack);
    }
}
