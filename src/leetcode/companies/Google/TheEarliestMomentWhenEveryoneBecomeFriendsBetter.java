package companies.Google;


import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriendsBetter {
    static class UnionFind {
        int[] parents;
        int[] rank;
        public UnionFind(int size) {
            this.parents = new int[size];
            this.rank = new int[size];
            for(int i=0; i<size; i++) {
                this.parents[i] = i;
            }
        }

        public int find(int u) {
            if (this.parents[u] != u) {
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

    public static int earliestAcq(int[][] logs, int n) {
        int groups = n;
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<logs.length; i++) {
            if(uf.union(logs[i][1], logs[i][2])) {
                groups--;
            }

            if(groups == 1) {
                return logs[i][0];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1}, {20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3}, {20190312,1,2}, {20190322,4,5}};
        System.out.println(earliestAcq(logs, 6));
    }
}
