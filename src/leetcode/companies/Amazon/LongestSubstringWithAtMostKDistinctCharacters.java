package companies.Amazon;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0, currDistinct = 0, start = 0;

        for(int i=0; i<s.length(); i++) {
            if(!charMap.containsKey(s.charAt(i))) {
                currDistinct++;
                charMap.put(s.charAt(i), 1);
                while (currDistinct > k) {
                    char startChar = s.charAt(start);
                    int startCharNewCount = charMap.get(startChar) - 1;
                    if(startCharNewCount == 0) {
                        charMap.remove(startChar);
                        currDistinct--;
                    } else {
                        charMap.put(startChar, startCharNewCount);
                    }
                    start++;
                }
            } else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
