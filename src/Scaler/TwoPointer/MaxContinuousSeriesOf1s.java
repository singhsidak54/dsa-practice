package Scaler.TwoPointer;

import java.util.Arrays;

public class MaxContinuousSeriesOf1s {
    public static int[] maxone(int[] A, int B) {
        int n = A.length;
        int ans = 0, start = 0, end = 0;
        int wStart = 0, wEnd = 0, curr = B;
        while (wEnd < n) {
            if(A[wEnd] == 0) {
                while (wStart <= wEnd && curr <= 0) {
                    if(A[wStart] == 0) curr++;
                    wStart++;
                }

                curr--;
            }

            if(wEnd - wStart + 1 > ans) {
                ans = wEnd - wStart + 1;
                start = wStart;
                end = wEnd;
            }

            wEnd++;
        }

        int[] res = new int[end - start + 1];
        int ptr = 0;
        while (start <= end) {
            res[ptr++] = start++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 1, 1};
        System.out.println(Arrays.toString(maxone(A, 0)));
    }
}
