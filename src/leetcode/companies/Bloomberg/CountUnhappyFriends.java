package companies.Bloomberg;

import java.util.HashMap;

public class CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] pairsMap = new int[n];
        for(int[] pair : pairs) {
            pairsMap[pair[0]] = pair[1];
            pairsMap[pair[1]] = pair[0];
        }

        HashMap<Integer, Integer>[] preferencesMap = new HashMap[n];
        for(int i=0; i<n; i++) {
            preferencesMap[i] = new HashMap<>();
            for(int j=0; j<preferences[i].length; j++) {
                preferencesMap[i].put(preferences[i][j], j);
            }
        }

        int unhappyCount = 0;
        for(int i=0; i<n-1; i++) {
            for(int j : preferences[i]) {
                if(preferencesMap[i].get(j) < preferencesMap[i].get(pairsMap[i])
                   && preferencesMap[j].get(pairsMap[j]) > preferencesMap[j].get(i)) {
                    unhappyCount++;
                    break;
                }
            }
        }

        return unhappyCount;
    }
}
