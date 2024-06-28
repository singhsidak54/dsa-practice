package Scaler.DP;

import java.util.Arrays;

public class UniqueBinarySearchTreesII {

    public int numTrees(int A, int[] dp) {
        if(dp[A] != -1) return dp[A];

        int count = 0;
        for(int i=1; i<=A; i++) {
            count += (numTrees(i-1, dp) * numTrees(A-i, dp));
        }

        dp[A] = count;
        return count;
    }
    public int numTrees(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        return numTrees(A, dp);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();
        System.out.println(obj.numTrees(2));
    }
}
