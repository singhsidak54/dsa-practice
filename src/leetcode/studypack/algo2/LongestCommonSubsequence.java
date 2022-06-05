package algo2;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequenceRecursive(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequenceHelper(text1, text2, 0 ,0, dp);
    }

    public static int longestCommonSubsequenceHelper(String text1, String text2, int index1, int index2, int[][] dp) {
        if(index1 == text1.length() || index2 == text2.length())
            return 0;

        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        if(text1.charAt(index1) == text2.charAt(index2)) {
            dp[index1][index2] = 1 + longestCommonSubsequenceHelper(text1, text2, index1 + 1, index2 + 1,dp);
        } else {
            int longestSeq1 = longestCommonSubsequenceHelper(text1, text2, index1 + 1, index2, dp);
            int longestSeq2 = longestCommonSubsequenceHelper(text1, text2, index1, index2 + 1, dp);
            dp[index1][index2] = Math.max(longestSeq1, longestSeq2);
        }
        return dp[index1][index2];
    }

    public static int longestCommonSubsequenceIterative(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int longestCommonSubsequenceIterativeOptimised(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        if(n < m) return longestCommonSubsequenceIterativeOptimised(text2, text1);
        int[] dp = new int[m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1, prevRow = 0, prevRowPrevCol = 0; j<=m; j++) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[j] = 1 + prevRowPrevCol;
                } else {
                    dp[j] = Math.max(dp[j-1], prevRow);
                }
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceRecursive("abc", "def"));
    }
}
