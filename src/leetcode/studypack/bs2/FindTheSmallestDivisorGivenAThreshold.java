package bs2;

public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }

        int l = 1, r = max, m, currResult;

        while (l < r) {
            m = l + (r - l)/2;
            currResult = 0;

            for(int num : nums) {
                // (num + m - 1)/m can also be used. Will decrease time by A LOT.
                currResult += Math.ceil((double) num/m);
            }

            if(currResult > threshold) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}
