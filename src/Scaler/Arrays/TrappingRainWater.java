package Scaler.Arrays;

public class TrappingRainWater {
    public static int trap(final int[] A) {
        int ans = 0;

        int l = 0, leftMax = Integer.MIN_VALUE, r = A.length - 1, rightMax = Integer.MIN_VALUE;

        while(l <= r) {
            if(leftMax < rightMax) {
                if(A[l] > leftMax) {
                    leftMax = A[l];
                } else {
                    ans += leftMax - A[l];
                }
                l++;
            } else {
                if(A[r] > rightMax) {
                    rightMax = A[r];
                } else {
                    ans += rightMax - A[r];
                }
                r--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
