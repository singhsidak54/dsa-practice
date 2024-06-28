package Scaler.BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class SubarrayOR {
    public static int solve(int[] A) {
        int mod = 1_000_000_007, ans = 0;
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for(int num : A) {
            HashMap<Integer, Integer> newMap = new HashMap<>();

            ans = (ans + num) % mod;
            newMap.put(num, 1);

            for(Map.Entry<Integer, Integer> prev : prevMap.entrySet()) {
                int newOr = prev.getKey() | num;
                int newOrCount = prev.getValue();
                newMap.put(newOr, newMap.getOrDefault(newOr, 0) + newOrCount);

                int newOrContribution = ((newOr % mod) * (newOrCount % mod)) % mod;
                ans = (ans + newOrContribution) % mod;
            }

            prevMap = newMap;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] {7,8,9,10}));
    }
}
