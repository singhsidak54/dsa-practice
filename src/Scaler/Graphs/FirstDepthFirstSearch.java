package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstDepthFirstSearch {
    public int solve(int[] A, final int B, final int C) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=0; i<A.length; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i=0; i<A.length; i++) {
            adjList.get(A[i]).add(i + 1);
        }

        boolean[] visited = new boolean[A.length + 1];
        return solve(adjList, C, B, visited);
    }

    public int solve(HashMap<Integer, ArrayList<Integer>> adjList, int from, int to, boolean[] visited) {
        if(from == to) return 1;

        visited[from] = true;
        for(int next : adjList.get(from)) {
            if(!visited[next] && solve(adjList, next, to, visited) == 1) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,3,3,2,2,7,6};
        FirstDepthFirstSearch obj = new FirstDepthFirstSearch();
        System.out.println(obj.solve(a, 9, 1));
    }
}
