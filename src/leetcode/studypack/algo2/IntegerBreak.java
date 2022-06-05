package algo2;

public class IntegerBreak {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;
    }

    public int integerBreakOptimised(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int num_3 = (int)n/3;
        int remainder = n % 3;
        if (remainder == 1) {
            remainder = 4;
            num_3 --;
        } else if (remainder == 0)
            remainder = 1;

        return (int)Math.pow(3, num_3) * remainder;
    }
}
