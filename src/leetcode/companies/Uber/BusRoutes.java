package companies.Uber;

import java.util.*;

public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        HashMap<Integer, Set<Integer>> cityBuses = new HashMap<>();
        boolean[] busTaken = new boolean[routes.length];
        Set<Integer> cityVisited = new HashSet<>();

        for(int i=0; i<routes.length; i++) {
            for(int j=0; j<routes[i].length; j++) {
                cityBuses.putIfAbsent(routes[i][j], new HashSet<>());
                cityBuses.get(routes[i][j]).add(i);
            }
        }

        if(cityBuses.get(source) == null) return -1;
        Queue<Integer> busQueues = new LinkedList<>();
        for(int bus : cityBuses.get(source)) {
            busQueues.add(bus);
            busTaken[bus] = true;
        }

        cityVisited.add(source);
        int dist = 1;
        while (!busQueues.isEmpty()) {
            int size = busQueues.size();
            for(int i=0; i<size; i++) {
                int curr = busQueues.poll();
                for(int nextCity : routes[curr]) {
                    if(nextCity == target) {
                        return dist;
                    }

                    if(cityVisited.contains(nextCity)) continue;

                    cityVisited.add(nextCity);
                    for(int nextBus : cityBuses.get(nextCity)) {
                        if(!busTaken[nextBus]) {
                            busTaken[nextBus] = true;
                            busQueues.add(nextBus);
                        }
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}
