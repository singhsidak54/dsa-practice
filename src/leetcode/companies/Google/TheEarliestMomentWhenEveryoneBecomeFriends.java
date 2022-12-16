package companies.Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    static int[] parent;
    static int[] size;
    public static int find(int i) {
        if(parent[i] == -1) return -1;
        if(i == parent[i]) {
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    public static void union(int u, int v) {
        int x = find(u), y = find(v);
        u = x == -1 ? u : x;
        v = y == -1 ? v : y;
        if(u == v) {
            return;
        }

        if(size[u] > size[v]) {
            size[u] += size[v] == 0 ? 1 : size[v];
            parent[v] = u;
        } else {
            size[v] += size[u] == 0 ? 1 : size[u];
            parent[u] = v;
        }
    }

    public static int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(parent, -1);

        int maxTime = 0;
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i=0; i<logs.length; i++) {
            int a = logs[i][1], b = logs[i][2];
            if(parent[a] == -1 && parent[b] == -1) {
                maxTime = logs[i][0];
                parent[a] = a;
                parent[b] = a;
                size[a] += 2;
            } else if (find(a) != find(b)) {
                //union
                union(a, b);
                maxTime = logs[i][0];
            }
        }

        for(int i=0; i<size.length; i++) {
            if(size[i] == n) {
                return maxTime;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1}, {20190104,3,4},{20190107,2,3},{20190211,1,5},{20190224,2,4},{20190301,0,3}, {20190312,1,2}, {20190322,4,5}};
        System.out.println(earliestAcq(logs, 6));
    }
}
