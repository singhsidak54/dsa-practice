package Scaler.BitManipulation;


public class MaximumANDPair {
    public int solve(int[] A) {
        int ans = 0;
        for(int i=31; i>=0; i--) {
            int count = 0;
            for(int num : A) {
                if(((num>>i) & 1) == 1) {
                    count++;
                }
            }

            if(count > 1) {
                ans = ans | (1 << i);

                for(int j=0; j<A.length; j++) {
                    if(((A[j] >> i) & 1) == 0) {
                        A[j] = 0;
                    }
                }
            }
        }

        return ans;
    }
}
