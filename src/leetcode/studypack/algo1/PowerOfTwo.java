package leetcode.studypack.algo1;

// Problem Link - https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n&(n-1)) == 0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
}
