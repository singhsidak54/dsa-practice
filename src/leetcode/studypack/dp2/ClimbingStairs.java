package dp2;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int doublePrev = 1, prev = 2;
        for(int i=3; i<=n; i++) {
            int temp = prev + doublePrev;
            doublePrev = prev;
            prev = temp;
        }

        return prev;
    }
}
