package stack;

import java.util.Stack;

public class ReverseAStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
    }

    public static void insertAtBottom(Stack<Integer> stack, int temp) {
        if (stack.isEmpty()) {
            stack.push(temp);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, temp);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
