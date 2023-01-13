package Scaler.SAT;

import java.util.ArrayList;

public class MinimumPicks {
    public int solve(ArrayList<Integer> A) {
        int evenMax = Integer.MIN_VALUE, oddMin = Integer.MAX_VALUE;
        for(int a : A) {
            if(a % 2 == 0) {
                evenMax = Math.max(evenMax, a);
            } else {
                oddMin = Math.min(oddMin, a);
            }
        }

        return evenMax - oddMin;
    }
}
