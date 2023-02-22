package daily.feb23.weekly;

import java.util.ArrayList;
import java.util.List;

public class Week3NumberOfIslandsII {

    class UnionFind {
        private int count;
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            this.count = 0;
            this.parent = new int[size];
            this.rank = new int[size];

            for(int i=0; i<size; i++) {
                this.parent[i] = -1;
            }
        }

        public void addLand(int x) {
            if(this.parent[x] >= 0) {
                return;
            }

            this.parent[x] = x;
            count++;
        }

        public boolean isLand(int x) {
            return this.parent[x] >= 0;
        }
        public int numIslands() {
            return this.count;
        }

        public int find(int u) {
            if(this.parent[u] != u) {
                this.parent[u] = find(this.parent[u]);
            }

            return this.parent[u];
        }

        public void union(int u, int v) {
            int uParent = find(u);
            int vParent = find(v);

            if(uParent == vParent) {
                return;
            } else if (this.rank[uParent] > this.rank[vParent]) {
                this.parent[vParent] = uParent;
            } else if (this.rank[vParent] > this.rank[uParent]) {
                this.parent[uParent] = vParent;
            } else {
                this.parent[vParent] = uParent;
                this.rank[uParent]++;
            }
            count++;
        }
    }

    public boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int[] position : positions) {
            uf.addLand(position[0] * n + position[1]);

            for(int[] dir : dirs) {
                int r = position[0] + dir[0];
                int c = position[1] + dir[1];

                int pos = r * n + c;
                if(isValid(m, n, r, c) && uf.isLand(pos)) {
                    uf.union(position[0] * n + position[1], pos);
                }
            }

            result.add(uf.numIslands());
        }

        return result;
    }
}
