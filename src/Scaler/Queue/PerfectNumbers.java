package Scaler.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public String solve(int A) {
        if(A == 1) return "11";
        if(A == 2) return "22";

        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        int count = 2;
        String ans;
        while (true) {
            String curr = queue.poll();

            queue.add(curr + "1");
            count++;
            if(count == A) {
                ans = curr + "1";
                break;
            }

            queue.add(curr + "2");
            count++;
            if(count == A) {
                ans = curr + "2";
                break;
            }
        }

        return ans + new StringBuilder(ans).reverse();
    }
}
