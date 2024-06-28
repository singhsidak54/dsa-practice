package Scaler.BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public boolean isPossible(int[] A, int dist, int cows) {
        int cowsPlaced = 1;
        int i = 0;
        while (cowsPlaced < cows && i < A.length - 1) {
            int j = i;
            while (j < A.length && A[j] - A[i] < dist) {
                j++;
            }

            if(j == A.length) break;

            cowsPlaced++;
            i = j;
        }

        return cowsPlaced == cows;
    }

    public int solve(int[] A, int B) {
        Arrays.sort(A);

        int l = 1, r = A[A.length - 1] + 1, m;
        while (l < r) {
            m = r - (r - l)/2;
            if(isPossible(A, m, B)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        AggressiveCows obj = new AggressiveCows();
        int[] pos = {1,2};
        System.out.println(obj.solve(pos, 2));
    }
}
