package misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int attended = 0, i = 0, n = events.length, d = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (!pq.isEmpty() || i < n) {
            if(pq.isEmpty()) {
                d = events[i][0];
            }

            while (i < n && d >= events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }

            pq.poll();
            attended++;
            d++;
            while (!pq.isEmpty() && pq.peek() < d) {
                pq.poll();
            }
        }

        return attended;
    }
}
