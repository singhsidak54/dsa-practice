package daily.mar23;

import java.util.Arrays;

public class Day28MinimumCostForTickets {
    public int binarySearchJustGreater(int[] days, int day) {
        int l = 0, r = days.length, m;
        while (l < r) {
            m = l + (r - l)/2;
            if(days[m] < day) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int backtrack(int[] days, int[] costs, int index, int[] dp) {
        if(index == days.length) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int day = days[index];
        int[] steps = new int[] {1, 7, 30};
        int minCost = Integer.MAX_VALUE;
        for(int i=0; i<steps.length; i++) {
            int next = binarySearchJustGreater(days, day + steps[i]);
            minCost = Math.min(minCost, costs[i] + backtrack(days, costs, next, dp));
        }

        dp[index] = minCost;
        return dp[index];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return backtrack(days, costs, 0, dp);
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        Day28MinimumCostForTickets obj = new Day28MinimumCostForTickets();
        System.out.println(obj.mincostTickets(days, costs));
    }
}
