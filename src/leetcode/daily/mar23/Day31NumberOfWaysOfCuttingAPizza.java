package daily.mar23;

import java.util.Arrays;

public class Day31NumberOfWaysOfCuttingAPizza {

    public static int dp(String[] pizza, int[][][] dp, int row, int col, int cuts) {
        if(cuts == 0) {
            return 1;
        }

        if(row == dp.length || col == dp[row].length) return 0;

        if(dp[row][col][cuts] != -1) {
            return dp[row][col][cuts];
        }

        int curr = 0, mod = 1_000_000_007;

        // horizontal cut
        for(int i=row; i<dp.length; i++) {
            for(int j=col; j<dp[i].length; j++) {
                if(pizza[i].charAt(j) == 'A') {
                    curr = (curr + dp(pizza, dp, i + 1, col, cuts - 1)) % mod;
                    break;
                }
            }
        }


        // vertical cut
        for(int i=col; i<dp[0].length; i++) {
            for(int j=row; j<dp.length; j++) {
                if(pizza[j].charAt(i) == 'A') {
                    curr = (curr + dp(pizza, dp, row, i + 1, cuts - 1)) % mod;
                    break;
                }
            }
        }

        dp[row][col][cuts] = curr;

        return dp[row][col][cuts];
    }

    public static int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][][] dp = new int[m][n][k + 1];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dp(pizza, dp, 0, 0, k);
    }

    public static void main(String[] args) {
        String[] pizza = {"A..","AAA","..."};
        System.out.println(ways(pizza, 3));
    }
}
