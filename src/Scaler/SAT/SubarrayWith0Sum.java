package Scaler.SAT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubarrayWith0Sum {
    public int solve(ArrayList<Integer> A) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        for(int a : A) {
            sum += a;
            if(seen.contains(sum)) {
                return 1;
            }
            seen.add(sum);
        }

        return 0;
    }
}
