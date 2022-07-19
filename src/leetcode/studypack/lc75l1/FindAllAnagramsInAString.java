package lc75l1;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public boolean match(int[] sArray, int[] pArray) {
        for(int i=0; i<26; i++) {
            if(sArray[i] != pArray[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();

        if(p.length() > s.length()) {
            return answer;
        }

        int[] sArray = new int[26];
        int[] pArray = new int[26];

        for(int i=0; i<p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }

        for(int i=0; i+p.length()<s.length(); i++) {
            if(match(sArray, pArray)) {
                answer.add(i);
            }

            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i + p.length()) - 'a']++;
        }

        if(match(sArray, pArray)) {
            answer.add(s.length() - p.length());
        }

        return answer;
    }
}
