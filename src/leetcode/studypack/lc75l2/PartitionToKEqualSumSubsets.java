package lc75l2;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    public static boolean canPartitionKSubsets(int[] nums, int index, int currSum, boolean[] visited, int reqSum, int k) {
        if(k == 0) return true;
        if(currSum == reqSum) return canPartitionKSubsets(nums, nums.length - 1, 0, visited, reqSum, k - 1);

        for(int i=index; i>=0; i--) {
            if(!visited[i] && currSum + nums[i] <= reqSum) {
                visited[i] = true;
                if(canPartitionKSubsets(nums, i - 1, currSum + nums[i], visited, reqSum, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length, sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean[] visited = new boolean[n];
        if(sum % k != 0) return false;
        int reqSum = sum/k;
        Arrays.sort(nums);
        return canPartitionKSubsets(nums,n - 1, 0, visited, reqSum, k);
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[] {2,2}, 1));
    }
}
