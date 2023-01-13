package Scaler.SAT;

import java.util.ArrayList;
import java.util.HashMap;

public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> aCounter = new HashMap<>();
        for(int a : A) {
            aCounter.put(a, aCounter.getOrDefault(a, 0) + 1);
        }

        for(int b : B) {
            if(aCounter.containsKey(b)) {
                result.add(b);
                int newCount = aCounter.get(b) - 1;
                if(newCount == 0) {
                    aCounter.remove(b);
                } else {
                    aCounter.put(b, newCount);
                }
            }
        }

        return result;
    }
}
