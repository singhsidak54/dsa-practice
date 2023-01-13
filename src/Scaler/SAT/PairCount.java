package Scaler.SAT;

import java.util.ArrayList;
import java.util.HashMap;

public class PairCount {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> seenMap = new HashMap<>();
        int count = 0;
        for(int a : A) {
            int req = B - a;
            int countReq = seenMap.getOrDefault(req, 0);
            count += countReq;
            seenMap.put(a, seenMap.getOrDefault(a, 0) + 1);
        }

        return count;
    }
}
