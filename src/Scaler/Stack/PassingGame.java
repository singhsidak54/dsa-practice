package Scaler.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class PassingGame {
    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.add(B);
        int idx = 0;
        while (A > 0) {
            int current = C.get(idx++);
            if(current == 0) {
                stack.pop();
            } else {
                stack.push(current);
            }

            A--;
        }

        return stack.pop();
    }
}
