package lc75l2;

import java.util.LinkedList;
import java.util.Queue;

public class MostStonesRemovedWithSameRowOrColumn {
    public void visit(int[][] stones, boolean[] visited, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(stones[index]);
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
        int n = stones.length;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                connectedComponents++;
                visited[i] = true;
                visit(stones, visited, i);
            }
        }

        return n - connectedComponents;
    }
}
