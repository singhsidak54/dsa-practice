package algo1;

import java.util.Arrays;

// Problem Link - https://leetcode.com/problems/squares-of-a-sorted-array/
public class SquaresOfASortedArray {
    public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, h = nums.length - 1;
        int k = nums.length - 1;
        while (l <= h) {
            if(Math.abs(nums[l]) > Math.abs(nums[h])) {
                ans[k--] = nums[l] * nums[l];
                l++;
            } else {
                ans[k--] = nums[h] * nums[h];
                h--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-5,-3,-2,-1};
        System.out.println(Arrays.toString(sortedSquares(a)));
    }
}
