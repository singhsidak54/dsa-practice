package bs2;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumLimitOfBallsInABag {
    /**
     * doesn't work because the assumption that the best way to divide an odd number into 2
     * is by dividing it into (n+1)/2 and (n-1)/2 is wrong.
     */
    public int minimumSizeWrong(int[] nums, int maxOperations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : nums) {
            pq.add(num);
        }

        while (maxOperations > 0) {
            int num = pq.poll();
            if(num % 2 == 0) {
                pq.add(num/2);
                pq.add(num/2);
            } else {
                pq.add((num + 1)/2);
                pq.add((num - 1)/2);
            }
            maxOperations--;
        }

        return pq.poll();
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        int l = 1, r = max, m, count;
        while (l < r) {
            m = l + (r - l)/2;
            count = 0;

            for(int num : nums) {
                count += (num - 1)/m;
            }

            if(count > maxOperations) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
