package daily.jan23;

import java.util.HashMap;

public class Day1WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            Character c = pattern.charAt(i);

            if(patternMap.containsKey(c) && !patternMap.get(c).equals(word)) {
                return false;
            } else if (wordMap.containsKey(word) && wordMap.get(word) != c) {
                return false;
            } else {
                patternMap.put(c, word);
                wordMap.put(word, c);
            }
        }

        return true;
    }
}
