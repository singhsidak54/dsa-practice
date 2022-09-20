package lc75l2;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static boolean canPartitionHelper(int[] nums, int index, int cSum) {
        if(cSum == 0) return true;
        if(index == nums.length) return false;
        return canPartitionHelper(nums, index + 1, cSum - nums[index])
                || canPartitionHelper(nums, index + 1, cSum);
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;
        return canPartitionHelper(nums, 0, sum/2);
    }


    public static boolean canPartitionHelperDP(int[] nums, int index, int cSum, int[][] dp) {
        if(cSum == 0) return true;
        if(index == nums.length || cSum < 0) return false;

        if(dp[index][cSum] != -1) return dp[index][cSum] == 1;
        if(canPartitionHelperDP(nums, index + 1, cSum - nums[index], dp)
                || canPartitionHelperDP(nums, index + 1, cSum, dp)) {
             dp[index][cSum] = 1;
         } else {
             dp[index][cSum] = 0;
         }

         return dp[index][cSum] == 1;
    }

    public static boolean canPartitionDP(int[] nums) {
        int sum = 0;

        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        int[][] dp = new int[nums.length][sum/2+1];
        for(int i=0; i<nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return canPartitionHelperDP(nums, 0, sum/2, dp);
    }

    public static boolean canPartitionDPIterative(int[] nums) {
        int sum = 0, n = nums.length;

        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        sum = sum/2;

        boolean[][] dp = new boolean[n+1][sum+1];
        dp[0][0] = true;


        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        
        return dp[n][sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartitionDP(new int[] {2,2,1,1}));
    }
}
