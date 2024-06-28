package Scaler.DP;

import java.util.ArrayList;

public class MinSumPathInTriangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        for(int i=a.size()-2; i>=0; i--) {
            for(int j=0; j<a.get(i).size(); j++) {
                int curr = a.get(i).get(j);
                a.get(i).set(j, curr + Math.min(a.get(i + 1).get(j), a.get(i + 1).get(j + 1)));
            }
        }

        return a.get(0).get(0);
    }
}
