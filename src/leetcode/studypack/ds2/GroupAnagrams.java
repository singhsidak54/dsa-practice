package ds2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for(String str: strs) {
            int[] count = new int[26];
            for(int i=0; i<str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder charCount = new StringBuilder("");
            for(int n: count) {
                charCount.append("#");
                charCount.append(n);
            }
            if(!anagramMap.containsKey(charCount.toString())) {
                anagramMap.put(charCount.toString(), new ArrayList<>());
            }
            anagramMap.get(charCount.toString()).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
