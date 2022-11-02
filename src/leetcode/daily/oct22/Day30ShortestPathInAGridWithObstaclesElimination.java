package daily.oct22;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Day30ShortestPathInAGridWithObstaclesElimination {
    static class Node {
        int r;
        int c;
        int k;

        public Node(int r, int c, int k) {
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }

    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(visited[i], -1);
        }

        visited[0][0] = k;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, k));
        int dist = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();

                if(curr.r == m - 1 && curr.c == n - 1) {
                    return dist;
                }

                for(int[] dir : dirs) {
                    int r = curr.r + dir[0], c = curr.c + dir[1], kLeft = curr.k;
                    if(isValid(m, n, r, c)) {
                        if(grid[r][c] == 1) {
                            kLeft--;
                        }
                        if(kLeft >= 0 && kLeft > visited[r][c]) {
                            visited[r][c] = kLeft;
                            queue.add(new Node(r, c, kLeft));
                        }
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1},{0,1,0,0,0,0,0,0,0,0}, {0,1,1,1,1,1,1,1,1,0}};
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1}, {0,0,0}};
        System.out.println(shortestPath(grid, 1));
    }
}
