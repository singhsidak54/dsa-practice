package companies.Google;

import java.util.*;

public class RaceCar {
    static class Node {
        int position;
        int speed;
        public Node(int speed, int position) {
            this.speed = speed;
            this.position = position;
        }
    }

    public static int racecarBFS(int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("1 0");
        queue.add(new Node(1, 0));

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                Node curr = queue.poll();
                if(curr.position == target) {
                    return dist;
                }

                int newPosition, newSpeed;

                // add accelerate option
                newPosition = curr.position + curr.speed;
                newSpeed = curr.speed * 2;
                String newKey = newSpeed + " " + newPosition;
                if(!visited.contains(newKey) && newPosition > 0 && newPosition < target * 2) {
                    visited.add(newKey);
                    queue.add(new Node(newSpeed, newPosition));
                }

                // add reverse option
                newSpeed = curr.speed > 0 ? -1 : 1;
                newKey = newSpeed + " " + curr.position;
                if(!visited.contains(newKey) && curr.position > 0 && curr.position < target * 2) {
                    visited.add(newKey);
                    queue.add(new Node(newSpeed, curr.position));
                }
            }
            dist++;
        }
        return -1;
    }

    public static int racecarDPHelper(int target, int[] dp) {
        if(dp[target] != 0) {
            return dp[target];
        }

        int n = (int) (Math.log(target)/Math.log(2)) + 1;
        int positionAfterNA = (int)Math.pow(2, n) - 1;

        if(positionAfterNA == target) {
            dp[target] = n;
        } else {
            dp[target] = n + 1 + racecarDPHelper(positionAfterNA - target, dp);
            int positionJustBeforePassingT = (int) Math.pow(2, n - 1) - 1;
            for(int i=0; i<n-1; i++) {
                int positionMovedInOpposite = (int) Math.pow(2, i) - 1;
                dp[target] = Math.min(dp[target], n + i + 1 + racecarDPHelper(target - positionJustBeforePassingT + positionMovedInOpposite, dp));
            }
        }

        return dp[target];
    }


    public static int racecarDP(int target) {
        int[] dp = new int[target + 1];
        return racecarDPHelper(target, dp);
    }

    public static void main(String[] args) {
        System.out.println(racecarDP(5));
    }
}
