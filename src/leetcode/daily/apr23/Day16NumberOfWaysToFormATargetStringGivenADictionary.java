package daily.apr23;

import java.util.*;

public class Day16NumberOfWaysToFormATargetStringGivenADictionary {
    int mod = 1_000_000_007;
    int maxLen;

    public int backtrack(int[][] counts, String target, int targetIndex, int minIndex, Integer[][] dp) {
        if(targetIndex == target.length()) {
            return 1;
        }

        if(minIndex == maxLen) return 0;

        if(dp[targetIndex][minIndex] != null) {
            return dp[targetIndex][minIndex];
        }

        int idx = target.charAt(targetIndex) - 'a';
        int count = 0;

        if(counts[minIndex][idx] > 0) {
            int times = counts[minIndex][idx];

            long curr = backtrack(counts, target, targetIndex + 1, minIndex + 1, dp) * (long)times;
            curr = curr % mod;
            count = (count + (int)curr) % mod;
        }

        count = (count + backtrack(counts, target, targetIndex, minIndex + 1, dp)) % mod;

        dp[targetIndex][minIndex] = count;
        return dp[targetIndex][minIndex];
    }

    public int numWays(String[] words, String target) {
        maxLen = words[0].length();
        int[][] counts = new int[maxLen][26];

        for(int i=0; i<maxLen; i++) {
            for(String word : words) {
                counts[i][word.charAt(i) - 'a']++;
            }
        }

        Integer[][] dp = new Integer[target.length()][maxLen];

        return backtrack(counts, target, 0, 0, dp);
    }

    public static void main(String[] args) {
        Day16NumberOfWaysToFormATargetStringGivenADictionary obj = new Day16NumberOfWaysToFormATargetStringGivenADictionary();
        String[] words = {"acca","bbbb","caca"};
        System.out.println(obj.numWays(words, "aba"));
    }
}
