package Scaler.Arrays;

public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        int counter = 0;
        for(int i=1; i<=n; i*=10) {
            long divider = 10L * i;
            counter += n/divider * i + Math.min(Math.max(0L, n % divider - i + 1), i);
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(830));
    }
}
