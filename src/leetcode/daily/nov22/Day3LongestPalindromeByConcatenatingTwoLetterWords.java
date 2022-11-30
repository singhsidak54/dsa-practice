package daily.nov22;

import java.util.HashMap;

public class Day3LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int oddPairs = 0;
        boolean evenPair = false;
        for(int i=0; i<words.length; i++) {
            String reverseWord = new StringBuilder(words[i]).reverse().toString();
            if(map.getOrDefault(reverseWord, 0) > 0) {
                oddPairs++;
                map.put(reverseWord, map.getOrDefault(reverseWord, 0) - 1);
            } else {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }

        for(String word : map.keySet()) {
            if(map.get(word) > 0 && word.charAt(0) == word.charAt(1)) {
                evenPair = true;
                break;
            }
        }
        return oddPairs * 4 + (evenPair ? 2 : 0);
    }
}
