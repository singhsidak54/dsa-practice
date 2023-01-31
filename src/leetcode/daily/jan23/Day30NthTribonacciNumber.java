package daily.jan23;

public class Day30NthTribonacciNumber {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        int t_0 = 0, t_1 = 1, t_2 = 1;
        for(int i=3; i<=n; i++) {
            int temp = t_0 + t_1 + t_2;
            t_0 = t_1;
            t_1 = t_2;
            t_2 = temp;
        }

        return t_2;
    }
}
