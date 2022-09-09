package dp1;

public class LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int maxLen = 1;
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
            if(i != n-1) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    dp[i][i+1] = 2;
                    maxLen = 2;
                } else {
                    dp[i][i+1] = 1;
                }
            }
        }


        for(int len=3; len<=n; len++) {
            for(int i=0; i+len<=n; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aabaa"));
    }
}
