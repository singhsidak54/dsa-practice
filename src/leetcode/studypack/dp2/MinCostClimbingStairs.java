package dp2;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int doublePrev = cost[0], prev = cost[1];

        for(int i=3; i<cost.length; i++) {
            int temp = Math.min(doublePrev, prev) + cost[i];
            doublePrev = prev;
            prev = temp;
        }

        return Math.min(doublePrev, prev);
    }
}
