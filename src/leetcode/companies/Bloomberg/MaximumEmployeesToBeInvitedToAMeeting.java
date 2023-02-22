package companies.Bloomberg;

import java.util.*;

public class MaximumEmployeesToBeInvitedToAMeeting {
    public int maximumInvitations(int[] favorite) {
        int answer = 0, n = favorite.length;
        boolean[] visited = new boolean[n];

        // if cycle exists then length of cycle could be a potential answer
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                int curr = i;
                Set<Integer> seen = new HashSet<>();
                while (!visited[curr]) {
                    seen.add(curr);
                    visited[curr] = true;
                    curr = favorite[curr];
                }

                if(seen.contains(curr)) {
                    int start = i;
                    int cycleLength = seen.size();
                    while (start != curr) {
                        cycleLength--;
                        start = favorite[start];
                    }

                    answer = Math.max(answer, cycleLength);
                }
            }
        }

        // find all pairs where a is favorite of b and b is favorite of a
        List<int[]> pairs = new ArrayList<>();
        boolean[] visited2 = new boolean[n];
        for(int i=0; i<n; i++) {
            if(favorite[favorite[i]] == i && !visited2[i]) {
                pairs.add(new int[] {i, favorite[i]});
                visited2[i] = true;
                visited2[favorite[i]] = true;
            }
        }

        HashMap<Integer, List<Integer>> neighbours = new HashMap<>();
        for(int i=0; i<n; i++) {
            neighbours.put(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            neighbours.get(favorite[i]).add(i);
        }


        int res = 0;
        for(int[] pair : pairs) {
            Queue<int[]> queue = new LinkedList<>();

            // find maxA
            int maxA = 0;

            for(int neighbour : neighbours.get(pair[0])) {
                if(neighbour == pair[1]) continue;
                queue.add(new int[] { neighbour, 1 });
            }

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                maxA = Math.max(maxA, curr[1]);
                for(int neighbour : neighbours.get(curr[0])) {
                    queue.add(new int[] { neighbour, curr[1] + 1 });
                }
            }

            // find maxB
            int maxB = 0;

            for(int neighbour : neighbours.get(pair[1])) {
                if(neighbour == pair[0]) continue;
                queue.add(new int[] { neighbour, 1 });
            }

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                maxB = Math.max(maxB, curr[1]);
                for(int neighbour : neighbours.get(curr[0])) {
                    queue.add(new int[] { neighbour, curr[1] + 1 });
                }
            }

            res += maxA + maxB + 2;
        }

        return Math.max(answer, res);
    }

    public static void main(String[] args) {
        MaximumEmployeesToBeInvitedToAMeeting obj = new MaximumEmployeesToBeInvitedToAMeeting();
        int[] favs = {1,0,3,2,5,6,7,4,9,8,11,10,11,12,10};
        System.out.println(obj.maximumInvitations(favs));
    }
}
