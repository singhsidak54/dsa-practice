package Scaler.Math;

public class ConsecutiveNumbersSum {
    public int solve(int A) {
        int count = 1;
        for(int i=1; i*(i + 1)<=2*A; i++) {
            int left = A - (i * (i + 1)/2);
            if(left > 0 && left % (i + 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
