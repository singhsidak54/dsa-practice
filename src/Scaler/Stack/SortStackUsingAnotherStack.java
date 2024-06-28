package Scaler.Stack;

import java.util.Stack;

public class SortStackUsingAnotherStack {
    public int[] solve(int[] A) {
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();

        for(int num : A) {
            while (!one.isEmpty() && one.peek() > num) {
                two.push(one.pop());
            }

            one.push(num);

            while (!two.isEmpty()) {
                one.push(two.pop());
            }
        }

        int[] res = new int[A.length];
        for(int i=A.length-1; i>=0; i--) {
            res[i] = one.pop();
        }
        return res;
    }
}
