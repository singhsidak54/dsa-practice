package dp1;

import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--) {
            dp[i] = 1;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

    public static int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int l, h, size = 0, m;

        for(int num : nums) {
            l = 0;
            h = size;
            while (l < h) {
                m = l + (h - l)/2;
                if(tails[m] >= num) {
                    h = m;
                } else {
                    l = m + 1;
                }
            }

            tails[l] = num;
            if(l == size) {
                size++;
            }
        }

        return size;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS2(new int[] {7,7,7,7,7}));
    }
}
