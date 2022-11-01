package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int res = 1, start = 0, i = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while (i != n) {
            char current = s.charAt(i);
            if(set.contains(current)) {
                while (start != i) {
                    char startChar = s.charAt(start);
                    start++;
                    if(startChar == current) {
                        break;
                    }
                    set.remove(startChar);
                }
            } else {
                set.add(current);
                res = Math.max(res, i - start + 1);
            }
            i++;
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            if(map.containsKey(current)) {
                start = Math.max(start, map.get(current) + 1);
            }
            map.put(current, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abc abcbb"));
    }
}
