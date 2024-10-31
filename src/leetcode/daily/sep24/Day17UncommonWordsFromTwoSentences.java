package daily.sep24;

import java.util.*;

public class Day17UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> counts = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(String word : s1.split(" ")) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        for(String word : s2.split(" ")) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry : counts.entrySet()) {
            if(entry.getValue() == 1) res.add(entry.getKey());
        }

        String[] ans = new String[res.size()];
        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
