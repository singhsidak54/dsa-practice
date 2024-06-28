package daily.mar23;

import java.util.*;

public class Day25CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public int visit(int node, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        int members = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : graph.get(curr)) {
                if(visited[next]) continue;

                visited[next] = true;
                queue.add(next);
                members++;
            }
        }

        return members;
    }
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> groupSizes = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                groupSizes.add(visit(i, graph, visited));
            }
        }

        long ans = 0;
        for(int size : groupSizes) {
            ans += ((long) size * (n - size));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        Day25CountUnreachablePairsOfNodesInAnUndirectedGraph obj = new Day25CountUnreachablePairsOfNodesInAnUndirectedGraph();
        System.out.println(obj.countPairs(7, edges));
    }
}
