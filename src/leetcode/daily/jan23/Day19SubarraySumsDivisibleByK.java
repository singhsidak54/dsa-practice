package daily.jan23;

import java.util.HashMap;
import java.util.Map;

public class Day19SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int num : nums) {
            HashMap<Integer, Integer> next = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int newSum = entry.getKey() + num;
                if(newSum % k == 0) {
                    count += entry.getValue();
                }
                next.put(newSum, next.getOrDefault(newSum, 0) + entry.getValue());
            }

            if(num % k == 0) {
                count++;
            }
            next.put(num, next.getOrDefault(num, 0) + 1);
            map = next;
        }

        return count;
    }

    public int subarraysDivByKOptimised(int[] nums, int k) {
        int[] remainderCounts = new int[k];
        remainderCounts[0] = 1;
        int ans = 0, prefixSumMod = 0;
        for(int num : nums) {
            prefixSumMod = (prefixSumMod + num % k + k) % k;
            ans += remainderCounts[prefixSumMod];

            remainderCounts[prefixSumMod]++;
        }

        return ans;
    }
}
