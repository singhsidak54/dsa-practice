package daily.dec22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        int[] word1Map = new int[26];
        int[] word2Map = new int[26];

        for(char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }

        for(char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }

        List<Integer> word1List = new ArrayList<>();
        List<Integer> word2List = new ArrayList<>();
        for(int i=0; i<26; i++) {
            if(word1Map[i] == word2Map[i]) continue;
            if(word1Map[i] == 0 || word2Map[i] == 0) return false;

            word1List.add(word1Map[i]);
            word2List.add(word2Map[i]);
        }

        Collections.sort(word1List);
        Collections.sort(word2List);

        for(int i=0; i<word1List.size(); i++) {
            if(!word1List.get(i).equals(word2List.get(i))) return false;
        }

        return true;
    }
}
