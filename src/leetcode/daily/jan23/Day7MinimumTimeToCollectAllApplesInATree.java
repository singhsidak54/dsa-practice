package daily.jan23;

import java.util.ArrayList;
import java.util.List;

public class Day7MinimumTimeToCollectAllApplesInATree {
    static int edgesUsed;
    public static boolean minTime(List<List<Integer>> neighbours, int vertex, List<Boolean> hasApple, boolean[] visited) {
        if(visited[vertex]) return false;

        visited[vertex] = true;
        boolean used = hasApple.get(vertex);
        for(int neighbour : neighbours.get(vertex)) {
            boolean isNeighbourUsed = minTime(neighbours, neighbour, hasApple, visited);
            used = used || isNeighbourUsed;
        }

        if(used) edgesUsed++;
        return used;
    }

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        edgesUsed = 0;
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        minTime(neighbours, 0, hasApple, visited);
        return edgesUsed > 0 ? (edgesUsed - 1) * 2 : 0;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApples = new ArrayList<>();
        hasApples.add(false);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(false);
        hasApples.add(true);
        hasApples.add(true);
        hasApples.add(false);

        System.out.println(minTime(7, edges, hasApples));

    }
}
