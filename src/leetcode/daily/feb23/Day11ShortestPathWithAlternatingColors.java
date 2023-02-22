package daily.feb23;

import java.util.*;

public class Day11ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        boolean[][] visited = new boolean[n][2];
        Arrays.fill(ans, -1);
        ans[0] = 0;

        HashMap<Integer, List<Integer>[]> adjMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<Integer>[] edges = new List[2];
            edges[0] = new ArrayList<>();
            edges[1] = new ArrayList<>();
            adjMap.put(i, edges);
        }

        for(int[] edge : redEdges) {
            adjMap.get(edge[0])[0].add(edge[1]);
        }

        for(int[] edge : blueEdges) {
            adjMap.get(edge[0])[1].add(edge[1]);
        }

        Queue<int[]> queue = new LinkedList<>();
        int filled = 1;
        visited[0][0] = true;
        visited[0][1] = true;
        for(int neighbour : adjMap.get(0)[0]) {
            visited[neighbour][0] = true;
            queue.add(new int[] {neighbour, 1});
        }

        for(int neighbour : adjMap.get(0)[1]) {
            visited[neighbour][1] = true;
            queue.add(new int[] {neighbour, 0});
        }

        int dist = 1;
        while (!queue.isEmpty() && filled != n) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                if(ans[curr[0]] != -1) {
                    continue;
                }

                ans[curr[0]] = dist;
                filled++;
                if(curr[1] == 1) {
                    for(int neighbour : adjMap.get(curr[0])[1]) {
                        if(visited[neighbour][1]) continue;
                        visited[neighbour][1] = true;
                        queue.add(new int[] {neighbour, 0});
                    }
                } else {
                    for(int neighbour : adjMap.get(curr[0])[0]) {
                        if(visited[neighbour][0]) continue;
                        visited[neighbour][0] = true;
                        queue.add(new int[] {neighbour, 1});
                    }
                }
            }
            dist++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Day11ShortestPathWithAlternatingColors obj = new Day11ShortestPathWithAlternatingColors();
        int[][] re = {{0,1}, {1,2}};
        int[][] be = {};

        System.out.println(Arrays.toString(obj.shortestAlternatingPaths(3, re, be)));
    }
}
