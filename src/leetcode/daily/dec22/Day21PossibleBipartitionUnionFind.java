package daily.dec22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day21PossibleBipartitionUnionFind {
    int[] parents;
    int[] ranks;

    public int find(int u) {
        if(parents[u] != u) {
            parents[u] = find(parents[u]);
        }

        return parents[u];
    }

    public void union(int u, int v) {
        int parentX = find(u);
        int parentY = find(v);

        if(parentX == parentY) {
            return;
        } else if (ranks[u] > ranks[v]) {
            parents[parentY] = parentX;
        } else if (ranks[v] > ranks[u]) {
            parents[parentX] = parentY;
        } else {
            parents[parentY] = parentX;
            ranks[parentX]++;
        }
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> dislikeList = new HashMap<>();
        parents = new int[n + 1];
        ranks = new int[n + 1];

        for(int i=1; i<=n; i++) {
            parents[i] = i;
            dislikeList.put(i, new ArrayList<>());
        }

        for(int[] dislike : dislikes) {
            dislikeList.get(dislike[0]).add(dislike[1]);
            dislikeList.get(dislike[1]).add(dislike[0]);
        }

        for(int i=1; i<=n; i++) {
            for(int neighbour : dislikeList.get(i)) {
                if(find(i) == find(neighbour)) {
                    return false;
                }

                union(dislikeList.get(i).get(0), neighbour);
            }
        }

        return true;
    }
}
