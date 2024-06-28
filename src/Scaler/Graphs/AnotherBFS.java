package Scaler.Graphs;

import java.util.*;

public class AnotherBFS {
    public int solve(int A, int[][] B, int C, int D) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for(int i=0; i<A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B) {
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        int[] visited = new int[A];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[C] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { C, 0 });

        int minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[0] == D) {
                minDist = Math.min(minDist, curr[1]);
                continue;
            }

            for(int[] next : adjList.get(curr[0])) {
                int nextDist = curr[1] + next[1];
                if(visited[next[0]] <= nextDist) continue;
                visited[next[0]] = nextDist;
                int[] nextItem = { next[0], nextDist };
                queue.add(nextItem);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
