package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Batches {

    public int dfs(HashMap<Integer, ArrayList<Integer>> adjList, int node, int[] strength, boolean[] visited) {
        int ans = strength[node - 1];
        visited[node] = true;
        for(int next : adjList.get(node)) {
            if(visited[next]) continue;
            ans += dfs(adjList, next, strength, visited);
        }

        return ans;
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        boolean[] visited = new boolean[A + 1];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : C) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int selected = 0;
        for(int i=1; i<=A; i++) {
            if(visited[i]) continue;
            int strength = dfs(adjList, i, B, visited);
            if(strength >= D) selected++;
        }

        return selected;
    }
}
