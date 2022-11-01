package patterns.intuit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        HashMap<Character, Integer> charMap = new HashMap<>();
        int start = 0, end = 1, ans = 1;
        charMap.put(s.charAt(0), 0);
        while (end < s.length()) {
            char c = s.charAt(end);
            if(charMap.containsKey(c)) {
                start = Math.max(start, charMap.get(c) + 1);
            }

            charMap.put(c, end);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length() <= 1) return s.length();
        Set<Character> set = new HashSet<>();
        int start = 0, end = 1, ans = 1;
        set.add(s.charAt(0));

        while (end < s.length()) {
            char c = s.charAt(end);
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }

            set.add(c);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
