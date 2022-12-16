package companies.Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
    public int dist(int x, int y, int x1, int y1) {
        return (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
    }

    public int minKnightMoves(int x, int y) {
        int[][] dirs = {{1,2}, {-1,2}, {-2,1}, {2,1}, {2,-1}, {-2,-1}, {1,-2},{-1,-2}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, dist(x, y, 0, 0)});
        HashSet<String> visited = new HashSet<>();
        visited.add("0-0");

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                if(curr[0] == x && curr[1] == y) {
                    return dist;
                }

                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0], c = curr[1] + dir[1];
                    if(visited.contains(r + "-" + c)) continue;

                    visited.add(r + "-" + c);
                    int newDist = dist(x, y, r, c);
                    if(newDist <= curr[2] + 4) {
                        queue.add(new int[] {r, c, newDist});
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}
