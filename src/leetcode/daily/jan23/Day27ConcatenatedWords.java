package daily.jan23;

import java.util.*;

public class Day27ConcatenatedWords {
    Set<String> wordSet;
    List<String> result;

    public boolean dfs(String word, int index) {
        if(index == word.length()) {
            return true;
        }

        StringBuilder curr = new StringBuilder();
        while (index < word.length()) {
            curr.append(word.charAt(index));
            if(wordSet.contains(curr.toString()) && dfs(word, index + 1)) {
                return true;
            }
            index++;
        }

        return false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        wordSet = new HashSet<>();
        result = new ArrayList<>();

        for(String word : words) {
            if(dfs(word, 0)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }
}
