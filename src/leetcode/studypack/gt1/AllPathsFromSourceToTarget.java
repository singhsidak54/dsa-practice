package gt1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourceToTarget {
    class Node {
        int index;
        List<Integer> path;

        public Node(int index, List<Integer> path) {
            this.index = index;
            this.path = new ArrayList<>(path);
            this.path.add(index);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        int m = graph.length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for(int idx : graph[current.index]) {
                if(idx == m - 1) {
                    List<Integer> currentPath = new ArrayList<>(current.path);
                    currentPath.add(idx);
                    res.add(currentPath);
                    continue;
                }
                queue.add(new  Node(idx, current.path));
            }
        }

        return res;
    }
}
