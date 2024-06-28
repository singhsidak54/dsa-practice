package Scaler.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {
    class Cars {
        int time;
        int profit;
        public Cars(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    public int solve(int[] A, int[] B) {
        Cars[] cars = new Cars[A.length];
        for(int i=0; i<A.length; i++) {
            cars[i] = new Cars(A[i], B[i]);
        }

        Arrays.sort(cars, new Comparator<Cars>() {
            @Override
            public int compare(Cars o1, Cars o2) {
                return Integer.compare(o1.time, o2.time);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int time = 0, mod = 1_000_000_007;
        long profit = 0;
        for(int i=0; i<cars.length; i++) {
            if(time >= cars[i].time) {
                if(pq.isEmpty() || pq.peek() >= cars[i].profit) continue;
                // remove car with minimum profit
                int minProfit = pq.poll();
                profit = (profit - minProfit + cars[i].profit) % mod;
                pq.add(cars[i].profit);
            } else {
                pq.add(cars[i].profit);
                profit = (profit + cars[i].profit) % mod;
                time++;
            }
        }

        return (int)profit;
    }

    public static void main(String[] args) {
        FreeCars obj = new FreeCars();
        int[] A = {1,3,1,7,2,7,1,7,6,7,8,3,3,5,4,4,5};
        int[] B = {2,4,6,8,4,4,4,11,8,11,8,7,7,7,6,10,4};

        System.out.println(obj.solve(A, B));
    }
}
