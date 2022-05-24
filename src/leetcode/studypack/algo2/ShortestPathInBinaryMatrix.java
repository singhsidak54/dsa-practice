package algo2;

import java.util.LinkedList;
import java.util.Queue;

class NodeGrid {
    int length;
    int[] coordinates;

    public NodeGrid(int length, int[] coordinates) {
        this.length = length;
        this.coordinates = coordinates;
    }
}

public class ShortestPathInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][0] == 1 || grid[rows-1][cols - 1] == 1) return -1;
        boolean[][] visited = new boolean[rows][cols];
        int shortestPath = Integer.MAX_VALUE;
        Queue<NodeGrid> queue = new LinkedList<>();
        queue.add(new NodeGrid(1, new int[] {0,0}));
        visited[0][0] = true;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {-1,-1}, {1,-1}, {1,1}, {-1,1}};
        while (!queue.isEmpty()) {
            NodeGrid temp = queue.poll();
            int r = temp.coordinates[0];
            int c = temp.coordinates[1];
            if(r == rows - 1 && c == cols -1 && grid[r][c] == 0 && temp.length < shortestPath) {
                shortestPath = temp.length;
            } else {
                for(int[] dir : dirs) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR >= 0 && newR < rows && newC >= 0 && newC < cols && !visited[newR][newC] &&grid[newR][newC] == 0) {
                        queue.add(new NodeGrid(temp.length + 1, new int[] {newR,newC}));
                        visited[newR][newC] = true;
                    }
                }
            }
        }
        return shortestPath == Integer.MAX_VALUE ? -1 : shortestPath;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
    }
}
