package Scaler.BinarySearch;

public class AthMagicalNumber {
    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int solve(int A, int B, int C) {
        long max = (long)Math.min(B, C) * A;
        long l = 1, r = max + 1, m;
        int lcm = B * C/gcd(B,C);
        while(l < r) {
            m = l + (r - l)/2;
            int count = (int)(m/(long)C + m/(long)B - m/(long)lcm);

            if(count < A) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return (int) (l % 1_000_000_007);
    }

    public static void main(String[] args) {
        AthMagicalNumber obj = new AthMagicalNumber();
        System.out.println(obj.solve(1,2,3));
    }
}
