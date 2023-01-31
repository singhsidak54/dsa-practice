package misc;

import java.util.*;

public class GroupShiftedStrings {
    HashSet<String> wordSet;
    HashSet<String> done;

    HashMap<String, Integer> counter;

    public void dfs(StringBuilder word, List<String> currentGroup, HashSet<String> visited) {
        String currWord = word.toString();
        if(wordSet.contains(currWord)) {
            int times = counter.get(currWord);
            while (times-- > 0) {
                currentGroup.add(currWord);
            }
            done.add(currWord);
        }

        visited.add(word.toString());
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == 'z') {
                word.setCharAt(i, 'a');
            } else {
                word.setCharAt(i, (char) (word.charAt(i) + 1));
            }
        }

        if(!visited.contains(word.toString())) {
            dfs(word, currentGroup, visited);
        }
    }
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        wordSet = new HashSet<>(Arrays.stream(strings).toList());
        done = new HashSet<>();
        counter = new HashMap<>();
        for(String word : strings) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        for(String word : wordSet) {
            if(done.contains(word)) {
                continue;
            }
            List<String> currentGroup = new ArrayList<>();
            dfs(new StringBuilder(word), currentGroup, new HashSet<>());
            result.add(currentGroup);
        }

        return result;
    }

    public static void main(String[] args) {
        GroupShiftedStrings obj = new GroupShiftedStrings();
        String[] words = {"abc","bcd","acef","xyz","az","ba","a","z"};
        System.out.println(obj.groupStrings(words));
    }
}
