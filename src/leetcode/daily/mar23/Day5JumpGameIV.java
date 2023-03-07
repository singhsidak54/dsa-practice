package daily.mar23;

import java.util.*;

public class Day5JumpGameIV {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> neighbours = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(!neighbours.containsKey(arr[i])) {
                neighbours.put(arr[i], new ArrayList<>());
            }

            neighbours.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int dist = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                if(curr == arr.length - 1) {
                    return dist;
                }

                int fwd = curr + 1, bck = curr - 1;
                if(!visited.contains(fwd)) {
                    visited.add(fwd);
                    queue.add(fwd);
                }

                if(bck >= 0 && !visited.contains(bck)) {
                    visited.add(bck);
                    queue.add(bck);
                }

                for(int next : neighbours.getOrDefault(arr[curr], new ArrayList<>())) {
                    if(!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }

                neighbours.remove(arr[curr]);
            }

            dist++;
        }

        return dist;
    }
}
