package daily.feb23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Day23IPO {

    class Node {
        int profit;
        int capital;

        public Node(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Node[] nodes = new Node[n];
        for(int i=0; i<n; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.capital, o2.capital);
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int nodePtr = 0;
        while (nodePtr < n && nodes[nodePtr].capital <= w) {
            pq.add(nodes[nodePtr].profit);
            nodePtr++;
        }

        int profit = w;
        while (k-- > 0 && !pq.isEmpty()) {
            profit += pq.poll();
            while (nodePtr < n && nodes[nodePtr].capital <= profit) {
                pq.add(nodes[nodePtr].profit);
                nodePtr++;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Day23IPO obj = new Day23IPO();
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(obj.findMaximizedCapital(2, 0, profits, capital));
    }
}
