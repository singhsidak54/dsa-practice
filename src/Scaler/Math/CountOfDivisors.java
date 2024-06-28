package Scaler.Math;

import java.util.Arrays;

public class CountOfDivisors {
    static int[] sieve;

    public static void init(int max) {
        sieve = new int[max + 1];

        for(int i=1; i<=max; i++) {
            sieve[i] = i;
        }

        for(int i=2; i*i<=max; i++) {
            if(sieve[i] != i) continue;
            
            for(int j=i*i; j<=max; j+=i) {
                if(sieve[j] > i) {
                    sieve[j] = i;
                }
            }
        }
    }

    public static int countFactors(int num) {
        int ans = 1;

        while(num > 1) {
            int count = 1, spf = sieve[num];
            do {
                count++;
                num /= spf;
            } while(num != 1 && sieve[num] == spf);

            ans *= count;
        }

        return ans;
    }

    public static int[] solve(int[] A) {
        int max = 0;
        for(int a : A) {
            max = Math.max(max, a);
        }

        init(max);

        int[] res = new int[A.length];
        for(int i=0; i<A.length; i++) {
            res[i] = countFactors(A[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {2,3,4,50})));
    }
}
