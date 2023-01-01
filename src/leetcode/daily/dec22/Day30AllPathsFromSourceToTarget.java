package daily.dec22;

import java.util.ArrayList;
import java.util.List;

public class Day30AllPathsFromSourceToTarget {
    public void dfs(int[][] graph, int vertex, List<Integer> current, List<List<Integer>> result) {
        if(vertex == graph.length - 1) {
            List<Integer> temp = new ArrayList<>(current);
            temp.add(vertex);
            result.add(temp);
        }

        current.add(vertex);
        for(int neighbour : graph[vertex]) {
            dfs(graph, neighbour, current, result);
        }

        current.remove(current.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(graph, 0, current, result);
        return result;
    }
}
