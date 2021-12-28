package easy;

import java.util.Scanner;

public class REPEAT {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int t = inp.nextInt();
        while(t-- > 0) {
            int n = inp.nextInt();
            int k = inp.nextInt();
            int s = inp.nextInt();

            int oddSum = n * n;
            int kSum = s - oddSum;

            int repeat = kSum/(k - 1);
            System.out.println(repeat);
        }
    }
}
