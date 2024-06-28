package Scaler.Heap;

import java.util.PriorityQueue;

public class MishaAndCandies {
    public int solve(int[] A, int B) {
        int candiesEaten = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int candy : A) {
            pq.add(candy);
        }

        while (pq.size() > 0) {
           int curr = pq.poll();
           if(curr > B) {
               break;
           }
           int canEat = (int)Math.floor(curr/2.0);
           candiesEaten += canEat;

           if(pq.size() > 0) {
               int next = pq.poll();
               pq.add(next + curr - canEat);
           }
        }

        return candiesEaten;
    }
}
