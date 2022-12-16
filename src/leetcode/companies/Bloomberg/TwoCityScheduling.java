package companies.Bloomberg;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diffO1 = o1[0] - o1[1];
                int diffO2 = o2[0] - o2[1];
                return Integer.compare(diffO1, diffO2);
            }
        });

        pq.addAll(Arrays.stream(costs).toList());

        int totalCost = 0, n = costs.length/2;
        for(int i=0; i<n; i++) {
            totalCost += pq.poll()[0];
        }

        for(int i=0; i<n; i++) {
            totalCost += pq.poll()[1];
        }

        return totalCost;
    }

    public int twoCitySchedCostSpaceOptimised(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0] - o1[1], o2[0] - o2[1]);
            }
        });

        int totalCost = 0, n = costs.length/2;
        for(int i=0; i<n; i++) {
            totalCost += costs[i][0] + costs[i + n][1];
        }

        return totalCost;
    }
}
