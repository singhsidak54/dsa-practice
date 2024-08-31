package daily.aug24;

import java.util.*;

public class Day29MostStonesRemovedWithSameRowOrColumn {
    public void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for(Integer neighbor : graph.get(node)) {
            if(!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int connectComponents = 0, n = stones.length;
        HashMap<Integer, List<Integer>> xAxis = new HashMap<>(), yAxis = new HashMap<>();
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            int[] stone = stones[i];
            List<Integer> neighbors = new ArrayList<>();
            List<Integer> xNeighbors = xAxis.getOrDefault(stone[0], new ArrayList<>());
            List<Integer> yNeighbors = yAxis.getOrDefault(stone[1], new ArrayList<>());

            for(Integer neighbor : xNeighbors) {
                neighbors.add(neighbor);
                graph.get(neighbor).add(i);
            }

            for(Integer neighbor : yNeighbors) {
                neighbors.add(neighbor);
                graph.get(neighbor).add(i);
            }

            xNeighbors.add(i);
            xAxis.put(stone[0], xNeighbors);
            yNeighbors.add(i);
            yAxis.put(stone[1], yNeighbors);
            graph.add(neighbors);
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                connectComponents++;
                dfs(graph, visited, i);
            }
        }

        return n - connectComponents;
    }

    class UnionFind {
        int[] parent;
        int components;

        public UnionFind(int n) {
            this.parent = new int[n];
            Arrays.fill(parent, -1);
            this.components = n;
        }

        public int find(int node) {
            if(parent[node] == -1) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if(parent1 != parent2) {
                parent[parent1] = parent2;
                components--;
            }
        }
    }

    public int removeStonesUF(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<stones.length; i++) {
            for(int j=0; j<stones.length; j++) {
                if(i==j) continue;
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.components;
    }

    class UnionFindOptimised {
        int[] parent;
        int components;
        Set<Integer> uniqueNodes;

        public UnionFindOptimised() {
            this.parent = new int[20002];
            Arrays.fill(parent, -1);
            this.components = 0;
            this.uniqueNodes = new HashSet<>();
        }

        public int find(int node) {
            if(!uniqueNodes.contains(node)) {
                uniqueNodes.add(node);
                components++;
            }

            if(parent[node] == -1) {
                return node;
            }

            return parent[node] = find(parent[node]);
        }

        public void union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if(parent1 != parent2) {
                parent[parent1] = parent2;
                components--;
            }
        }
    }

    public int removeStonesUFOptimised(int[][] stones) {
        int n = stones.length;
        UnionFindOptimised uf = new UnionFindOptimised();
        for(int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10001);
        }

        return n - uf.components;
    }

    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        Day29MostStonesRemovedWithSameRowOrColumn obj = new Day29MostStonesRemovedWithSameRowOrColumn();
        System.out.println(obj.removeStones(stones));
    }
}
