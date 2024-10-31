package daily.oct24;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day14MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for(int num : nums) {
            pq.add(num);
        }

        while (!pq.isEmpty() && k-- > 0) {
            int curr = pq.poll();
            ans += curr;
            pq.add(Math.ceilDiv(curr, 3));
        }

        return ans;
    }
}
