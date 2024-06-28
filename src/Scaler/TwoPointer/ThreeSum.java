package Scaler.TwoPointer;

import java.util.Arrays;

public class ThreeSum {
    public static int[] closest(int[] A, int req, int index) {
        int l = index, r = A.length - 1;
        int left = -1, right = -1, ans = Integer.MAX_VALUE;
        while(l < r) {
            int currSum = A[l] + A[r];
            if(Math.abs(req - currSum) < ans) {
                left = l;
                right = r;
                ans = Math.abs(req - currSum);
            }
            if(currSum > req) {
                r--;
            } else {
                l++;
            }
        }

        return new int[] {left, right};
    }

    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int ans = 100000000;

        for(int i=0; i<A.length-2; i++) {
            int req = B - A[i];
            int[] res = closest(A, req, i + 1);

            int sum = A[i] + A[res[0]] + A[res[1]];
            if(Math.abs(B - ans) > Math.abs(B - sum)) {
                ans = sum;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {7, 2, -5, 10, -3, 4, 9, 1, -6, -10};
        System.out.println(threeSumClosest(A, 2));
    }
}
