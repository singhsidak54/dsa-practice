package daily.dec22;

import java.util.*;

public class Day21PossibleBipartition {
    public static boolean visit(HashMap<Integer, List<Integer>> dislikeGraph, int node, boolean[] visited, int[] group) {
        visited[node] = true;
        group[node] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for(int dislike : dislikeGraph.get(currNode)) {
                if(group[currNode] == group[dislike]) {
                    return false;
                }

                if(visited[dislike]) continue;
                group[dislike] = -group[currNode];
                visited[dislike] = true;
                queue.add(dislike);
            }
        }

        return true;
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> dislikeGraph = new HashMap<>();

        for(int i=1; i<=n; i++) {
            dislikeGraph.put(i, new ArrayList<>());
        }

        for(int[] dislike : dislikes) {
            dislikeGraph.get(dislike[0]).add(dislike[1]);
            dislikeGraph.get(dislike[1]).add(dislike[0]);
        }

        boolean[] visited = new boolean[n + 1];
        int[] group = new int[n + 1];

        for(int i=1; i<=n; i++) {
            if(!visited[i] && !visit(dislikeGraph, i, visited, group)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] dislikes = {{1,2}, {1,3}, {2,3}};
        System.out.println(possibleBipartition(3, dislikes));
    }
}
