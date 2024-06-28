package daily.apr23;

import java.util.*;

public class Day9LargestColorValueInADirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int n = colors.length();
        for(int i=0; i<n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int nodesSeen = 0, answer = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            answer = Math.max(answer, ++count[curr][colors.charAt(curr) - 'a']);
            nodesSeen++;

            for(int next : adjList.get(curr)) {

                for(int i=0; i<26; i++) {
                    count[next][i] = Math.max(count[next][i], count[curr][i]);
                }

                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return nodesSeen == n ? answer : -1;
    }
}
