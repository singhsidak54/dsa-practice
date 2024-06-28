package daily.apr23;

import java.util.Collections;
import java.util.PriorityQueue;

public class Day24LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() != 1) {
            int a = pq.poll(), b = pq.poll();

            if(a != b) {
                pq.add(Math.abs(a - b));
            }
        }

        return pq.poll();
    }
}
