package daily.dec22;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day20KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;

        Queue<Integer> queue = new LinkedList<>(rooms.get(0));
        for(int nextRoom : rooms.get(0)) {
            visited[nextRoom] = true;
        }

        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for(int nextRoom : rooms.get(currRoom)) {
                if(!visited[nextRoom]) {
                    visited[nextRoom] = true;
                    queue.add(nextRoom);
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }
}
