package daily.dec22;

import java.util.ArrayList;
import java.util.List;

public class Day22SumOfDistancesInTree {
    int[] ans;
    int[] count;
    int N;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.ans = new int[n];
        this.count = new int[n];
        this.N = n;

        this.graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
            count[i] = 1;
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }

    public void dfs(int node, int parent) {
        for(int child : graph.get(node)) {
            if(child != parent) {
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    public void dfs2(int node, int parent) {
        for(int child : graph.get(node)) {
            if(child != parent) {
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
}
