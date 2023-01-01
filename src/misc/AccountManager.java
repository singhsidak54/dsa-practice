package misc;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Problem link - https://www.scaler.com/academy/mentee-dashboard/class/7326/assignment/problems/9931
public class AccountManager {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        int timeStamp = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int index = 0;
        while (index < C.size()) {
            if(timeStamp < C.get(index)) {
                timeStamp = C.get(index);
            }

            while (!queue.isEmpty() && queue.peek() <= timeStamp) {
                A++;
                queue.poll();
            }

            if(A != 0) {
                A--;
                queue.add(timeStamp + B);
            }

            ans.add(A);
            index++;
        }

        return ans;
    }
}
