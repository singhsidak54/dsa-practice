package Scaler.DP;

import java.util.Arrays;
import java.util.Comparator;

public class BuyingCandies {

    class CandyPacket {
        int cost;
        int sweetness;
        public CandyPacket(int cost, int sweetness) {
            this.cost = cost;
            this.sweetness = sweetness;
        }
    }

    public int solve(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        CandyPacket[] packets = new CandyPacket[n];
        for(int i=0; i<n; i++) {
            packets[i] = new CandyPacket(C[i], A[i] * B[i]);
        }

        Arrays.sort(packets, new Comparator<CandyPacket>() {
            @Override
            public int compare(CandyPacket o1, CandyPacket o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        int[] dp = new int[D + 1];
        for(int i=0; i<dp.length; i++) {
            for (CandyPacket packet : packets) {
                if (packet.cost > i) break;
                dp[i] = Math.max(dp[i], packet.sweetness + dp[i - packet.cost]);
            }
        }

        return dp[D];
    }
}
