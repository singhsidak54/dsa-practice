package companies.Google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    class Node {
        int originalIdx;
        int processingTime;
        int enqueueTime;
        public Node(int originalIdx, int processingTime, int enqueueTime) {
            this.originalIdx = originalIdx;
            this.processingTime = processingTime;
            this.enqueueTime = enqueueTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        Node[] nodes = new Node[tasks.length];
        for(int i=0; i<tasks.length; i++) {
            nodes[i] = new Node(i, tasks[i][1], tasks[i][0]);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.processingTime == o2.processingTime) {
                    return Integer.compare(o1.originalIdx, o2.originalIdx);
                }

                return Integer.compare(o1.processingTime, o2.processingTime);
            }
        });

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.enqueueTime, o2.enqueueTime);
            }
        });


        int k = 0, j = 0, t = 0;
        while (!pq.isEmpty() || j < nodes.length) {
            if(j < nodes.length && t < nodes[j].enqueueTime) {
                t = nodes[j].enqueueTime;
            }

            while (j < tasks.length && t >= nodes[j].enqueueTime) {
                pq.add(nodes[j]);
                j++;
            }

            if (!pq.isEmpty()) {
                Node curr = pq.poll();
                t = t + curr.processingTime;
                ans[k] = curr.originalIdx;
                k++;
            }
        }

        return ans;
    }
}
