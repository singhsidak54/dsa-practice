package companies.Google;

import java.util.*;

public class ShortestWayToFormString {
    public void generateSubsequences(String source, int index, StringBuilder curr, Set<String> set) {
        if(index == source.length()) {
            if(curr.length() != 0) {
                set.add(curr.toString());
            }
            return;
        }

        generateSubsequences(source, index + 1, curr, set);

        curr.append(source.charAt(index));
        generateSubsequences(source, index + 1, curr, set);
        curr.deleteCharAt(curr.length() - 1);
    }

    public int shortestWayBruteForce(String source, String target) {
        Set<String> subsequences = new HashSet<>();
        generateSubsequences(source, 0, new StringBuilder(), subsequences);

        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                String currSub = target.substring(i, j + 1);
                if(subsequences.contains(currSub) && dp[j + 1] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }

    public int shortestWayGreedy(String source, String target) {
        boolean[] charMap = new boolean[26];
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        for(char c : sourceArray) {
            charMap[c - 'a'] = true;
        }

        int j = 0, res = 1;
        for(int i=0; i<targetArray.length; i++) {
            if(!charMap[targetArray[i] - 'a']) return -1;

            while (j != sourceArray.length && sourceArray[j] != targetArray[i]) {
                j++;
            }

            if(j == sourceArray.length) {
                res++;
                i--;
                j = 0;
            } else {
                j++;
            }
        }

        return res;
    }

    private int binarySearchNextIndex(List<Integer> indexList, int j) {
        int l = 0, r = indexList.size(), m;
        while (l < r) {
            m = l + (r - l)/2;
            if(indexList.get(m) < j) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    public int shortestWayGreedyAndBinarySearch(String source, String target) {
        HashMap<Character, List<Integer>> charIndexList = new HashMap<>();
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        for(int i=0; i<sourceArray.length; i++) {
            charIndexList.putIfAbsent(sourceArray[i], new ArrayList<>());
            charIndexList.get(sourceArray[i]).add(i);
        }

        int j = 0, res = 1;
        for(int i=0; i<targetArray.length; i++) {
            if(!charIndexList.containsKey(targetArray[i])) {
                return -1;
            }

            List<Integer> indexList = charIndexList.get(targetArray[i]);
            int nextIndex = binarySearchNextIndex(indexList, j);
            if(nextIndex == indexList.size()) {
                j = 0;
                i--;
                res++;
            } else {
                j = indexList.get(nextIndex) + 1;
            }
        }

        return res;
    }

    public static int shortestWayGreedyOptimised(String source, String target) {
        int[][] charIndexes = new int[26][source.length() + 1];
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        for(int i=0; i<sourceArray.length; i++) {
            charIndexes[sourceArray[i] - 'a'][i] = i + 1;
        }

        for(int i=0; i<26; i++) {
            int pre = 0;
            for(int j=sourceArray.length; j>=0; j--) {
                if(charIndexes[i][j] == 0) {
                    charIndexes[i][j] = pre;
                } else {
                    pre = charIndexes[i][j];
                }
            }
        }

        int j = 0, res = 1;

        for(int i=0; i<targetArray.length; i++) {
            if(charIndexes[targetArray[i] - 'a'][0] == 0) {
                return -1;
            }

            j = charIndexes[targetArray[i] - 'a'][j];
            if(j == 0) {
                res++;
                i--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(shortestWayGreedyOptimised("aaa", "aaaaaa"));
    }
}
