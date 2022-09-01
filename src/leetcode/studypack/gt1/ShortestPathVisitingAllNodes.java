package gt1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public static int setBit(int mask, int i) {
        return (mask|(1<<i));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;

        int finalState = (1 << n) - 1;
        int[][] dist = new int[n][finalState + 1];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            Arrays.fill(dist[i], -1);
            int mask = (1<<i);
            queue.add(new int[] {i, mask});
            dist[i][mask] = 0;
        }

        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            if(head[1] == finalState) {
                return dist[head[0]][head[1]];
            }

            for(int neighbour : graph[head[0]]) {
                int newMask = setBit(head[1], neighbour);

                if(dist[neighbour][newMask] != -1) {
                    continue;
                }
                dist[neighbour][newMask] = dist[head[0]][head[1]] + 1;
                queue.add(new int[] {neighbour, newMask});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathLength(new int[][] {{1,2,3},{0},{0},{0}}));
    }
}
