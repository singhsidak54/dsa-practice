package Scaler.Math;


public class LuckyNumbers {

    public static int solve(int A) {
        int[] divisors = new int[A + 1];

        for(int i=2; i<=A; i++) {
            if(divisors[i] != 0) continue;

            for(int j=i; j<=A; j+=i) {
                divisors[j]++;
            }
        }

        int count = 0;
        for(int divs : divisors) {
            if(divs == 2) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(8));
    }
}
