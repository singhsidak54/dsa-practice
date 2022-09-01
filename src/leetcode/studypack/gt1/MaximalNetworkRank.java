package gt1;

import java.util.*;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, Set<Integer>> adjacencyList = new HashMap<>();
        for(int i=0; i<n; i++) {
            adjacencyList.put(i, new HashSet<>());
        }

        for(int[] road : roads) {
            adjacencyList.get(road[0]).add(road[1]);
            adjacencyList.get(road[1]).add(road[0]);
        }

        int maxRank = 0;
        for(int i=0; i<n; i++) {
            int aRank = adjacencyList.get(i).size();
            for(int j=0; j<n; j++) {
                if(i==j) continue;

                int currentRank = aRank + adjacencyList.get(j).size();
                if(adjacencyList.get(i).contains(j)) {
                    currentRank--;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        return maxRank;
    }
}
