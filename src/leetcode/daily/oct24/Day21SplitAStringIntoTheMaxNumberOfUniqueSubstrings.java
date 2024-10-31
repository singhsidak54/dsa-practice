package daily.oct24;

import java.util.HashSet;
import java.util.Set;

public class Day21SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    int max;

    public void helper(String s, int index, Set<String> dictionary) {
        if(index == s.length()) {
            max = Math.max(max, dictionary.size());
        }

        int curr = index + 1;
        while (curr < s.length() + 1) {
            String cString = s.substring(index, curr);
            if (!dictionary.contains(cString)) {
                dictionary.add(cString);
                helper(s, curr, dictionary);
                dictionary.remove(cString);
            }
            curr++;
        }
    }

    public int maxUniqueSplit(String s) {
        max = 0;
        helper(s, 0, new HashSet<>());
        return max;
    }

    public static void main(String[] args) {
        Day21SplitAStringIntoTheMaxNumberOfUniqueSubstrings obj = new Day21SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
        System.out.println(obj.maxUniqueSplit("ababccc"));
    }
}
