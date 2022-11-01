package ps1;

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int diff = high - low;
        int ans = diff/2;

        if((low % 2 != 0) || (high % 2 != 0)) {
            ans++;
        }

        return ans;
    }
}
