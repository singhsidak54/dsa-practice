package lc75l1;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=m-1; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                dp[j] += dp[j+1];
            }
        }

        return dp[0];
    }
}
