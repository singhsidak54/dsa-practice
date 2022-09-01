package gt1;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] pt = queue.poll();
                mat[pt[0]][pt[1]] = dist;
                for(int[] dir : dirs) {
                    int r = dir[0] + pt[0], c = dir[1] + pt[1];
                    if(isValid(m, n, r, c) && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.add(new int[] {r, c});
                    }
                }
            }
            dist++;
        }

        return mat;
    }

    public static void main(String[] args) {
        System.out.println(updateMatrix(new int[][] {{0,0,0}, {0,1,0}, {1,1,1}}));
    }
}
