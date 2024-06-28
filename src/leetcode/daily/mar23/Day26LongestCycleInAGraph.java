package daily.mar23;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Day26LongestCycleInAGraph {
    int max;
    boolean[] visited;

    public void visit(int node, int[] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int t = 0;
        map.put(node, t++);
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int next = edges[curr];
            if (map.containsKey(next)) {
                max = Math.max(max, t - map.get(next));
                return;
            } else if(next == -1 || visited[next]) {
                return;
            } else {
                map.put(next, t++);
                queue.add(next);
                visited[next] = true;
            }
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        max = -1;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visit(i, edges);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        Day26LongestCycleInAGraph obj = new Day26LongestCycleInAGraph();
        System.out.println(obj.longestCycle(edges));
    }
}
