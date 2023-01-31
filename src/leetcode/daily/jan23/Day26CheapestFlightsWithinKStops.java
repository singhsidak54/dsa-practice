package daily.jan23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day26CheapestFlightsWithinKStops {
    class Node {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int dfs(int current, int end, int k, HashMap<Integer, List<Node>> graph, Integer[][] dp) {
        if(k < 0) {
            return Integer.MAX_VALUE;
        }

        if(dp[current][k] != null) {
            return dp[current][k];
        }

        dp[current][k] = Integer.MAX_VALUE;
        for(Node neighbour : graph.getOrDefault(current, new ArrayList<>())) {
            int currentCost = neighbour.cost;
            if(neighbour.dest == end) {
                dp[current][k] = Math.min(dp[current][k], currentCost);
            } else {
                int neighbourCost = dfs(neighbour.dest, end, k - 1, graph, dp);
                if(neighbourCost != Integer.MAX_VALUE) {
                    dp[current][k] = Math.min(dp[current][k], currentCost + neighbourCost);
                }
            }
        }

        return dp[current][k];
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        Integer[][] dp = new Integer[n][k + 1];

        for(int[] flight : flights) {
            int from = flight[0];
            Node neighbour = new Node(flight[1], flight[2]);
            List<Node> neighbours = graph.getOrDefault(from, new ArrayList<>());
            neighbours.add(neighbour);
            graph.put(from, neighbours);
        }

        int ans = dfs(src, dst, k, graph, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Day26CheapestFlightsWithinKStops obj = new Day26CheapestFlightsWithinKStops();
        int[][] flight = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(obj.findCheapestPrice(4, flight, 0, 3, 1));
    }
}
