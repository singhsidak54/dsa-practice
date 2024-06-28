package daily.mar23;

import java.util.*;

public class Day24ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> neighbours = new HashMap<>();

        for(int i=0; i<n; i++) {
            neighbours.put(i, new ArrayList<int[]>());
        }

        for(int[] connection : connections) {
            neighbours.get(connection[0]).add(new int[] {connection[1], 0});
            neighbours.get(connection[1]).add(new int[] {connection[0], 1});
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int reversed = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int[] next : neighbours.get(curr)) {
                if(visited[next[0]]) continue;
                visited[next[0]] = true;
                queue.add(next[0]);
                if(next[1] == 0) {
                    reversed++;
                }
            }
        }

        return reversed;
    }
}
