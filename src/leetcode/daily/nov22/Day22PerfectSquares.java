package daily.nov22;

import java.util.*;

public class Day22PerfectSquares {
    public static int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> perfectSquares = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            perfectSquares.add(i*i);
        }

        if(perfectSquares.get(perfectSquares.size() - 1) == n) {
            return 1;
        }

        int distance = 1;
        for(int num : perfectSquares) {
            queue.add(num);
            visited.add(num);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                for(int num : perfectSquares) {
                    int next = curr + num;
                    if(next > n) {
                        break;
                    }

                    if(next == n) {
                        return distance + 1;
                    }

                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            distance++;
        }

        return n;
    }

    public static int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
