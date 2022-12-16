package daily.dec22;

import java.util.Arrays;

public class Day15LongestCommonSubsequence {
    public int longestCommonSubsequenceDP(String text1, String text2, int i, int j, int[][] dp) {
        if(i == text1.length() || j == text2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + longestCommonSubsequenceDP(text1, text2, i + 1, j + 1, dp);
        } else {
            int skipT1 = longestCommonSubsequenceDP(text1, text2, i + 1, j, dp);
            int skipT2 = longestCommonSubsequenceDP(text1, text2, i, j + 1, dp);
            ans = Math.max(skipT1, skipT2);
        }

        dp[i][j] = ans;
        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return longestCommonSubsequenceDP(text1, text2, 0, 0, dp);
    }
}
