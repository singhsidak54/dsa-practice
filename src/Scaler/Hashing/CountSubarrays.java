package Scaler.Hashing;

import java.util.HashMap;

public class CountSubarrays {
    public int solve(int[] A) {
        int ans = 0, mod = 1_000_000_007;
        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        for(int i=0; i<A.length; i++) {
            start = Math.max(start, map.getOrDefault(A[i], -1) + 1);
            int current = i - start + 1;

            ans = (ans + current) % mod;
            map.put(A[i], i);
        }

        return ans;
    }
}
