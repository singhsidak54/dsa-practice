package lc75l1;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int doublePrev = 1, prev = 2, ans = 2;

        for(int i=3; i<=n; i++) {
            ans = prev + doublePrev;
            doublePrev = prev;
            prev = ans;
        }

        return ans;
    }
}
