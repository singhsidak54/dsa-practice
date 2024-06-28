package Scaler.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLargestElement {
    class Node {
        int nextValue;
        int index;
        public Node(int nextValue, int index) {
            this.nextValue = nextValue;
            this.index = index;
        }
    }

    public int solve(int[] A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.nextValue, o2.nextValue);
            }
        });

        int[] state = new int[A.length];

        for(int i=0; i<A.length; i++) {
            state[i] = A[i];
            pq.add(new Node(A[i] * 2, i));
        }

        while (B-- > 0) {
            Node next = pq.poll();
            state[next.index] = next.nextValue;

            next.nextValue += A[next.index];
            pq.add(next);
        }

        int max = Integer.MIN_VALUE;
        for(int num : state) {
            max = Math.max(max, num);
        }

        return max;
    }

    public static void main(String[] args) {
        MinimumLargestElement obj = new MinimumLargestElement();
        int[] a = {8,6,4,2};
        System.out.println(obj.solve(a,8));
    }
}
