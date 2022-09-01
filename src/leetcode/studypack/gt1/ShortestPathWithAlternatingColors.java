package gt1;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    class Edge {
        int target;
        int color;
        public Edge(int target, int color) {
            this.target = target;
            this.color = color;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] result = new int[n];
        boolean[][] visited = new boolean[2][n];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        visited[0][0] = true;
        visited[1][0] = true;

        List<List<Edge>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : redEdges) {
            neighbours.get(edge[0]).add(new Edge(edge[1], 0));
        }

        for(int[] edge : blueEdges) {
            neighbours.get(edge[0]).add(new Edge(edge[1], 1));
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        queue.add(new int[] {0, 1});
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                for(Edge e: neighbours.get(curr[0])) {
                    if(curr[1] != e.color && !visited[curr[1]][e.target]) {
                        visited[curr[1]][e.target] = true;
                        result[e.target] = Math.min(result[e.target], dist + 1);
                        queue.add(new int[] {e.target, e.color});
                    }
                }
            }
            dist++;
        }

        for(int i=0; i<n; i++) {
            if(result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }
}
