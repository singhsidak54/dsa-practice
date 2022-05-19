package ds2;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int layers = (n + 1) / 2;
        int count = 1;
        for(int layer=0; layer<layers; layer++) {

            for(int i=layer; i<n-layer; i++) {
                result[layer][i] = count++;
            }

            for(int i=layer+1; i<n-layer; i++) {
                result[i][n-1-layer] = count++;
            }

            for(int i=n-layer-2; i>=layer; i--) {
                result[n-1-layer][i] = count++;
            }

            for(int i=n-layer-2; i>layer; i--) {
                result[i][layer] = count++;
            }
        }
        return result;
    }

    public int[][] generateMatrix2(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int row = 0, col = 0, d = 0;
        while(count <= n*n) {
            result[row][col] = count++;
            int r  = Math.floorMod(row + dirs[d][0], n);
            int c = Math.floorMod(col + dirs[d][1], n);

            if(result[r][c] != 0)
                d = (d + 1) % 4;

            row = row + dirs[d][0];
            col = col + dirs[d][1];
        }
        return result;
    }
}
