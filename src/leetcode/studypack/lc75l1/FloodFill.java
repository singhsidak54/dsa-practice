package lc75l1;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        if(image[sr][sc] == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        int[][] dirs = {{0,-1}, {-1, 0}, {0, 1}, {1,0}};
        queue.add(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(image[curr[0]][curr[1]] == oldColor) {
                image[curr[0]][curr[1]] = color;

                for(int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r < m && r >= 0 && c < n && c >= 0 && image[r][c] == oldColor) {
                        queue.add(new int[] {r, c});
                    }
                }
            }
        }

        return image;
    }
}
