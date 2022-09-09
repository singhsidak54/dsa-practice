package dp1;

import java.util.HashMap;
import java.util.List;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int[] values = new int[10001];
        values[0] = 0;
        for(int num : nums) {
            values[num] += num;
        }

        int prev = 0, doublePrev = 0, ans;
        for(int i=0; i<values.length; i++) {
            ans = doublePrev + values[i];
            doublePrev = prev;
            prev = Math.max(prev, ans);
        }

        return prev;
    }
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[] {2,2,3,3,3,4}));
    }
}
