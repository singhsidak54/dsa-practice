package dp2;

import java.util.HashMap;

public class PaintHouseII {
    HashMap<String, Integer> memo;

    public int helper(int[][] costs, int index, int prev) {
        if(index == costs.length) {
            return 0;
        }

        String key = index + "-" + prev;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int cost = Integer.MAX_VALUE;
        for(int i=0; i<costs[index].length; i++) {
            if(i == prev) continue;
            cost = Math.min(cost, helper(costs, index + 1, i) + costs[index][i]);
        }

        memo.put(key, cost);
        return memo.get(key);
    }

    public int minCostII(int[][] costs) {
        memo = new HashMap<>();
        return helper(costs, 0, -1);
    }

    public int minCostDP(int[][] costs) {
        int m = costs.length, n = costs[0].length;
        int minIndex = -1, secondMinIndex = -1;

        for(int i=0; i<n; i++) {
            if(minIndex == -1 || costs[0][i] < costs[0][minIndex]) {
                secondMinIndex = minIndex;
                minIndex = i;
            } else if (secondMinIndex == -1 || costs[0][i] < costs[0][secondMinIndex]) {
                secondMinIndex = i;
            }
        }

        for(int i=1; i<m; i++) {
            int currMinIndex = -1, currSecondMinIndex= -1;
            for(int j=0; j<n; j++) {
                if(j == minIndex) {
                    costs[i][j] += costs[i-1][secondMinIndex];
                } else {
                    costs[i][j] += costs[i-1][minIndex];
                }

                if(currMinIndex == -1 || costs[i][j] < costs[i][currMinIndex]) {
                    currSecondMinIndex = currMinIndex;
                    currMinIndex = j;
                } else if (currSecondMinIndex == -1 || costs[i][j] < costs[i][currSecondMinIndex]) {
                    currSecondMinIndex = j;
                }
            }

            minIndex = currMinIndex;
            secondMinIndex = currSecondMinIndex;
        }

        return costs[m-1][minIndex];
    }
}
