package algo2;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {
    //Using LCS
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n < m) return minDistance(word2, word1);

        int[] dp = new int[m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1, prevRow=0, prevRowPrevCol=0; j<=m; j++) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[j] = 1 + prevRowPrevCol;
                } else {
                    dp[j] = Math.max(dp[j-1], prevRow);
                }
            }
        }

        return n + m - 2 * dp[m];
    }

    public static int minDistanceDP(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++)
            dp[i][0] = i;

        for(int i=1; i<=m; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int minDistanceRecursive(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return minDistanceHelper(word1, word2, 0, 0, cache);
    }

    public static int minDistanceHelper(String word1, String word2, int index1, int index2, int[][] cache) {
        if(index1 == word1.length() && index2 == word2.length()) {
            return 0;
        } else if (index1 == word1.length()) {
            return word2.substring(index2).length();
        } else if (index2 == word2.length()) {
            return word1.substring(index1).length();
        } else if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        } else if(word1.charAt(index1) == word2.charAt(index2)) {
            cache[index1][index2] = minDistanceHelper(word1, word2, index1 + 1, index2 + 1, cache);
            return cache[index1][index2];
        } else {
            int option1 = minDistanceHelper(word1, word2, index1 + 1, index2, cache);
            int option2 = minDistanceHelper(word1, word2, index1, index2 + 1, cache);
            cache[index1][index2] = 1 + Math.min(option1, option2);
            return cache[index1][index2];
        }
    }

    public static void main(String[] args) {
        System.out.println(minDistanceRecursive("leetcode","etco"));
    }
}
