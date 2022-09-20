package lc75l2;

import java.util.HashMap;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 0; int evenCount = 0;

        for(String word : words) {
            if(word.charAt(0) == word.charAt(1)) {
                if(map.containsKey(word) && map.get(word) > 0) {
                    evenCount--;
                    map.put(word, map.get(word) - 1);
                    maxLen += 4;
                } else {
                    evenCount++;
                    map.put(word, 1);
                }
            } else {
                StringBuilder temp = new StringBuilder(word);
                String oppString = temp.reverse().toString();
                if(map.containsKey(oppString) && map.get(oppString) > 0) {
                    map.put(oppString, map.get(oppString) - 1);
                    maxLen += 4;
                } else {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        return evenCount > 0 ? maxLen + 2 : maxLen;
    }


    public int longestPalindrome2(String[] words) {
        int[][] counter = new int[26][26];
        int maxLen = 0;

        for(String word : words) {
            int a = word.charAt(0) - 'a', b = word.charAt(1) - 'a';
            if(counter[b][a] > 0) {
                counter[b][a]--;
                maxLen += 4;
            } else {
                counter[a][b]++;
            }
        }

        for(int i=0; i<26; i++) {
            if(counter[i][i] > 0) {
                maxLen += 2;
                break;
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        String[] words = {"lc", "cl", "gg"};

        System.out.println(longestPalindrome(words));
    }
}
