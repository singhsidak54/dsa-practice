package Scaler.Contest.AdvancedDSA2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1 {
    public double distance(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }

    public int[][] solve(final int[][] A, final int B) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Double.compare(distance(o1[0], o1[1]), distance(o2[0], o2[1]));
            }
        });

        for(int[] pt : A) {
            pq.add(pt);
            if(pq.size() > B) {
                pq.poll();
            }
        }

        int[][] res = new int[B][2];
        for(int i=0; i<res.length; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
