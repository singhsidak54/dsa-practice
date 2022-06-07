package ds1;

import java.util.Stack;

// Problem Link - https://leetcode.com/problems/implement-queue-using-stacks/
public class ImplementQueueUsingStacks {
    static class MyQueue {
        private Stack<Integer> s1, s2;
        private int s1Front = -1;
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            if(s1.isEmpty())
                s1Front = x;
            s1.push(x);
        }

        public int pop() {
            if(s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if(s2.isEmpty()) {
                return s1Front;
            }
            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue dummy = new MyQueue();
        dummy.push(1);
        dummy.push(2);
        dummy.pop();
        dummy.push(4);
        while(!dummy.empty())
            System.out.println(dummy.pop());
    }
}
