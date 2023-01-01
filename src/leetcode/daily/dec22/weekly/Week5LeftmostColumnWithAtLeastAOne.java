package daily.dec22.weekly;

import java.util.List;

public class Week5LeftmostColumnWithAtLeastAOne { 
    interface BinaryMatrix {
        public int get(int row, int col);
        public List<Integer> dimensions();
    };

    public int getLeftMostForRow(BinaryMatrix binaryMatrix, int row, int right) {
        int left = 0, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if(binaryMatrix.get(row, mid) == 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int right = cols;
        for(int i=0; i<rows; i++) {
            right = Math.min(right, getLeftMostForRow(binaryMatrix, i, right));
        }

        return right == cols ? -1 : right;
    }
}
