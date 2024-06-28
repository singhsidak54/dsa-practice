package Scaler.DP;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    class Pair {
        int weight;
        int value;
        public Pair(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }

    public int solve(int[] A, int[] B, int C) {
        Pair[] pairs = new Pair[A.length];
        for(int i=0; i<A.length; i++) {
            pairs[i] = new Pair(B[i], A[i]);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Double.compare(o2.value/(double)o2.weight, o1.value/(double)o1.weight);
            }
        });

        double ans = 0;
        int ptr = 0;
        while (ptr < pairs.length && C > 0) {
            if(C > pairs[ptr].weight) {
                C -= pairs[ptr].weight;
                ans += pairs[ptr].value;
            } else {
                ans += (C * pairs[ptr].value/(double)pairs[ptr].weight);
                C = 0;
            }

            ptr++;
        }

        return (int)(ans * 1000/10);
    }

    public static void main(String[] args) {
        int[] A = {3}, B = {20};
        FractionalKnapsack obj = new FractionalKnapsack();
        System.out.println(obj.solve(A, B, 17));
    }
}
