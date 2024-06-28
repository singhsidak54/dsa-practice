package Scaler.Contest.AdvancedDSA7;

import java.util.*;

public class MinimumSemestersNeeded {
    public int minimumSemesters(int A, int[][] B) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=1; i<=A; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[A + 1];
        for(int[] edge : B) {
            inDegree[edge[1]]++;
            adjList.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int semestersNeeded = 0;
        for(int i=1; i<=A; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                for(int next : adjList.get(curr)) {
                    inDegree[next]--;
                    if(inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
            semestersNeeded++;
        }

        return semestersNeeded;
    }
}
