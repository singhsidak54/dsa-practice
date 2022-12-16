package daily.dec22.weekly;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Week2NumberOfConnectedComponentsInAnUndirectedGraph {
    class UnionFind {
        int[] parents;
        int[] rank;
        public UnionFind(int n) {
            this.parents = new int[n];
            this.rank = new int[n];
            for(int i=0; i<n; i++) {
                this.parents[i] = i;
            }
        }

        public int find(int u) {
            if(this.parents[u] != u) {
                this.parents[u] = find(this.parents[u]);
            }

            return this.parents[u];
        }

        public boolean union(int u, int v) {
            u = find(u);
            v = find(v);

            if(u == v) {
                return false;
            }

            if(this.rank[u] > this.rank[v]) {
                this.parents[v] = u;
            } else if (this.rank[v] > this.rank[u]) {
                this.parents[u] = v;
            } else {
                this.parents[v] = u;
                this.rank[u]++;
            }

            return true;
        }
    }


    public int countComponents(int n, int[][] edges) {
        int components = n;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) {
            if(uf.union(edge[0], edge[1])) {
                components--;
            }
        }

        return components;
    }

    public static void visit(List<List<Integer>> neighbours, int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for(int next : neighbours.get(curr)) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static int countComponentsBFS(int n, int[][] edges) {
        int components = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> neighbours = new ArrayList<>();
        for(int i=0; i<n; i++) {
            neighbours.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            neighbours.get(edge[0]).add(edge[1]);
            neighbours.get(edge[1]).add(edge[0]);
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                components++;
                visit(neighbours, i, visited);
            }
        }

        return components;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};

        System.out.println(countComponentsBFS(5, edges));
    }
}
