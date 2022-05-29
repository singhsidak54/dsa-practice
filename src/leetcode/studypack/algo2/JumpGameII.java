package algo2;

public class JumpGameII {
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = -1;
        }
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
            for(int j=nums[i]; j>0; j--) {
                if(i+j >= n-1) {
                    dp[i] = 1;
                } else if (dp[i] == -1) {
                    dp[i] = 1 + dp[i + j];
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i + j]);
                }
            }
            if(dp[i] == -1) {
                dp[i] = 1001;
            }
        }

        return dp[0];
    }

    public static int jump2(int[] nums) {
        int n = nums.length;
        int currentEnd = 0, currentMax = 0, jump = 0;
        for(int i=0; i<n-1 && currentEnd <n-1; i++) {
            currentMax = Math.max(currentMax, i + nums[i]);
            if(currentEnd == i) {
                jump++;
                currentEnd = currentMax;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }
}
