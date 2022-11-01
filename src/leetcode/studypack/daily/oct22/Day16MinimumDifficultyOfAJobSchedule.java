package daily.oct22;

import java.util.Arrays;

public class Day16MinimumDifficultyOfAJobSchedule {
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[d][n];

        dp[0][0] = jobDifficulty[0];
        for(int i=1; i<n; i++) {
            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i-1]);
        }


        for(int i=1; i<d; i++) {
            for(int localLastJob=i; localLastJob<n; localLastJob++) {
                int localMax = jobDifficulty[localLastJob];
                dp[i][localLastJob] = Integer.MAX_VALUE;
                for(int localFirstJob=localLastJob; localFirstJob>=i; localFirstJob--) {
                    localMax = Math.max(localMax, jobDifficulty[localFirstJob]);
                    dp[i][localLastJob] = Math.min(dp[i][localLastJob], dp[i-1][localFirstJob - 1] + localMax);
                }
            }
        }

        return dp[d-1][n-1];
    }

    public static int minDifficultyRecursion(int[] jobDifficulty, int len, int daysLeft, int[][] dp) {
        if(daysLeft == 0 && len == jobDifficulty.length) return 0;
        if(daysLeft == 0 || len == jobDifficulty.length) return Integer.MAX_VALUE;
        if(dp[daysLeft][len] != -1) return dp[daysLeft][len];

        int currMax = jobDifficulty[len];
        dp[daysLeft][len] = Integer.MAX_VALUE;
        for(int localLastJob=len; localLastJob<jobDifficulty.length; localLastJob++) {
            currMax = Math.max(jobDifficulty[localLastJob], currMax);
            int temp = minDifficultyRecursion(jobDifficulty, localLastJob + 1, daysLeft - 1, dp);
            if(temp != Integer.MAX_VALUE) {
                dp[daysLeft][len] = Math.min(dp[daysLeft][len], currMax + temp);
            }
        }

        return dp[daysLeft][len];
    }
    public static int minDifficultyRecursion(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[d+1][n];
        for(int i=0; i<=d; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minDifficultyRecursion(jobDifficulty, 0, d, dp);
    }
    public static void main(String[] args) {
        System.out.println(minDifficultyRecursion(new int[] {11,111,22,222,33,333,44,444}, 6));
    }
}
