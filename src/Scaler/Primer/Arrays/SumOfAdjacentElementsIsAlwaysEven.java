package Scaler.Primer.Arrays;

import java.util.ArrayList;

public class SumOfAdjacentElementsIsAlwaysEven {
    public int solve(ArrayList<Integer> A) {
        int evens = 0;
        for(int a : A) {
            if(a % 2 == 0) evens++;
        }

        return Math.min(evens, A.size() - evens);
    }
}
