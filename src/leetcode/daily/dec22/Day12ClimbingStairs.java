package daily.dec22;

public class Day12ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int prev = 2, doublePrev = 1;
        for(int i=2; i<=n; i++) {
            int curr = prev + doublePrev;
            doublePrev = prev;
            prev = curr;
        }

        return prev;
    }
}
