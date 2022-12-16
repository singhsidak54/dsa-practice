package daily.dec22;

import java.util.Stack;

public class Day16ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int front;
    public Day16ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        front = 0;
    }

    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()) {
            return front;
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
}
