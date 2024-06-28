package dp2;

public class FibonacciNumber {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int doublePrev = 0, prev = 1;
        for(int i=2; i<=n; i++) {
            int temp = prev + doublePrev;
            doublePrev = prev;
            prev = temp;
        }

        return prev;
    }
}
