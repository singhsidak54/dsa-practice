package Scaler.Backtracking;

public class UniquePathsIII {

    int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    public boolean allCovered(int[][] A, boolean[][] visited) {

        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[i].length; j++) {
                if(A[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public int helper(int[][] A, int row, int col, boolean[][] visited) {
        if(A[row][col] == -1) return 0;

        if(A[row][col] == 2) {
            return allCovered(A, visited) ? 1 : 0;
        } else {
            int count = 0;
            visited[row][col] = true;
            for(int[] dir : dirs) {
                int nextR = row + dir[0], nextC = col + dir[1];

                if(nextR < 0 || nextR >= A.length || nextC < 0 || nextC >= A[nextR].length
                        || A[nextR][nextC] == -1 || visited[nextR][nextC]) {
                    continue;
                }

                count += helper(A, nextR, nextC, visited);
            }

            visited[row][col] = false;
            return count;
        }
    }

    public int solve(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                if(A[i][j] == 1) {
                    return helper(A, i, j, visited);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0}, {0,0,0}, {0,2,-1}};
        UniquePathsIII obj = new UniquePathsIII();
        System.out.println(obj.solve(grid));
    }
}
