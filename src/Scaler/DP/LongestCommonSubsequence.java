package Scaler.DP;

public class LongestCommonSubsequence {
    public int solve(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for(int i=1; i<=A.length(); i++) {
            for(int j=1; j<=B.length(); j++) {
                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);

                if(a == b) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[A.length()][B.length()];
    }
}
