package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructRoads {
    int set1, set2;

    public void dfs(int curr, int from, HashMap<Integer, List<Integer>> adjList, int[] visited) {
        if(from == 1) {
            visited[curr] = 2;
            set2++;
        } else {
            visited[curr] = 1;
            set1++;
        }

        for(int next : adjList.get(curr)) {
            if(visited[next] == 0) {
                dfs(next, visited[curr], adjList, visited);
            }
        }
    }

    public int solve(int A, int[][] B) {
        set1 = 0;
        set2 = 0;
        int mod = 1_000_000_007;
        int[] visited = new int[A + 1];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int i=1; i<=A; i++) {
            if(visited[i] == 0) {
                dfs(i, -1, adjList, visited);
            }
        }

        return (int)(((long)set1 * set2 - (A - 1)) % mod);
    }

    public static void main(String[] args) {
        ConstructRoads obj = new ConstructRoads();
        int[][] mat = {{2,1}};
        System.out.println(obj.solve(2, mat));
    }
}