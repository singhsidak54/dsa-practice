package daily.nov22;

import java.util.HashMap;

public class Day27ArithmeticSlicesII {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, ans = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for(int i=0; i<n; i++) {
            map[i] = new HashMap<>();
            for(int j=0; j<i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if(delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }

                int diff = (int)delta;
                int currentWeakSequences = map[j].getOrDefault(diff, 0);
                int currentSequences = map[i].getOrDefault(diff, 0);
                ans += currentWeakSequences;
                map[i].put(diff, currentWeakSequences + currentSequences + 1);
            }
        }

        return ans;
    }
}
