package bs2;

import java.util.Random;

public class RandomPickWithWeight {
    int[] wSum;
    Random random = new Random();

    public RandomPickWithWeight(int[] w) {
        for(int i=1; i<w.length; i++) {
            w[i] += w[i - 1];
        }
        this.wSum = w;
    }

    public int pickIndex() {
        int l = 0, r = this.wSum.length, m;
        int target = random.nextInt(this.wSum[r - 1]) + 1;
        while (l < r) {
            m = l + (r - l)/2;
            if(this.wSum[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
