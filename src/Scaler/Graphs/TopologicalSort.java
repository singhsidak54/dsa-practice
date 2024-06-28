package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopologicalSort {
    public int[] solve(int A, int[][] B) {
        int[] indDegree = new int[A+1];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : B) {
            indDegree[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
        }

        for(int i=1; i<=A; i++) {
            if(indDegree[i] == 0) pq.add(i);
        }

        int[] result = new int[A];
        int ptr = 0;

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            result[ptr++] = curr;
            for(int next : adjList.get(curr)) {
                indDegree[next]--;
                if(indDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        return ptr == A ? result : new int[] {};
    }
}
