package daily.feb23;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day24MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            if(num % 2 == 1) {
                num = num * 2;
            }
            min = Math.min(min, num);
            pq.add(num);
        }

        int minDeviation = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            minDeviation = Math.min(minDeviation, curr - min);
            if(curr % 2 == 1) {
                break;
            }
            pq.add(curr/2);
            min = Math.min(min, curr/2);
        }

        return minDeviation;
    }
}
