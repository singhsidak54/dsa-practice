package daily.dec22;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Day28RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(piles[o2], piles[o1]);
            }
        });

        for(int i=0; i<piles.length; i++) {
            pq.add(i);
        }

        while (k-- > 0) {
            int curr = pq.poll();
            piles[curr] = piles[curr] - piles[curr]/2;
            pq.add(curr);
        }

        int stonesLeft = 0;
        for(int i=0; i<piles.length; i++) {
            stonesLeft += piles[i];
        }

        return stonesLeft;
    }

    public static void main(String[] args) {
        int[] piles = {5,4,9};
        System.out.println(minStoneSum(piles, 2));
    }
}
