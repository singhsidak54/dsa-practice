package Scaler.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AthLargestElement {
    public int[] solve(int A, int[] B) {
        int[] res = new int[B.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<A; i++) {
            pq.add(B[i]);
            res[i] = -1;
        }

        for(int i=A; i<B.length; i++) {
            res[i - 1] = pq.peek();
            pq.add(B[i]);
            pq.poll();
        }


        res[B.length - 1] = pq.peek();
        return res;
    }

    public static void main(String[] args) {
        AthLargestElement obj = new AthLargestElement();
        int[] B = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(obj.solve(4, B)));
    }
}
