package gt1;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public static boolean isSafe(int[][] graph, Boolean[] isSafeCache, boolean[] visited, int index) {
        if(graph[index].length == 0) return true;
        if(visited[index]) return false;
        if(isSafeCache[index] != null) return isSafeCache[index];

        visited[index] = true;
        for(int neighbour : graph[index]) {
            if((isSafeCache[neighbour] != null && isSafeCache[neighbour])) continue;
            if(!isSafe(graph, isSafeCache, visited, neighbour)) {
                isSafeCache[index] = false;
                return isSafeCache[index];
            }
        }

        isSafeCache[index] = true;
        return isSafeCache[index];
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int n = graph.length;
        Boolean[] isSafeCache = new Boolean[n];
        for(int i=0; i<n; i++) {
            if((isSafeCache[i] != null && isSafeCache[i]) || isSafe(graph, isSafeCache, new boolean[n], i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] input = {{}, {0,2,3,4}, {3}, {4}, {}};
        System.out.println(eventualSafeNodes(input));
    }
}
