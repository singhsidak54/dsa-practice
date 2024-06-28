package Scaler.Contest.AdvancedDSA7;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCell {
    public static boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public int[][] solve(int[][] A) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i][j] == 1) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] pt = queue.poll();
                A[pt[0]][pt[1]] = dist;
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

        return A;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,1,1,0}, {1,1,1,0,0,0}};
        DistanceOfNearestCell obj = new DistanceOfNearestCell();
        int[][] res = obj.solve(arr);
        System.out.println('a');
    }
}
