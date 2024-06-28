package Scaler.Graphs;

import java.util.Arrays;
import java.util.Comparator;

public class CommutableIslands {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];

            for(int i=1; i<=n; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int u) {
            if(parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        public boolean union(int u, int v) {
            int U = find(u), V = find(v);
            if(U == V) {
                return false;
            }

            if(rank[U] < rank[V]) {
                rank[V]++;
                parent[U] = V;
            } else {
                rank[U]++;
                parent[V] = U;
            }

            return true;
        }
    }

    public int solve(int A, int[][] B) {
        Arrays.sort(B, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int cost = 0;
        DSU obj = new DSU(A);

        for(int i=0; i<B.length; i++) {
            if(obj.union(B[i][0], B[i][1])) {
                cost += B[i][2];
            }
        }

        return cost;
    }
}
