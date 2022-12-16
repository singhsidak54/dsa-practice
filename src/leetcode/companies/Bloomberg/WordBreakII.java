package companies.Bloomberg;

import java.util.*;

public class WordBreakII {
    Set<String> wordDictSet;

    public void dfs(String s, int index, List<String> curr, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        StringBuilder nextAddition = new StringBuilder();
        for(int i=index; i<s.length(); i++) {
            nextAddition.append(s.charAt(i));
            if(wordDictSet.contains(nextAddition.toString())) {
                curr.add(nextAddition.toString());
                dfs(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordDictSet = new HashSet<>(wordDict);
        List<List<String>> result = new ArrayList<>();
        StringBuilder nextAddition = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            nextAddition.append(s.charAt(i));
            if(wordDictSet.contains(nextAddition.toString())) {
                List<String> potentialList = new ArrayList<>();
                potentialList.add(nextAddition.toString());
                dfs(s, i + 1, potentialList, result);
            }
        }

        List<String> ans = new ArrayList<>();
        for(List<String> curr : result) {
            StringBuilder currAns = new StringBuilder();
            for(String word : curr) {
                currAns.append(word);
                currAns.append(" ");
            }

            currAns.deleteCharAt(currAns.length() - 1);
            ans.add(currAns.toString());
        }

        return ans;
    }
}
