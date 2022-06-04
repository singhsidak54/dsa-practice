package algo2;


public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for(int i=n-2; i>=0; i--) {
            dp[i] = 1;
            for(int j=i+1; j<n; j++) {
                if(nums[j] < nums[i]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static int lengthOfLISBS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;

        for(int num : nums) {
            int l = 0, h = size;
            while(l < h) {
                int m = l + (h-l)/2;
                if(tails[m] < num) {
                    l = m + 1;
                } else {
                    h = m;
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
        System.out.println(lengthOfLISBS(new int[] {1,4,9,3,4,5,}));
    }
}