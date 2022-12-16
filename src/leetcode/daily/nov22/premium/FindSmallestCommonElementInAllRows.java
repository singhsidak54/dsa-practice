package daily.nov22.premium;

public class FindSmallestCommonElementInAllRows {
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] pointers = new int[m];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<m; i++) {
            max = Math.max(max, mat[i][0]);
        }

        int currentMax = max;
        do {
            max = currentMax;
            for(int i=0; i<m; i++) {
                int pointer = pointers[i];
                while (pointer < n && mat[i][pointer] < currentMax) {
                    pointer++;
                }

                if(pointer == n) {
                    return -1;
                }
                pointers[i] = pointer;
                currentMax = Math.max(currentMax, mat[i][pointer]);
            }
        } while (currentMax != max);

        return currentMax;
    }
}
