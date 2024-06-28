package Scaler.Hashing;

import java.util.HashMap;
import java.util.Map;

public class PointsOnSameLine {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }

    public int solve(int[] A, int[] B) {
        int n = A.length;
        if(n < 3) return n;

        int ans = 0;
        for(int i=0; i<n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int max = 0, overlap = 0;
            for(int j=i+1; j<n; j++) {
                int dX = A[j] - A[i];
                int dY = B[j] - B[i];

                if(dY == 0 && dX == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(dX, dY);
                dX /= gcd;
                dY /= gcd;

                String key = dX + "-" + dY;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }

            ans = Math.max(ans, max + overlap + 1);
        }

        return ans;
    }
}
