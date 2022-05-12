package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 2;
        for(int i=3; i<=n; i++) {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n];
    }
}
