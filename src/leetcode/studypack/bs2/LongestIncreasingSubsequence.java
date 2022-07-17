package bs2;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--) {
            dp[i] = 1;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int ans = 1;
        for(int num : dp) {
            if(num > ans) {
                ans = num;
            }
        }

        return ans;
    }

    // binary search method
    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int l, h, mid, size = 0;

        for(int num : nums) {
            l = 0;
            h = size;

            while (l < h) {
                mid = l + (h - l)/2;
                if(tails[mid] < num) {
                    l = mid + 1;
                } else {
                    h = mid;
                }
            }

            tails[l] = num;
            if(l == size) {
                size++;
            }
        }

        return size;
    }
}
