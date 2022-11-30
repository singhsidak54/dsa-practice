package daily.nov22;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Day14MostStonesRemovedWithSameRowOrColumn {
    public void visit(int[][] stones, int index, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(stones[index]);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int i=0; i<stones.length; i++) {
                if(!visited[i] && (stones[i][0] == curr[0] || stones[i][1] == curr[1])) {
                    visited[i] = true;
                    queue.add(stones[i]);
                }
            }
        }
    }

    public int removeStones(int[][] stones) {
        int connectedComponents = 0;
        boolean[] visited = new boolean[stones.length];

        for(int i=0; i<stones.length; i++) {
            if(!visited[i]) {
                visit(stones, i, visited);
                connectedComponents++;
            }
        }

        return stones.length - connectedComponents;
    }
}
