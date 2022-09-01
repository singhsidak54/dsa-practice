package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public void visit(int[][] isConnected, Queue<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if(visited[idx]) continue;

            for(int i=0; i<isConnected[idx].length; i++) {
                if(isConnected[idx][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, nProvinces = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;

            nProvinces++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            visit(isConnected, queue, visited);
        }

        return nProvinces;
    }
}
