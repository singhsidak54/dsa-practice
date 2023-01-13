package Scaler.Primer.TimeComplexity;

import java.util.ArrayList;

public class AreaUnderTheHills {
    public String solve(ArrayList<Integer> A) {
        long ans = 0;
        for(int a : A) {
            ans += a;
        }

        return Long.toString(ans);
    }
}
