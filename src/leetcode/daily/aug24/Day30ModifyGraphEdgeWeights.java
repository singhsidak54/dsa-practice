package daily.aug24;

import java.util.*;

public class Day30ModifyGraphEdgeWeights {
    private static final int INF = (int) 2e9;

    class Pair {
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for(int i=0; i<n; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            if(edge[2] == -1) continue;
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        int minDist = minDist(n, source, destination, graph);
        if(minDist < target) return new int[0][0];

        boolean matchesTarget = minDist == target;

        for(int[] edge : edges) {
            if(edge[2] != -1) continue;

            edge[2] = matchesTarget ? INF : 1;
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));

            if(!matchesTarget) {
                int distToTarget = minDist(n, source, destination, graph);

                if(distToTarget <= target) {
                    matchesTarget = true;
                    edge[2] += target - distToTarget;
                }
            }
        }

        return matchesTarget ? edges : new int[0][0];
    }

    public int minDist(int n, int source, int destination, Map<Integer, List<Pair>> graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int[] minDist = new int[n];
        Arrays.fill(minDist, INF);
        minDist[source] = 0;
        pq.add(new int[] {source, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if(minDist[curr[0]] < curr[1]) continue;
            for(Pair next : graph.get(curr[0])) {
                int nextDist = curr[1] + next.weight;
                if(minDist[next.node] > nextDist) {
                    minDist[next.node] = nextDist;
                    pq.add(new int[] {next.node, nextDist});
                }
            }
        }
        return minDist[destination];
    }

    public static void main(String[] args) {
        Day30ModifyGraphEdgeWeights obj = new Day30ModifyGraphEdgeWeights();
        int[][] edges = {{4,1,-1},{2,0,-1},{0,3,-1},{4,3,-1}};
        int[][] res = obj.modifiedGraphEdges(5, edges, 0, 1, 5);
        System.out.println(Arrays.deepToString(res));
    }
}
