package Scaler.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KPlacesApart {
    public int[] solve(int[] A, int B) {
        int[] sorted = new int[A.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<=B; i++) {
            pq.add(A[i]);
        }

        for(int i=B+1; i<A.length; i++) {
            sorted[i - B - 1] = pq.poll();
            pq.add(A[i]);
        }

        for(int i=A.length-B-1; i<A.length; i++) {
            sorted[i] = pq.poll();
        }

        return sorted;
    }

    public static void main(String[] args) {
        KPlacesApart obj = new KPlacesApart();
        int[] priorities = {4,7,9};
        System.out.println(Arrays.toString(obj.solve(priorities, 0)));
    }
}
