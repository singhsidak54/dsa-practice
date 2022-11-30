package daily.nov22;

public class Day16GuessNumberHigherOrLower {
    // api provided by LC
    public int guess(int n) {
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1, r = n, m;
        while(l < r) {
            m = l + (r - l)/2;
            int guessAns = guess(m);
            if(guessAns == 0) {
                return m;
            } else if (guessAns == 1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
