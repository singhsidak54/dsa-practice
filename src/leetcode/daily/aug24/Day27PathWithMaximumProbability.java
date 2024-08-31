package daily.aug24;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day27PathWithMaximumProbability {
    class Pair {
        int node;
        double weight;
        public Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] successProb, int startNode, int endNode) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(new Pair(edge[1], successProb[i]));
            graph.get(edge[1]).add(new Pair(edge[0], successProb[i]));
        }


        double[] maxProb = new double[n];
        maxProb[startNode] = 1.0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o2.weight, o1.weight);
            }
        });

        pq.add(new Pair(startNode, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if(curr.node == endNode) {
                return curr.weight;
            }

            for(Pair next : graph.get(curr.node)) {
                double nextProb = curr.weight * next.weight;
                if(nextProb > maxProb[next.node]) {
                    maxProb[next.node] = nextProb;
                    pq.add(new Pair(next.node, nextProb));
                }
            }
        }

        return 0.0;
    }
}
