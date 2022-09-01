package gt1;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for(int neighbour : graph[curr]) {
                        if(color[neighbour] == color[curr]) {
                            return false;
                        } else if (color[neighbour] == 0) {
                            queue.add(neighbour);
                            color[neighbour] = -color[curr];
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][] {{1,3},{0,2},{1,3},{0,2}}));
    }
}
