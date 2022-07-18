package lc75l1;

public class FibonacciNumber {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int doublePrev = 0;
        int prev = 1, ans = prev;

        for(int i=2; i<=n; i++) {
            ans = prev + doublePrev;
            doublePrev = prev;
            prev = ans;
        }

        return ans;
    }
}
