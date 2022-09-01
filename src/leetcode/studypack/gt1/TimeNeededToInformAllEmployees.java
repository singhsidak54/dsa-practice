package gt1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    public int totalTimeTaken(List<List<Integer>> neighbours, int[] informTime, int currHead, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {currHead, 0});
        int timeTaken = 0;
        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            for(int employee : neighbours.get(idx[0])) {
                if(visited[employee]) continue;
                queue.add(new int[] {employee, idx[1] + informTime[idx[0]]});
                visited[employee] = true;
            }
            timeTaken = Math.max(timeTaken, idx[1]);
        }
        return timeTaken;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> neighbours = new ArrayList<>();
        boolean[] informed = new boolean[n];
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int i=0; i<manager.length; i++) {
            if(i == headID) continue;
            neighbours.get(manager[i]).add(i);
        }

        return totalTimeTaken(neighbours, informTime, headID, informed);
    }
}
