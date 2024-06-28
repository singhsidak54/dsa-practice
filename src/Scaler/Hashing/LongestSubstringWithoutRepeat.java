package Scaler.Hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0, start = 0, end = 0;

        while (end < A.length()) {
            char c = A.charAt(end);
            start = Math.max(start, map.getOrDefault(c, -1) + 1);
            map.put(c, end);

            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }
}
