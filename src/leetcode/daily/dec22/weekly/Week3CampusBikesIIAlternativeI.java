package daily.dec22.weekly;

import java.util.*;

public class Week3CampusBikesIIAlternativeI {
    int[] memo;

    public int distance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    public int assignBikesHelper(int[][] workers, int[][] bikes, int workerIndex, int mask) {
        if(workerIndex == workers.length) {
            return 0;
        }

        if(memo[mask] != -1) {
            return memo[mask];
        }

        int smallestDist = Integer.MAX_VALUE;
        for(int bikeIndex=0; bikeIndex<bikes.length; bikeIndex++) {
            if((mask & (1 << bikeIndex)) == 0) {
                int newMask = mask | (1 << bikeIndex);
                int currBikeWorkerDistance = distance(workers[workerIndex], bikes[bikeIndex]);
                smallestDist = Math.min(smallestDist, currBikeWorkerDistance + assignBikesHelper(workers, bikes, workerIndex + 1, newMask));
            }
        }
        memo[mask] = smallestDist;
        return memo[mask];
    }

    public int assignBikes(int[][] workers, int[][] bikes) {
        int maxMaskValue = (int) Math.pow(2, bikes.length);
        memo = new int[maxMaskValue];
        Arrays.fill(memo, -1);
        assignBikesHelper(workers, bikes, 0, 0);
        return assignBikesHelper(workers, bikes, 0, 0);
    }

    public int countOnes(int mask) {
        int count = 0;
        while (mask != 0) {
            mask &= (mask - 1);
            count++;
        }

        return count;
    }

    public int assignBikesPriorityQueue(int[][] workers, int[][] bikes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        pq.add(new int[] {0, 0});

        while(!pq.isEmpty()) {
            int[] currentEntry = pq.poll();

            if(visited.contains(currentEntry[1])) continue;
            visited.add(currentEntry[1]);

            int workerIndex = countOnes(currentEntry[1]);

            if(workerIndex == workers.length) {
                return currentEntry[0];
            }

            for(int bikerIndex=0; bikerIndex<bikes.length; bikerIndex++) {
                if((currentEntry[1] & (1 << bikerIndex)) == 0) {
                    int nextMask = (currentEntry[1] | (1 << bikerIndex));

                    int newCost = currentEntry[0] + distance(workers[workerIndex], bikes[bikerIndex]);
                    pq.add(new int[] {newCost, nextMask});
                }
            }
        }

        return -1;
    }
}
