package Scaler.Hashing;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(final int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        for(int num : A) {
            if(map.containsKey(num)) continue;
            int leftCount = map.getOrDefault(num - 1, 0);
            int rightCount = map.getOrDefault(num + 1, 0);

            int currentLen = leftCount + rightCount + 1;
            ans = Math.max(ans, currentLen);

            int leftKey = num - leftCount;
            int rightKey = num + rightCount;

            map.put(leftKey, currentLen);
            map.put(rightKey, currentLen);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}));
    }
}
