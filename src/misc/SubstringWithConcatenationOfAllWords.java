package misc;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    int wordLength;
    int substringSize;
    int matchesReq;
    HashMap<String, Integer> wordsMap;
    List<Integer> res;

    public void solve(int left, String s) {
        HashMap<String, Integer> currWindowMap = new HashMap<>();
        int matchCount = 0;

        for(int right=left; right+wordLength<=s.length(); right+=wordLength) {
            String word = s.substring(right, right + wordLength);
            if(wordsMap.containsKey(word)) {
                currWindowMap.put(word, currWindowMap.getOrDefault(word, 0) + 1);
                if(currWindowMap.get(word) <= wordsMap.get(word)) {
                    matchCount++;
                } else {
                    while (currWindowMap.get(word) > wordsMap.get(word)) {
                        String temp = s.substring(left, left + wordLength);
                        currWindowMap.put(temp, currWindowMap.get(temp) - 1);
                        if(!temp.equals(word)) {
                            matchCount--;
                        }
                        left += wordLength;
                    }
                }

                if(matchCount == matchesReq) {
                    res.add(left);
                    String temp = s.substring(left, left + wordLength);
                    currWindowMap.put(temp, currWindowMap.get(temp) - 1);
                    left += wordLength;
                    matchCount--;
                }
            } else {
                currWindowMap.clear();
                left = right + wordLength;
                matchCount = 0;
            }
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        res = new ArrayList<>();
        wordLength = words[0].length();
        matchesReq = words.length;
        substringSize = wordLength * matchesReq;
        wordsMap = new HashMap<>();
        for(String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i<wordLength; i++) {
            solve(i, s);
        }

        return res;
    }
}
