package lc75l2;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        boolean[] visited = new boolean[routes.length];
        Queue<int[]> queue = new LinkedList<>();

        HashMap<Integer, ArrayList<Integer>> cityBuses = new HashMap<>();

        for(int i=0; i<routes.length; i++) {
            for(int j=0; j<routes[i].length; j++) {
                if(!cityBuses.containsKey(routes[i][j])) {
                    cityBuses.put(routes[i][j], new ArrayList<>());
                }
                cityBuses.get(routes[i][j]).add(i);

                if(routes[i][j] == source) {
                    queue.add(new int[] {i, 1});
                    visited[i] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int city : routes[curr[0]]) {
                if(city == target) return curr[1];

                for(int bus : cityBuses.get(city)) {
                    if(visited[bus]) continue;

                    visited[bus] = true;
                    queue.offer(new int[] {bus, curr[1] + 1});
                }
            }
        }

        return -1;
    }
}
