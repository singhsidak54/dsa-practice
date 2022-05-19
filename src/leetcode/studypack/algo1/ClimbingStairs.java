package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int[] a = new int[n+1];
        a[0] = 0; a[1] = 1; a[2] = 2;
        for(int i=3; i<=n; i++) {
            a[i] = a[i-2] + a[i - 1];
        }
        
        return a[n];
    }
}
