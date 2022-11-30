package misc;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumEarningsFromTaxi {
    public static long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });

        long[] earnings = new long[n + 1];
        int ridePtr = 0;
        for(int i=1; i<=n; i++) {
            earnings[i] = Math.max(earnings[i], earnings[i-1]);
            while(ridePtr < rides.length && i >= rides[ridePtr][0]) {
                int[] ride = rides[ridePtr];
                long newTotalEarningAtRideEnd = earnings[ride[0]] + ride[1] - ride[0] + ride[2];
                earnings[ride[1]] = Math.max(earnings[ride[1]], newTotalEarningAtRideEnd);
                ridePtr++;
            }
        }

        return earnings[n];
    }

    public static void main(String[] args) {
        int[][] rides = {{2,3,6},{8,9,8},{5,9,7},{8,9,1},{2,9,2},{9,10,6},{7,10,10},{6,7,9},{4,9,7},{2,3,1}};
        System.out.println(maxTaxiEarnings(10, rides));
    }
}
