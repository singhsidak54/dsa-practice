package Scaler.Graphs;

public class ValidPath {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}, {1,1}, {-1,1}, {-1,-1}, {1,-1}};
    int m, n;

    public boolean isValid(int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public boolean dfs(boolean[][] grid, int r, int c, int x, int y) {
        if(r == x && c == y) return true;

        grid[r][c] = true;
        for(int[] dir : dirs) {
            int nR = r + dir[0], nC = c + dir[1];
            if(isValid(nR, nC) && !grid[nR][nC] && dfs(grid, nR, nC, x, y)) return true;
        }

        return false;
    }

    public String solve(int x, int y, int N, int R, int[] A, int[] B) {
        boolean[][] grid = new boolean[x + 1][y + 1];
        m = x + 1;
        n = y + 1;

        for(int i=0; i<=x; i++) {
            for(int j=0; j<=y; j++) {
                for(int k=0; k<N; k++) {
                    if(Math.pow(i - A[k], 2) + Math.pow(j - B[k], 2) <= Math.pow(R, 2)) {
                        grid[i][j] = true;
                        break;
                    }
                }
            }
        }

        if(grid[x][y] || grid[0][0]) return "NO";
        return dfs(grid, 0, 0, x, y) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        ValidPath obj = new ValidPath();
        System.out.println(obj.solve(14, 3, 9, 0, new int[] {3,3,0,11,8,11,14,8,4}, new int[] {1,0,2,2,0,2,3,2,1}));
    }
}
