package Scaler.Arrays;

import java.util.ArrayList;

public class PickFromBothSides {
    public static int solve(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        int n = A.size();
        int[] prefixSum = new int[n + 1];
        for(int i=1; i<=n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i - 1);
        }

        for(int i=0; i<=B; i++) {
            max = Math.max(max, prefixSum[i] + (prefixSum[n] - prefixSum[n - B + i]));
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(-2);
        list.add(3);
        list.add(1);
        list.add(2);
        System.out.println(solve(list, 3));
    }
}
