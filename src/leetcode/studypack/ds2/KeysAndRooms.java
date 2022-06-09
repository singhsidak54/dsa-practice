package ds2;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            visited[room] = true;
            for(int key : rooms.get(room)) {
                if(!visited[key]) {
                    stack.add(key);
                }
            }
        }

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
