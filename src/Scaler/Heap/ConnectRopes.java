package Scaler.Heap;

import java.util.PriorityQueue;

public class ConnectRopes {
    public int solve(int[] A) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int size : A) {
            pq.add(size);
        }

        while (pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }

        return cost;
    }
}
