package Scaler.Graphs;

import java.util.*;

public class CycleInDirectedGraph {
    public int dfs(int idx, HashMap<Integer, ArrayList<Integer>> adjList, Set<Integer> visited) {
        if(visited.contains(idx)) return 1;

        visited.add(idx);
        for(int next : adjList.get(idx)) {
            if(dfs(next, adjList, visited) == 1) return 1;
        }

        visited.remove(idx);
        return 0;
    }

    public int solve(int A, int[][] B) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
        }

        for(int i=1; i<=A; i++) {
            if(dfs(i, adjList, new HashSet<>()) == 1) return 1;
        }

        return 0;
    }
}
