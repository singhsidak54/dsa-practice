package daily.jan23;

import java.util.*;

public class Day15NumberOfGoodPaths {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            if(parent[u] != u) {
                parent[u] = find(parent[u]);
            }

            return parent[u];
        }

        public void union(int u, int v) {
            int uParent = find(u), vParent = find(v);

            if(uParent == vParent) return;

            if(rank[uParent] > rank[vParent]) {
                parent[vParent] = uParent;
            } else if (rank[vParent] > rank[uParent]) {
                parent[uParent] = vParent;
            } else {
                parent[vParent] = uParent;
                rank[uParent]++;
            }
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i=0; i<n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        TreeMap<Integer, List<Integer>> valueNodeMap = new TreeMap<>();
        for(int i=0; i<n; i++) {
            if(!valueNodeMap.containsKey(vals[i])) {
                valueNodeMap.put(vals[i], new ArrayList<>());
            }

            valueNodeMap.get(vals[i]).add(i);
        }

        UnionFind uf = new UnionFind(n);
        int goodPaths = 0;

        for(int value : valueNodeMap.keySet()) {

            for(int node : valueNodeMap.get(value)) {
                for(int neighbour : adjacencyList.get(node)) {
                    if(vals[node] >= vals[neighbour]) {
                        uf.union(node, neighbour);
                    }
                }
            }

            Map<Integer, Integer> groupsMap = new HashMap<>();
            for(int node : valueNodeMap.get(value)) {
                groupsMap.put(uf.find(node), groupsMap.getOrDefault(uf.find(node), 0) + 1);
            }

            for(int groupSize : groupsMap.values()) {
                goodPaths += groupSize * (groupSize + 1)/2;
            }
        }

        return goodPaths;
    }
}
