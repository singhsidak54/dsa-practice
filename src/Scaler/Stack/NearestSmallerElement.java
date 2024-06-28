package Scaler.Stack;

import java.util.Stack;

public class NearestSmallerElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i=0; i<A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }

        return res;
    }
}
