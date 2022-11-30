package daily.nov22;

import java.util.*;

public class Day2MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] mutations = {'A', 'C', 'G', 'T'};
        Set<String> currentBank = new HashSet<>(Arrays.asList(bank));
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder(start));
        int mutationsDone = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                StringBuilder currMutation = queue.poll();
                if(currMutation.toString().equals(end)) {
                    return mutationsDone;
                }

                for(int j=0; j<currMutation.length(); j++) {
                    for(char c : mutations) {
                        if(currMutation.charAt(j) == c) {
                            continue;
                        }
                        StringBuilder newMutation = new StringBuilder(currMutation);
                        newMutation.setCharAt(j, c);
                        if(currentBank.contains(newMutation.toString())) {
                            queue.add(newMutation);
                            currentBank.remove(newMutation.toString());
                        }
                    }
                }
            }
            mutationsDone++;
        }

        return -1;
    }
}
