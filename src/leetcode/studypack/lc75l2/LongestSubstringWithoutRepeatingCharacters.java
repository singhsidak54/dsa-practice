package lc75l2;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int start = 0, maxLen = 1, end = 1;
        HashMap<Character, Integer> charMap = new HashMap<>();
        charMap.put(s.charAt(0), 0);
        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(i);
            if(charMap.containsKey(c)) {
                start = Math.max(start, charMap.get(c) + 1);
            }
            charMap.put(c, i);
            end++;
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
