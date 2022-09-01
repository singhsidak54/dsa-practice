package gt1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    class Road {
        int target;
        boolean reversed;
        public Road(int target, boolean reversed) {
            this.target = target;
            this.reversed = reversed;
        }
    }

    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Road>> roads = new ArrayList<>();
        for(int i=0; i<n; i++) {
            roads.add(new ArrayList<>());
        }

        for(int[] connection : connections) {
            roads.get(connection[0]).add(new Road(connection[1], false));
            roads.get(connection[1]).add(new Road(connection[0], true));
        }

        int reversedCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int city = queue.poll();
            for(Road rd : roads.get(city)) {
                if(visited[rd.target]) continue;
                visited[rd.target] = true;
                queue.add(rd.target);
                if(!rd.reversed) reversedCount++;
            }
        }

        return reversedCount;
    }
}
