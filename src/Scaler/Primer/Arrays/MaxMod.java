package Scaler.Primer.Arrays;

import java.util.ArrayList;

public class MaxMod {
    public int solve(ArrayList<Integer> A) {
        int max = 0, secondMax = 0;
        for(int a : A) {
            if(a > max) {
                secondMax = max;
                max = a;
            } else if (a > secondMax && a != max) {
                secondMax = a;
            }
        }

        return secondMax;
    }
}
