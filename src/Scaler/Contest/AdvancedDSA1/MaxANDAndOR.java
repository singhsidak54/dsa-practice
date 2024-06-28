package Scaler.Contest.AdvancedDSA1;

public class MaxANDAndOR {
    public static int solve(int[] A, int B) {
        int and = Integer.MIN_VALUE, or = 0;
        for(int a : A) {
            and = Math.max(and, a);
            or = or | a;
        }

        return and + or;
    }
}
