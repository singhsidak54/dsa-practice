package contests.bw99;

public class Q2 {
    public long coloredCells(int n) {
        if(n == 1) {
            return 1;
        }

        long ans = 1, curr = 4L;
        for(int i=2; i<=n; i++) {
            ans += curr;
            curr += 4L;
        }

        return ans;
    }
}
