package daily.dec22;

import java.util.ArrayList;
import java.util.List;

public class Day19FindIfPathExistsInGraph {
    public boolean dfs(List<List<Integer>> edges, int node, int target, boolean[] visited) {
        if(node == target) return true;

        visited[node] = true;
        for(int neighbour : edges.get(node)) {
            if(!visited[neighbour] && dfs(edges, neighbour, target, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];

        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        return dfs(neighbours, source, destination, visited);
    }
}
