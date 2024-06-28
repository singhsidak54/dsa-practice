package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B) {
            adjList.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == A) return 1;
            queue.addAll(adjList.get(curr));
        }

        return 0;
    }
}
