package Scaler.Arrays;

import java.util.ArrayList;

public class SpecialIndex {
    public static int solve(ArrayList<Integer> A) {
        int n = A.size(), count = 0;
        int[] prefixOddSum = new int[n + 1];
        int[] prefixEvenSum = new int[n + 1];
        int[] suffixOddSum = new int[n + 1];
        int[] suffixEvenSum = new int[n + 1];

        for(int i=1; i<=n; i++) {
            prefixEvenSum[i] = prefixEvenSum[i - 1];
            prefixOddSum[i] = prefixOddSum[i - 1];

            if((i-1) % 2 == 0) {
                prefixEvenSum[i] += A.get(i - 1);
            } else {
                prefixOddSum[i] += A.get(i - 1);
            }
        }

        for(int i=n-1; i>=0; i--) {
            suffixEvenSum[i] = suffixEvenSum[i + 1];
            suffixOddSum[i] = suffixOddSum[i + 1];

            if(i % 2 == 0) {
                suffixEvenSum[i] += A.get(i);
            } else {
                suffixOddSum[i] += A.get(i);
            }
        }

        for(int i=0; i<n; i++) {
            if(prefixEvenSum[i] + suffixOddSum[i + 1] == prefixOddSum[i] + suffixEvenSum[i + 1]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(solve(list));
    }
}
