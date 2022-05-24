package algo2;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        pathToEnd(0, graph, path, allPaths);
        return allPaths;
    }

    public static List<Integer> pathToEnd(int current, int[][] graph, List<Integer> path, List<List<Integer>> allPaths) {
        int lastNode = graph.length - 1;
        if(current == lastNode) {
            return path;
        }

        for(int i=0; i<graph[current].length; i++) {
            path.add(graph[current][i]);
            if(pathToEnd(graph[current][i], graph, path, allPaths) != null) {
                allPaths.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
