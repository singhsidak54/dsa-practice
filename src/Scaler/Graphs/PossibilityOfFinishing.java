package Scaler.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PossibilityOfFinishing {
    public int solve(int A, int[] B, int[] C) {
        int[] indDegree = new int[A+1];
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i=0; i<B.length; i++) {
            indDegree[C[i]]++;
            adjList.get(B[i]).add(C[i]);
        }

        for(int i=1; i<=A; i++) {
            if(indDegree[i] == 0) pq.add(i);
        }

        int done = 0;

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            done++;
            for(int next : adjList.get(curr)) {
                indDegree[next]--;
                if(indDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        return done == A ? 1 : 0;
    }
}
