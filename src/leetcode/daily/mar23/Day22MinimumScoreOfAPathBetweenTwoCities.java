package daily.mar23;

import java.util.*;

public class Day22MinimumScoreOfAPathBetweenTwoCities {
    int min;
    HashMap<Integer, List<int[]>> neighbours;
    Set<Integer> visited;

    public void dfs(int city) {
        visited.add(city);

        for(int[] neighbour : neighbours.get(city)) {
            min = Math.min(min, neighbour[1]);
            if(!visited.contains(neighbour[0])) {
                dfs(neighbour[0]);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        min = Integer.MAX_VALUE;
        neighbours = new HashMap<>();
        visited = new HashSet<>();

        for(int[] road : roads) {
            if(!neighbours.containsKey(road[0])) {
                neighbours.put(road[0], new ArrayList<>());
            }

            if(!neighbours.containsKey(road[1])) {
                neighbours.put(road[1], new ArrayList<>());
            }

            neighbours.get(road[0]).add(new int[] {road[1], road[2]});
            neighbours.get(road[1]).add(new int[] {road[0], road[2]});
        }

        dfs(1);
        return min;
    }
}
