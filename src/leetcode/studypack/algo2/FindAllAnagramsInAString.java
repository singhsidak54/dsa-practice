package algo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramsIndexes = new ArrayList<>();
        if(p.length() > s.length()) return anagramsIndexes;

        int[] sCharIndex = new int[26];
        int[] pCharIndex = new int[26];
        for(int i=0; i<p.length(); i++) {
            pCharIndex[p.charAt(i) - 'a']++;
        }

        int anagramStartIndex = 0, i = 0;
        while (i < s.length()) {
            sCharIndex[s.charAt(i) - 'a']++;
            i++;
            if(i - anagramStartIndex == p.length()) {
                if(Arrays.equals(sCharIndex, pCharIndex)) {
                    anagramsIndexes.add(anagramStartIndex);
                }
                sCharIndex[s.charAt(anagramStartIndex) - 'a']--;
                anagramStartIndex++;
            }
        }
        return anagramsIndexes;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc").toString());
    }
}
