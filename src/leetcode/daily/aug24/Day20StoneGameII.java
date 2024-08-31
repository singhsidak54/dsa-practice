package daily.aug24;

public class Day20StoneGameII {

    public int helper(int[] suffixSum, int idx, int maxTakenTillNow, int[][] dp, int[] piles) {
        // if current idx + max Possible moves >= piles.length then directly return sum of stones from idx
        if (idx + 2 * maxTakenTillNow >= piles.length) {
            return suffixSum[idx];
        }

        if(dp[idx][maxTakenTillNow] != 0) {
            return dp[idx][maxTakenTillNow];
        }

        int res = Integer.MAX_VALUE;

        // find min value of next move
        for(int i=1; i<=2*maxTakenTillNow; i++) {
            res = Math.min(res, helper(suffixSum, idx + i, Math.max(maxTakenTillNow, i), dp, piles));
        }

        return dp[idx][maxTakenTillNow] = suffixSum[idx] - res;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // build suffix sum array
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for(int i=n-2; i>=0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        return helper(suffixSum, 0, 1, new int[n][n], piles);
    }

    public static void main(String[] args) {
        int[] arr = {2,7,9,4,4};
        Day20StoneGameII obj = new Day20StoneGameII();
        System.out.println(obj.stoneGameII(arr));
    }
}
