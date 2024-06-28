package Scaler.DP;

public class EditDistance {
    public int minDistance(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for(int i=0; i<=A.length(); i++) {
            dp[i][0] = i;
        }

        for(int j=0; j<=B.length(); j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=A.length(); i++) {
            for(int j=1; j<=B.length(); j++) {
                 char a = A.charAt(i - 1), b = B.charAt(j - 1);
                 if(a == b) {
                     dp[i][j] = dp[i - 1][j - 1];
                 } else {
                     int replace = dp[i - 1][j - 1];
                     int delete = dp[i][j - 1];
                     int insert = dp[i - 1][j];
                     dp[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
                 }
            }
        }

        return dp[A.length()][B.length()];
    }
}
