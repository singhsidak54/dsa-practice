package Scaler.BinarySearch;

public class PainterPartitionProblem {
    public boolean isPossible(int[] C, int B, int painters, long time) {
        int required = 1;
        long timeLeft = time;
        for(int i=0; i<C.length; i++) {
            long timeRequired = (long) C[i] * B;
            if(timeRequired > timeLeft) {
                required++;
                timeLeft = time;
            }
            timeLeft -= timeRequired;
        }

        return required <= painters;
    }

    public int paint(int A, int B, int[] C) {
        int max = 0;
        int sum = 0;
        for(int len : C) {
            max = Math.max(max, len);
            sum += len;
        }

        long l = (long) max * B, r = (long) sum * B + 1l;

        while(l < r) {
            long mid = l + (r - l)/2;
            if(isPossible(C, B, A, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return (int) (l % 10000003);
    }

    public static void main(String[] args) {
        PainterPartitionProblem obj = new PainterPartitionProblem();
        int[] C = {1000000, 1000000};
        System.out.println(obj.paint(1, 1000000, C));
    }
}
