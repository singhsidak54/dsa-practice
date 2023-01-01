package daily.dec22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day27MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int rocksReq1 = capacity[o1] - rocks[o1];
                int rocksReq2 = capacity[o2] - rocks[o2];
                return Integer.compare(rocksReq1, rocksReq2);
            }
        });

        int fullBags = 0;
        for(int i=0; i<capacity.length; i++) {
            pq.add(i);
        }

        while (additionalRocks > 0 && !pq.isEmpty()) {
            int currIndex = pq.poll();
            int rocksReq = capacity[currIndex] - rocks[currIndex];
            if(rocksReq > additionalRocks) break;

            additionalRocks -= rocksReq;
            fullBags++;
        }

        return fullBags;
    }


    public int maximumBagsBinarySearch(int[] capacity, int[] rocks, int additionalRocks) {
        long[] rocksReq = new long[capacity.length];
        for(int i=0; i<capacity.length; i++) {
            rocksReq[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(rocksReq);
        for(int i=1; i<rocksReq.length; i++) {
            rocksReq[i] += rocksReq[i - 1];
        }

        int l = 0, r = rocksReq.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(rocksReq[m] > additionalRocks) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public int maximumBagsOptimised(int[] capacity, int[] rocks, int additionalRocks) {
        long[] rocksReq = new long[capacity.length];
        for(int i=0; i<capacity.length; i++) {
            rocksReq[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(rocksReq);
        int bagsFilled = 0;
        for(int i=0; i<rocksReq.length && additionalRocks > 0; i++) {
            if(rocksReq[i] > additionalRocks) break;

            additionalRocks -= rocksReq[i];
            bagsFilled++;
        }

        return bagsFilled;
    }
}
