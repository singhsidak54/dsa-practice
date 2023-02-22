package daily.feb23.weekly;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Week1SentenceSimilarity {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length) return false;
        HashMap<String, Set<String>> similarWords = new HashMap<>();
        for(List<String> pair : similarPairs) {
            if(!similarWords.containsKey(pair.get(0))) {
                similarWords.put(pair.get(0), new HashSet<>());
            }

            similarWords.get(pair.get(0)).add(pair.get(1));
        }

        for(int i=0; i<sentence1.length; i++) {
            if(sentence1[i].equals(sentence2[i])) {
                continue;
            }

            if(similarWords.getOrDefault(sentence1[i], new HashSet<>()).contains(sentence2[i])) {
                continue;
            }

            if(similarWords.getOrDefault(sentence2[i], new HashSet<>()).contains(sentence1[i])) {
                continue;
            }

            return false;
        }

        return true;
    }
}
