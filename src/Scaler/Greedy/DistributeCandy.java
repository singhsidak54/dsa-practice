package Scaler.Greedy;

public class DistributeCandy {
    public int candy(int[] A) {
        int n = A.length;
        if(n == 0) return 0;

        int[] cL = new int[n], cR = new int[n];

        cL[0] = 1;
        for(int i=1; i<A.length; i++) {
            if(A[i] > A[i - 1]) {
                cL[i] = cL[i - 1] + 1;
            } else {
                cL[i] = 1;
            }
        }

        cR[n - 1] = 1;
        for(int i=n-2; i>=0; i--) {
            if(A[i] > A[i + 1]) {
                cR[i] = cR[i + 1] + 1;
            } else {
                cR[i] = 1;
            }
        }

        int candies = 0;
        for(int i=0; i<A.length; i++) {
            candies += Math.max(cL[i], cR[i]);
        }
        return candies;
    }

    public static void main(String[] args) {
        DistributeCandy obj = new DistributeCandy();
        System.out.println(obj.candy(new int[] {1,2}));
    }
}
