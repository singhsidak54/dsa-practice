package Scaler.DP;

import java.util.Arrays;
import java.util.Comparator;

public class UnboundedKnapsack {
    class Pair {
        int weight;
        int value;
        public Pair(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public int solve(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];
        Pair[] pairs = new Pair[B.length];
        for(int i=0; i<B.length; i++) {
            pairs[i] = new Pair(C[i], B[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });

        for(int i=1; i<=A; i++) {
            dp[i] = dp[i - 1];
            for(int j=0; j<pairs.length; j++) {
                if(pairs[j].weight > i) break;
                dp[i] = Math.max(dp[i], dp[i - pairs[j].weight] + pairs[j].value);
            }
        }

        return dp[A];
    }

    public static void main(String[] args) {
        int[] B = {6, 7}, C = {5, 5};
        UnboundedKnapsack obj = new UnboundedKnapsack();
        System.out.println(obj.solve(10, B, C));
    }
}
