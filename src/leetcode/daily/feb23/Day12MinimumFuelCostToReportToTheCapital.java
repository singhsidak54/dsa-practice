package daily.feb23;

import java.util.*;

public class Day12MinimumFuelCostToReportToTheCapital {

    long ans;
    public int dfs(HashMap<Integer, List<Integer>> adjMap, int node, int parent, int seats) {
        int children = 1;
        if(adjMap.get(node).size() == 0) {
            return children;
        }

        for(int child : adjMap.get(node)) {
            if(child == parent) continue;
            children += dfs(adjMap, child, node, seats);
        }

        if(node != 0) {
            ans += Math.ceil((double) children/seats);
        }

        return children;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int i=0; i<=roads.length; i++) {
            adjMap.put(i, new ArrayList<>());
        }

        for (int[] road : roads) {
            adjMap.get(road[0]).add(road[1]);
            adjMap.get(road[1]).add(road[0]);
        }

        ans = 0;
        dfs(adjMap, 0, -1, seats);
        return ans;
    }

    public static void main(String[] args) {
        Day12MinimumFuelCostToReportToTheCapital obj = new Day12MinimumFuelCostToReportToTheCapital();
        int[][] roads = {{1,0},{1,2},{3,1},{4,2}};
        System.out.println(obj.minimumFuelCost(roads, 2));
    }
}
