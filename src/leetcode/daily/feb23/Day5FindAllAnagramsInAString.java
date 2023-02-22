package daily.feb23;

import java.util.ArrayList;
import java.util.List;

public class Day5FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;

        int[] pMap = new int[26];
        int[] sMap = new int[26];
        for(int i=0; i<p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
            sMap[s.charAt(i) - 'a']++;
        }

        int matchCount = 0;
        for(int i=0; i<26; i++) {
            if(pMap[i] == sMap[i]) {
                matchCount++;
            }
        }

        if(matchCount == 26) {
            result.add(0);
        }

        int start = 0;
        for(int end=p.length(); end<s.length(); end++) {
            if(s.charAt(start) != s.charAt(end)) {
                sMap[s.charAt(start) - 'a']--;
                sMap[s.charAt(end) - 'a']++;

                if(sMap[s.charAt(start) - 'a'] == pMap[s.charAt(start) - 'a']) {
                    matchCount++;
                } else if(sMap[s.charAt(start) - 'a'] == pMap[s.charAt(start) - 'a'] - 1) {
                    matchCount--;
                }

                if(sMap[s.charAt(end) - 'a'] == pMap[s.charAt(end) - 'a']) {
                    matchCount++;
                } else if(sMap[s.charAt(end) - 'a'] == pMap[s.charAt(end) - 'a'] + 1) {
                    matchCount--;
                }
            }

            start++;
            if(matchCount == 26) {
                result.add(start);
            }
        }

        return result;
    }
}
