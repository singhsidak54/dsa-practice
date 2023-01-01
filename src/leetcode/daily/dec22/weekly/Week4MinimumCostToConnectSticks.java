package daily.dec22.weekly;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Week4MinimumCostToConnectSticks {
    public static int connectSticks(int[] sticks) {
        int n = sticks.length;
        if(n == 1) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.add(sticks[i]);
        }

        int ans = 0;
        while (pq.size() > 1) {
            int currentStick = pq.poll() + pq.poll();
            ans += currentStick;
            pq.add(currentStick);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3354,3259,4909,4598,474};
        System.out.println(connectSticks(arr));
    }
}
