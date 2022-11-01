package daily.oct22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day24MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public static int addToWindow(String word, StringBuilder currWindow) {
        int count = 0;
        for(char c : word.toCharArray()) {
            if(currWindow.charAt(c-'a') == '1') {
                break;
            }
            currWindow.setCharAt(c-'a', '1');
            count++;
        }
        return count;
    }

    public static void removeFromWindow(String word, StringBuilder currWindow, int toRemove) {
        for(int i=toRemove-1; i>=0; i--) {
            currWindow.setCharAt(word.charAt(i) - 'a', '0');
        }
    }

    public static int countSet(StringBuilder currWindow) {
        int count = 0;
        for(int i=0; i<currWindow.length(); i++) {
            if(currWindow.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static int backtrack(List<String> arr, int index, StringBuilder currWindow, HashMap<Integer, HashMap<String, Integer>> dp) {
        if(index == arr.size()) {
            return countSet(currWindow);
        }

        if(dp.get(index).containsKey(currWindow.toString())) {
            return dp.get(index).get(currWindow.toString());
        }

        int exclude = backtrack(arr, index + 1, currWindow, dp);
        int include = 0;
        int charAdded = addToWindow(arr.get(index), currWindow);
        if(charAdded == arr.get(index).length()) {
            include = backtrack(arr, index + 1, currWindow, dp);
        }
        removeFromWindow(arr.get(index), currWindow, charAdded);
        dp.get(index).put(currWindow.toString(), Math.max(exclude, include));
        return Math.max(exclude, include);
    }

    public static int maxLength(List<String> arr) {
        StringBuilder currWindow = new StringBuilder("00000000000000000000000000");
        HashMap<Integer, HashMap<String, Integer>> dp = new HashMap<>();
        for(int i=0; i<arr.size(); i++) {
            dp.put(i, new HashMap<>());
        }

        return backtrack(arr, 0, currWindow, dp);
    }

    public boolean isUnique(String word) {
        boolean[] used = new boolean[26];
        for(char c : word.toCharArray()) {
            if(used[c - 'a']) {
                return false;
            }
            used[c - 'a'] = true;
        }

        return true;
    }

    public int maxLength2(List<String> arr) {
        List<String> concatenatedStrings = new ArrayList<>();
        concatenatedStrings.add("");
        for(int i=0; i<arr.size(); i++) {
            String word = arr.get(i);
            if(!isUnique(word)) {
                continue;
            }

            List<String> currWordList = new ArrayList<>();
            for(int j=0; j<concatenatedStrings.size(); j++) {
                String temp = concatenatedStrings.get(j) + word;
                if(isUnique(temp)) {
                    currWordList.add(temp);
                }
            }
            concatenatedStrings.addAll(currWordList);
        }

        int maxConcatenatedStringLength = 0;
        for(String concatenatedString : concatenatedStrings) {
            maxConcatenatedStringLength = Math.max(maxConcatenatedStringLength, concatenatedString.length());
        }

        return maxConcatenatedStringLength;
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("aa");
        arr.add("bb");
        System.out.println(maxLength(arr));
    }
}
