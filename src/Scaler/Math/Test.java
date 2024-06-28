package Scaler.Math;

public class Test {
    public static int solve(int A) {
        int max = 7919;
        int[] primes = new int[7920];
        for(int i=2; i*i<7920; i++) {
            if(primes[i] == 1) continue;
            for(int j=i*i; j<7920; j+=i) {
                primes[j] = 1;
            }
        }

        for(int i=A+1; i<=7919; i++) {
            if(primes[i] == 0) {
                return i;
            }
        }

        return -1;
    }



    public static int solve2(int[] A) {
        long g1 = 0l;
        long g2 = 0l;
        for(int i = 0; i < A.length;i++) {
            if(A[i]>=0) {
                g1+=A[i];
            } else {
                g2+=A[i];
            }
        }

        int mod = 1000000007;
        g1 = (g1%mod*g1%mod)%mod;
        g2 = ((g2+mod)%mod*(g2+mod)%mod)%mod;
        return (int)(g1+g2)%mod;
    }

    public static void main(String[] args) {
        System.out.println(solve2(new int[]{ 2,3,5, -100000}));
    }
}
