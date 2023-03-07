package daily.mar23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day7MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        for(int t : time) {
            pq.add(new long[] {t, t});
        }

        while (totalTrips > 0) {
            if(ans < pq.peek()[0]) {
                ans = pq.peek()[0];
            }

            while (pq.peek()[0] <= ans) {
                long[] curr = pq.poll();
                pq.add(new long[] {curr[0] + curr[1], curr[1]});
                totalTrips--;
            }

            ans++;
        }

        return ans;
    }

    public long minimumTimeOptimised(int[] time, int totalTrips) {
        int min = Integer.MAX_VALUE;
        for(int t : time) {
            min = Math.min(min, t);
        }

        long l = 0, r = ((long) totalTrips * min + 1), mid;
        while (l < r) {
            mid = l + (r - l)/2;

            long tripsDone = 0;
            for(int t : time) {
                tripsDone += mid/t;
            }

            if(tripsDone < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Day7MinimumTimeToCompleteTrips obj = new Day7MinimumTimeToCompleteTrips();
        System.out.println(obj.minimumTimeOptimised(new int[] {1,2,3}, 5));
    }
}
