package daily.mar23;

import java.util.*;

public class Day23NumberOfOperationsToMakeNetworkConnected {
    public void visit(int node, boolean[] visited, HashMap<Integer, List<Integer>> graph) {
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph.get(curr)) {
                if(visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();;
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] con : connections) {
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }

        int connected = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                connected++;
                visit(i, visited, graph);
            }
        }

        return connected - 1;
    }
}
