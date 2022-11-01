package contests.w316;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCostToMakeArrayEqual {
    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            long currCost = 0;
            for(int j=0; j<nums.length; j++) {
                long diff = Math.abs(nums[i] - nums[j]);
                currCost += diff * cost[j];
            }

            ans = Math.min(ans, currCost);
        }

        return ans;
    }

    public long minCostDP(int[] nums, int[] cost) {
        int[][] data = new int[nums.length][2];
        for(int i=0; i<nums.length; i++) {
            data[i] = new int[] { nums[i], cost[i] };
        }

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        long ans = Long.MAX_VALUE;
        long[] cost_l = new long[nums.length];
        long[] cost_r = new long[nums.length];
        long costSum = data[0][1];
        for(int i=1; i<nums.length; i++) {
            cost_l[i] = cost_l[i - 1] + (data[i][0] - data[i-1][0]) * costSum;
            costSum += data[i][1];
        }

        costSum = data[nums.length - 1][1];
        for(int i=nums.length-2; i>=0; i--) {
            cost_r[i] = cost_r[i + 1] + (data[i + 1][0] - data[i][0]) * costSum;
            costSum += data[i][1];
        }

        for(int i=0; i<nums.length; i++) {
            ans = Math.min(ans, cost_l[i] + cost_r[i]);
        }

        return ans;
    }

    public long findCost(int[] nums, int[] cost, int target) {
        long ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans += (long) Math.abs(target - nums[i]) * cost[i];
        }
        return ans;
    }

    public long minCostBinarySearch(int[] nums, int[] cost) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int left = min, right = max, mid;
        long ans = 0;
        while (left < right) {
            mid = (left + right)/2;
            long costLeft = findCost(nums, cost, mid);
            long costRight = findCost(nums, cost, mid + 1);
            ans = Math.min(costLeft, costRight);

            if(costLeft < costRight) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
