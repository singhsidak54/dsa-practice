package leetcode.studypack.algo1;

import java.util.HashMap;

// Problem Link - https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        char[] temp = s.toCharArray();
        for(int i=0; i<temp.length; i++) {
            if(map.containsKey(temp[i])) {
                start = Math.max(start, map.get(temp[i]) + 1);
            }
            map.put(temp[i],i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbca"));
    }
}
