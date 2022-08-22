package bs2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RangeSumOfSortedSubarraySums {
    class Pair {
        long sum;
        int index;

        public Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Long.compare(o1.sum, o2.sum);
            }
        });

        for(int i=0; i<n; i++) {
            pq.add(new Pair(nums[i], i + 1));
        }

        int ans = 0, mod = (int)1e9 + 7;
        for(int i=1; i<=right; i++) {
            Pair temp = pq.poll();

            if(i >= left) {
                ans = (int) ((ans + temp.sum) % mod);
            }

            if(temp.index < n) {
                temp.sum += nums[temp.index++];
                pq.add(temp);
            }
        }

        return ans;
    }
}
