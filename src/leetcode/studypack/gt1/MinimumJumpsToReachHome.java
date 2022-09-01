package gt1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumJumpsToReachHome {

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> notReachable = new HashSet<>();
        int forBiddenMax = 0;
        for(int num : forbidden) {
            notReachable.add(num);
            forBiddenMax = Math.max(forBiddenMax, num);
        }

        //no idea how this formula works
        int upperBound = Math.max(x, forBiddenMax) + a + b;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        boolean[][] visited = new boolean[2][upperBound];
        visited[0][0] = true;
        visited[1][0] = true;

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int[] curr = queue.poll();
                if(curr[0] == x) return dist;

                //forward
                int forward = curr[0] + a;
                if(!notReachable.contains(forward) && forward <= upperBound && !visited[0][forward]) {
                    queue.add(new int[] {forward, 0});
                    visited[0][forward] = true;
                }

                //backward
                int backward = curr[0] - b;
                if(!notReachable.contains(backward) && backward >= 0 && !visited[1][backward] && curr[1] == 0) {
                    queue.add(new int[] {backward, 1});
                    visited[1][backward] = true;
                }
            }
            dist++;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumJumps(new int[] {1998}, 1, 14, 3));
    }
}
