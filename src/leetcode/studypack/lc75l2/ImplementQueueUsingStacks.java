package lc75l2;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stack1, stack2;
    int front;
    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.add(x);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if(!stack2.isEmpty()) {
            return stack2.peek();
        }

        return front;
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
