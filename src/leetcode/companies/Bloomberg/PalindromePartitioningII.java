package companies.Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromePartitioningII {
    public static int minCut(String s) {
        int n = s.length();
        if(n == 1) return 0;
        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
            }
        }

        for(int len=2; len<n; len++) {
            for(int i=0; i+len<n; i++) {
                if(s.charAt(i) == s.charAt(i+len) && dp[i+1][i+len-1]) {
                    dp[i][i+len] = true;
                }
            }
        }

        int dist = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                if(curr == n) {
                    return dist - 1;
                }

                if(dp[curr][n-1]) {
                    return dist;
                }

                for(int j=n-2; j>=curr; j--) {
                    if(dp[curr][j] && !visited[j+1]) {
                        visited[j+1] = true;
                        queue.add(j + 1);
                    }
                }
            }
            dist++;
        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(minCut("ab"));
    }
}
