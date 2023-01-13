package daily.jan23.weekly;

public class Week2MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        long ans = 0;
        int max = 0;

        for(int d : damage) {
            if (d > max) {
                ans += max;
                max = d;
            } else {
                ans += d;
            }
        }

        return (max > armor ? ans + max - armor : ans) + 1;
    }
}
