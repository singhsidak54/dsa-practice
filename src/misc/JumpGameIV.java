package misc;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        HashMap<Integer, Set<Integer>> valueIndexesMap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            Set<Integer> valueSet = valueIndexesMap.getOrDefault(arr[i], new HashSet<>());
            valueSet.add(i);
            valueIndexesMap.put(arr[i], valueSet);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int jumps = 0;
        int[] dirs = {1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int curr = queue.poll();
                if(curr == arr.length - 1) return jumps;
                for(int dir : dirs) {
                    int next = curr + dir;
                    if(next < 0 || next >= arr.length || visited.contains(next)) continue;

                    visited.add(next);
                    queue.add(next);
                }

                for(int neighbour : valueIndexesMap.getOrDefault(arr[curr], new HashSet<>())) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }

                valueIndexesMap.remove(arr[curr]);
            }

            jumps++;
        }

        return -1;
    }
}
