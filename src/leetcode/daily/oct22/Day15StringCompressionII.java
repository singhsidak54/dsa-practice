package daily.oct22;

import java.util.Arrays;

public class Day15StringCompressionII {
    public int getLen(int l) {
        if(l == 1) return 1;
        if(l < 10) return 2;
        if(l < 100) return 3;
        return 4;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        int n  = s.length();
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(dp[i], n);
        }

        for(int i=1; i<=n; i++) {
            char c = s.charAt(i-1);
            for(int j=0; j<=k; j++) {
                if(j > 0) {
                    dp[i][j] = dp[i-1][j-1];
                }

                int same = 0, diff = 0;
                for(int l=i; l>=1; l--) {
                    if(s.charAt(l-1) == c) same++;
                    else diff++;

                    if(diff > j) break;

                    dp[i][j] = Math.min(dp[i][j], dp[l-1][j-diff] + getLen(same));
                }
            }
        }

        return dp[n][k];
    }
}
