package medium;

import java.util.Scanner;

public class COINS {
    public static long maxByteLandianCoins(long n) {
        if(n == 0) {
            return 0;
        }
        return Math.max
                (n,
                 maxByteLandianCoins(n/2)
                 + maxByteLandianCoins(n/3)
                 + maxByteLandianCoins(n/4));
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = 0;
        while(t < 10 && inp.hasNextLong()) {
            long n = inp.nextLong();
            System.out.println(maxByteLandianCoins(n));
            t++;
        }
    }
}
