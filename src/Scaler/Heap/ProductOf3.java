package Scaler.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ProductOf3 {
    public int[] solve(int[] A) {
        int[] res = new int[A.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int currProduct = 1;
        for(int i=0; i<3; i++) {
            pq.add(A[i]);
            res[i] = -1;
            currProduct = currProduct * A[i];
        }

        for(int i=3; i<A.length; i++) {
            res[i - 1] = currProduct;
            if(A[i] > pq.peek()) {
                int num = pq.poll();
                if(num != 0) {
                    currProduct = currProduct/num;
                } else {
                    currProduct = 1;
                }
                currProduct *= A[i];
                pq.add(A[i]);
            }
        }


        res[A.length - 1] = currProduct;
        return res;
    }

    public static void main(String[] args) {
        int[] A = {10,2,13,4};
        ProductOf3 obj = new ProductOf3();
        System.out.println(Arrays.toString(obj.solve(A)));
    }
}
