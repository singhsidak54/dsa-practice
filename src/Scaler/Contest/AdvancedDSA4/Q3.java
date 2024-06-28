package Scaler.Contest.AdvancedDSA4;

import java.util.HashMap;

public class Q3 {
    public int solve(String[] A, String[] B) {
        HashMap<String, Integer> aSet = new HashMap<>();
        HashMap<String, Integer> bSet = new HashMap<>();

        for(String word : A) {
            aSet.put(word, aSet.getOrDefault(word, 0) + 1);
        }

        for(String word : B) {
            bSet.put(word, bSet.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for(String key : aSet.keySet()) {
            if(aSet.get(key) == 1 && bSet.getOrDefault(key, 0) == 1) {
                count++;
            }
        }

        return count;
    }
}
