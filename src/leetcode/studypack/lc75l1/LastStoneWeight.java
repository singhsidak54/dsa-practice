package lc75l1;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if(x != y) {
                pq.add(y - x);
            }
        }

        return pq.size() == 1 ? pq.poll() : 0;
    }
}
