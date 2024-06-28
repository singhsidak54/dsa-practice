package Scaler.DP;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner inp = new Scanner(System.in);
        int A = inp.nextInt();

        if(A == 0) {
            System.out.println(0);
        } else if (A == 1) {
            System.out.println(1);
        } else {
            int doublePrev = 0, prev = 1;
            for(int i=2; i<=A; i++) {
                int next = doublePrev + prev;
                doublePrev = prev;
                prev = next;
            }

            System.out.println(prev);
        }
    }
}
