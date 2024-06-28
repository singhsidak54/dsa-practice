package Scaler.Heap;

import java.util.PriorityQueue;

public class MaximumArraySumAfterBNegations {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : A) {
            pq.add(num);
        }

        while (B-- > 0) {
            int curr = pq.poll();
            pq.add(-curr);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
