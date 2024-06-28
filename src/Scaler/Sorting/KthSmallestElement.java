package Scaler.Sorting;

public class KthSmallestElement {
    public int kthsmallest(final int[] A, int B) {
        int ptr = 0, minIndex;
        while(ptr < B) {
            minIndex = ptr;
            for(int i=ptr; i<A.length; i++) {
                if(A[i] < A[minIndex]) {
                    minIndex = i;
                }
            }

            // swap minIndex and ptr
            int temp = A[ptr];
            A[ptr] = A[minIndex];
            A[minIndex] = temp;

            ptr++;
        }

        return A[B - 1];
    }
}
