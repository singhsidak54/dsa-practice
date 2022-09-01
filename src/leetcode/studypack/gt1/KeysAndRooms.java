package gt1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for(int nextRoom : rooms.get(currRoom)) {
                if(visited[nextRoom]) continue;
                queue.add(nextRoom);
                visited[nextRoom] = true;
            }
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }
}
