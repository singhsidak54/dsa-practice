package Scaler.BinarySearch;

public class SquareRoot {
    public static int sqrt(int A) {
        long l = 0, r = A/2 + 1, m;
        while(l < r) {
            m = r - (r - l)/2;
            long sq = m * m;
            if(sq > A) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        return (int) l;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }
}
