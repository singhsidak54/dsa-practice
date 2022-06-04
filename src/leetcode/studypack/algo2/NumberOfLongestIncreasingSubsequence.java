package algo2;

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int result = 0;
        int maxLength = 0;
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for(int i=n-1; i>=0; i--) {
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=i+1; j<n; j++) {
                if(nums[i] < nums[j]) {
                    int currentLength = 1 + dp[j];
                    if(currentLength == dp[i]) {
                        cnt[i] += cnt[j];
                    } else if (currentLength > dp[i]) {
                        dp[i] = currentLength;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(dp[i] == maxLength) {
                result += cnt[i];
            } else if (dp[i] > maxLength) {
                result = cnt[i];
                maxLength = dp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[] {1,3,5,4,7}));
    }
}
