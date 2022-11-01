package patterns.amazon;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longestSeq = 0, currSeq = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : set.stream().toList()) {
            if(!set.contains(num - 1)) {
                currSeq = 0;
                while (set.contains(num)) {
                    currSeq++;
                    num++;
                }
                longestSeq = Math.max(longestSeq, currSeq);
            }
        }

        return longestSeq;
    }
}
