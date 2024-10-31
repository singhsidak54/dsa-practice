package daily.oct24;

import java.util.*;

public class Day31MinimumTotalDistanceTraveled {
    long[][] dp;

    public long distance(int x, int y) {
        return Math.abs((long)y - (long)x);
    }

    public long helper(int robotIdx, int factoryIdx, List<Integer> robots, List<Integer> factories) {
        if(robotIdx == robots.size()) {
            return 0;
        }

        if(factoryIdx == factories.size()) {
            return Long.MAX_VALUE;
        }

        if(dp[robotIdx][factoryIdx] != -1) {
            return dp[robotIdx][factoryIdx];
        }

        long ans = helper(robotIdx, factoryIdx + 1, robots, factories);
        long subAns = helper(robotIdx + 1, factoryIdx + 1, robots, factories);

        if(subAns != Long.MAX_VALUE) {
            ans = Math.min(ans, subAns + distance(robots.get(robotIdx), factories.get(factoryIdx)));
        }

        dp[robotIdx][factoryIdx] = ans;
        return ans;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<Integer> factories = new ArrayList<>();
        for(int[] fact : factory) {
            for(int i=0; i<fact[1]; i++) {
                factories.add(fact[0]);
            }
        }

        dp = new long[robot.size()][factories.size()];
        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, 0, robot, factories);
    }

    public static void main(String[] args) {
        List<Integer> robots = Arrays.asList(9486709,305615257,214323605,282129380,763907021,-662831631,628054452,-132239126,50488558,381544523,-656107497,810414334,421675516,-304916551,571202823,478460906,-972398628,325714139,-86452967,660743346);
        int[][] factory = {{-755430217,18},{3914340,2},{977509386,4},{94299927,9},{32194684,16},{-371001457,2},{-426296769,13},{-284404215,8},{-421288725,0},{-893030428,2},{291827872,17},{-766616824,8},{-730172656,17},{-722387876,1},{510570520,20},{756326049,7},{-242350340,14},{6585224,19},{-173457765,15}};
        Day31MinimumTotalDistanceTraveled obj = new Day31MinimumTotalDistanceTraveled();
        System.out.println(obj.minimumTotalDistance(robots, factory));
    }
}
