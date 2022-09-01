package gt1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfOperationsToMakeNetworkConnected {
    public void bfs(List<List<Integer>> neighbours, Queue<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            for(int nextIdx : neighbours.get(idx)) {
                if(visited[nextIdx]) {
                    continue;
                }
                queue.add(nextIdx);
                visited[nextIdx] = true;
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        boolean[] visited = new boolean[n];
        List<List<Integer>> neighbours = new ArrayList<>(n);

        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            neighbours.get(connection[0]).add(connection[1]);
            neighbours.get(connection[1]).add(connection[0]);
        }

        int components = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(visited[i]) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            bfs(neighbours, queue, visited);
            components++;
        }

        return components - 1;
    }
}
