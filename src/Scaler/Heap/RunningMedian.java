package Scaler.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    boolean isEven;
    public int getMedian(int num) {
        if(isEven) {
            larger.add(num);
            smaller.add(larger.poll());
        } else {
            smaller.add(num);
            larger.add(smaller.poll());
        }

        isEven = !isEven;

        return smaller.peek();
    }

    public int[] solve(int[] A) {
        int[] res = new int[A.length];
        smaller = new PriorityQueue<>(Collections.reverseOrder());
        larger = new PriorityQueue<>();
        isEven = true;

        for(int i=0; i<A.length; i++) {
            res[i] = getMedian(A[i]);
        }

        return res;
    }
}
