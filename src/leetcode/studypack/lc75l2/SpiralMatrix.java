package lc75l2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int rowBegin = 0, rowEnd = m - 1, colBegin = 0, colEnd = n - 1;
        int dir = 0;
        while (res.size() < n * m) {
            switch (dir) {
                case 0:
                    //right
                    for(int i=colBegin; i<=colEnd; i++) {
                        res.add(matrix[rowBegin][i]);
                    }
                    rowBegin++;
                    break;
                case 1:
                    //down
                    for(int i=rowBegin; i<=rowEnd; i++) {
                        res.add(matrix[i][colEnd]);
                    }
                    colEnd--;
                    break;
                case 2:
                    //left
                    for(int i=colEnd; i>=colBegin; i--) {
                        res.add(matrix[rowEnd][i]);
                    }
                    rowEnd--;
                    break;
                case 3:
                    //up
                    for(int i=rowEnd; i>=rowBegin; i--) {
                        res.add(matrix[i][colBegin]);
                    }
                    colBegin++;
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
