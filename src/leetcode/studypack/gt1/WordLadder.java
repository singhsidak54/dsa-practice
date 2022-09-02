package gt1;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm','n', 'o', 'p', 'q', 'r','s','t','u','v','w','x', 'y', 'z'};
        Queue<char[]> queue = new LinkedList<>();
        queue.add(beginWord.toCharArray());
        int dist = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                char[] curr = queue.poll();
                if(endWord.equals(new String(curr))) return dist;
                for(int j=0; j<curr.length; j++) {
                    char old = curr[j];
                    for(char c : chars) {
                        curr[j] = c;
                        if(words.contains(new String(curr))) {
                            words.remove(new String(curr));
                            queue.add(curr.clone());
                        }
                    }
                    curr[j] = old;
                }
            }
            dist++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}

