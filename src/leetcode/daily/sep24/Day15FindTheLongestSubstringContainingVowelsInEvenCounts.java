package daily.sep24;

import java.util.*;

public class Day15FindTheLongestSubstringContainingVowelsInEvenCounts {
    public int findTheLongestSubstring(String s) {
        Map<Character, TreeSet<Integer>> indexMap = new HashMap<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(char c : vowels) {
            indexMap.put(c, new TreeSet<>());
        }

        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(indexMap.containsKey(c)) {
                indexMap.get(c).add(i);
            }

            int start = 0;
            boolean shouldUpdate;
            do {
                shouldUpdate = false;
                for(char vowel : indexMap.keySet()) {
                    TreeSet<Integer> indexSet = indexMap.get(vowel);
                    SortedSet<Integer> tailSet = indexSet.tailSet(start);
                    if(tailSet.size() % 2 != 0) {
                        start = Math.max(start, tailSet.getFirst() + 1);
                        shouldUpdate = true;
                    }
                }
            } while (shouldUpdate);

            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }

    public int findTheLongestSubstringOptimised(String s) {
        int[] valueMap = new int[26];
        valueMap['a' - 'a'] = 1;
        valueMap['e' - 'a'] = 2;
        valueMap['i' - 'a'] = 4;
        valueMap['o' - 'a'] = 8;
        valueMap['u' - 'a'] = 16;

        int[] maskPosition = new int[32];
        Arrays.fill(maskPosition, -1);
        int prefixXor = 0, ans = 0;
        for(int i=0; i<s.length(); i++) {
            prefixXor ^= valueMap[s.charAt(i) - 'a'];
            if(maskPosition[prefixXor] == -1 && prefixXor != 0) maskPosition[prefixXor] = i;
            ans = Math.max(ans, i - maskPosition[prefixXor]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Day15FindTheLongestSubstringContainingVowelsInEvenCounts obj = new Day15FindTheLongestSubstringContainingVowelsInEvenCounts();
        System.out.println(obj.findTheLongestSubstringOptimised("leetcodeisgreat"));
    }
}
