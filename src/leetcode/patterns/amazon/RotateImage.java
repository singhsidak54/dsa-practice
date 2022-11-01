package patterns.amazon;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int level = 0;

        while (level < n) {

            int i=level, first, next;

            while (i < n - 1 - level) {
                int row = i, col = n - 1 - i;

                first = matrix[level][i];
                next = matrix[row][col];
                matrix[row][col] = first;

                row = m - 1 - level;
                col = n - 1 - i;
                first = next;
                next = matrix[row][col];
                matrix[row][col] = first;

                row = m - 1 - i;
                col = level;
                first = next;
                next = matrix[row][col];
                matrix[row][col] = first;

                matrix[level][i] = next;
                i++;
            }
            level++;
        }
    }

    public static void main(String[] args) {
        int[][] mtx = new int[][] {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate(mtx);
        System.out.println(mtx);
    }
}
