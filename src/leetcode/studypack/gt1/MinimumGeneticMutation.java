package gt1;

import java.util.*;

public class MinimumGeneticMutation {


    public static int minMutation(String start, String end, String[] bank) {
        Character[] possibleChars = {'A', 'C', 'G', 'T'};
        Set<String> allowedMutations = new HashSet<>(Arrays.stream(bank).toList());
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        int dist = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.poll();
                if(curr.equals(end)) return dist;

                char[] currArray = curr.toCharArray();
                for(int j=0; j<currArray.length; j++) {
                    char old = currArray[j];
                    for(char c : possibleChars) {
                        currArray[j] = c;
                        String nextMutation = new String(currArray);
                        if(allowedMutations.contains(nextMutation)) {
                            allowedMutations.remove(nextMutation);
                            queue.add(nextMutation);
                        }
                    }
                    currArray[j] = old;
                }
            }

            dist++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
}
